package com.hs.array.traditional.sorting;

import java.util.Arrays;
import java.util.Random;

/*
 This program measures the runtime of the merge sort algorithm,
 in both a standard sequential version and a parallel version
 that uses multiple threads.

 original:
 1024000 elements  =>     219 ms 
 2048000 elements  =>     469 ms 
 4096000 elements  =>     968 ms 
 8192000 elements  =>    1985 ms 
 16384000 elements  =>    4094 ms 
 32768000 elements  =>    8110 ms 


 parallel (2 threads):
 1024000 elements  =>     141 ms 
 2048000 elements  =>     328 ms 
 4096000 elements  =>     610 ms 
 8192000 elements  =>    1344 ms 
 16384000 elements  =>    2563 ms 
 32768000 elements  =>    5095 ms 

 parallel (4 threads):
 1024000 elements  =>     110 ms 
 2048000 elements  =>     203 ms 
 4096000 elements  =>     438 ms 
 8192000 elements  =>     984 ms 
 16384000 elements  =>    1797 ms 
 32768000 elements  =>    3547 ms
 */
class Sorter implements Runnable {
	int[] a;
	int threadCount;

	Sorter(int[] a, int threadCount) {
		this.a = a;
		this.threadCount = threadCount;
	}

	@Override
	public void run() {
		MultiThreadedMergeSort.parallelMergeSort(a, threadCount);
	}
}

public class MultiThreadedMergeSort {
	// Random number generator
	private static final Random random = new Random(42);

	public static void parallelMergeSort(int[] arr) {
		int cores = Runtime.getRuntime().availableProcessors();
		parallelMergeSort(arr, cores);
	}

	public static void parallelMergeSort(int[] arr, int cores) {
		if (cores <= 1) {
			mergeSort(arr);
		} else if (arr.length >= 2) {
			// split array in half
			int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
			int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

			// sort the halves
			Thread lThread = new Thread(new Sorter(left, cores / 2));
			Thread rThread = new Thread(new Sorter(right, cores / 2));
			lThread.start();
			rThread.start();

			try {
				lThread.join();
				rThread.join();
			} catch (InterruptedException ie) {
			}

			// merge them back together
			merge(left, right, arr);
		}
	}

	public static void mergeSort(int[] a) {
		if (a.length >= 2) {
			// split array in half
			int[] left = Arrays.copyOfRange(a, 0, a.length / 2);
			int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);

			// sort the halves
			mergeSort(left);
			mergeSort(right);

			// merge them back together
			merge(left, right, a);
		}
	}

	private static void merge(int[] left, int[] right, int[] result) {
		// Index Position in left array - starting with first element
		int i = 0;
		// Index Position in right array - starting with first element
		int j = 0;
		// Index Position in merged array - starting with first position
		int k = 0;
		int sizeOfLeftArray = left.length;
		int sizeOfRightArray = right.length;
		// Compare with left array element and right array element,
		// and move smaller element in resulting array
		while (i < sizeOfLeftArray && j < sizeOfRightArray) {
			if (left[i] < right[j]) {
				result[k++] = left[i++];
			} else {
				result[k++] = right[j++];
			}
		}
		while (i < sizeOfLeftArray) {
			result[k++] = left[i++];
		}
		while (j < sizeOfRightArray) {
			result[k++] = right[j++];
		}
	}

	// Returns true if the given array is in sorted ascending order.
	public static boolean isSorted(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}
		return true;
	}

	// Creates an array of the given length, fills it with random
	// non-negative integers, and returns it.
	public static int[] createRandomArray(int length) {
		int[] a = new int[length];
		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(1000000);
		}
		return a;
	}

	public static void main(String[] args) throws Throwable {
		int LENGTH = 1000; // initial length of array to sort
		int RUNS = 16; // how many times to grow by 2?

		for (int i = 1; i <= RUNS; i++) {
			int[] a = createRandomArray(LENGTH);

			// run the algorithm and time how long it takes
			long startTime1 = System.currentTimeMillis();
			parallelMergeSort(a);
			// mergeSort(a);
			long endTime1 = System.currentTimeMillis();

			if (!isSorted(a)) {
				throw new RuntimeException("not sorted afterward: "
						+ Arrays.toString(a));
			}

			System.out.printf("%10d elements  =>  %6d ms \n", LENGTH, endTime1
					- startTime1);
			LENGTH *= 2; // double size of array for next time
		}
	}
}