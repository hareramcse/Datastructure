package com.hs.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class BinaryFileBuffer {
	public static int BUFFERSIZE = 2048;
	public BufferedReader bufferedReader;
	public File originalFile;
	private String cache;
	private boolean empty;

	public BinaryFileBuffer(File file) throws IOException {
		originalFile = file;
		bufferedReader = new BufferedReader(new FileReader(file), BUFFERSIZE);
		reload();
	}

	public boolean empty() {
		return empty;
	}

	private void reload() throws IOException {
		try {
			if ((this.cache = bufferedReader.readLine()) == null) {
				empty = true;
				cache = null;
			} else {
				empty = false;
			}
		} catch (EOFException oef) {
			empty = true;
			cache = null;
		}
	}

	public void close() throws IOException {
		bufferedReader.close();
	}

	public String peek() {
		if (empty())
			return null;
		return cache.toString();
	}

	public String pop() throws IOException {
		String answer = peek();
		reload();
		return answer;
	}
}

public class ExternalSort {

	// we divide the file into small blocks. If the blocks
	// are too small, we shall create too many temporary files.
	// If they are too big, we shall be using too much memory.
	public static long estimateBestSizeOfBlocks(File fileToBeSorted) {
		long fileSize = fileToBeSorted.length();
		// we don't want to open up much more than 1024 temporary files, better
		// run out of memory first. (Even 1024 is stretching it.)
		final int MAXTEMPFILES = 1024;
		long blocksize = fileSize / MAXTEMPFILES;
		// on the other hand, we don't want to create many temporary files
		// for naught. If block size is smaller than half free memory, grow it.
		long freeMemory = Runtime.getRuntime().freeMemory();
		if (blocksize < freeMemory / 2)
			blocksize = freeMemory / 2;
		else {
			if (blocksize >= freeMemory)
				System.err.println("We expect to run out of memory. ");
		}
		return blocksize;
	}

	// This will simply load the file by blocks of x rows, then
	// sort them in-memory, and write the result to a bunch of
	// temporary files that have to be merged later.
	public static List<File> sortInBatch(File file,
			Comparator<String> comparator) throws IOException {
		List<File> files = new ArrayList<File>();
		BufferedReader fbr = new BufferedReader(new FileReader(file));
		long blocksize = estimateBestSizeOfBlocks(file);// in bytes
		try {
			List<String> tmpList = new ArrayList<String>();
			String line = "";
			try {
				while (line != null) {
					long currentBlocSize = 0;// in bytes
					while ((currentBlocSize < blocksize)
							&& ((line = fbr.readLine()) != null)) {
						tmpList.add(line);
						// java uses 16 bits per character + 40 bytes of
						// overhead (estimated)
						currentBlocSize += line.length() * 2 + 40;
					}
					files.add(sortAndSave(tmpList, comparator));
					tmpList.clear();
				}
			} catch (EOFException oef) {
				if (tmpList.size() > 0) {
					files.add(sortAndSave(tmpList, comparator));
					tmpList.clear();
				}
			}
		} finally {
			fbr.close();
		}
		return files;
	}

	public static File sortAndSave(List<String> tmpList,
			Comparator<String> comparator) throws IOException {
		Collections.sort(tmpList, comparator);
		File newTempFile = File.createTempFile("sortInBatch", "flatFile");
		newTempFile.deleteOnExit();
		BufferedWriter fbw = new BufferedWriter(new FileWriter(newTempFile));
		try {
			for (String r : tmpList) {
				fbw.write(r);
				fbw.newLine();
			}
		} finally {
			fbw.close();
		}
		return newTempFile;
	}

	// This merges a bunch of temporary flat files
	// @param files
	// @param output file
	// @return The number of lines sorted.
	public static int mergeSortedFiles(List<File> files, File outputFile,
			final Comparator<String> comparator) throws IOException {
		PriorityQueue<BinaryFileBuffer> pq = new PriorityQueue<BinaryFileBuffer>(
				11, new Comparator<BinaryFileBuffer>() {
					public int compare(BinaryFileBuffer binaryFileBuffer1,
							BinaryFileBuffer binaryFileBuffer2) {
						return comparator.compare(binaryFileBuffer1.peek(),
								binaryFileBuffer2.peek());
					}
				});
		for (File file : files) {
			BinaryFileBuffer binaryFileBuffer = new BinaryFileBuffer(file);
			pq.add(binaryFileBuffer);
		}
		BufferedWriter fbw = new BufferedWriter(new FileWriter(outputFile));
		int rowcounter = 0;
		try {
			while (pq.size() > 0) {
				BinaryFileBuffer bfb = pq.poll();
				String r = bfb.pop();
				fbw.write(r);
				fbw.newLine();
				++rowcounter;
				if (bfb.empty()) {
					bfb.bufferedReader.close();
					bfb.originalFile.delete();// we don't need you anymore
				} else {
					pq.add(bfb); // add it back
				}
			}
		} finally {
			fbw.close();
			for (BinaryFileBuffer bfb : pq)
				bfb.close();
		}
		return rowcounter;
	}

	public static void main(String[] args) throws IOException {
		if (args.length < 2) {
			System.out.println("please provide input and output file names");
			return;
		}
		String inputfile = args[0];
		String outputfile = args[1];
		Comparator<String> comparator = new Comparator<String>() {
			public int compare(String r1, String r2) {
				return r1.compareTo(r2);
			}
		};
		List<File> l = sortInBatch(new File(inputfile), comparator);
		mergeSortedFiles(l, new File(outputfile), comparator);
	}
}