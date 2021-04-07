package com.hs.stack.geekforgeeks;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PoisonousPlant {

	static class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	static class Linklist {
		Node head;
		Node tail;

		void append(int value) {
			Node node = new Node(value);
			if (tail == null) {
				head = node;
			} else {
				tail.next = node;
			}
			tail = node;
		}

		void append(Linklist list) {
			tail.next = list.head;
			tail = list.tail;
		}

		void removeFirst() {
			head = head.next;
			if (head == null) {
				tail = null;
			}
		}

	}

	// Complete the poisonousPlants function below.
	static int poisonousPlants(int[] P) {
		List<Linklist> parts = new ArrayList<Linklist>();
		Linklist lastPart = null;
		for (int i = 0; i < P.length; i++) {
			if (i > 0 && P[i] <= P[i - 1]) {
				lastPart.append(P[i]);
			} else {
				Linklist part = new Linklist();
				part.append(P[i]);

				parts.add(part);
				lastPart = part;
			}
		}

		int day = 0;
		while (parts.size() > 1) {
			for (int i = 1; i < parts.size(); i++) {
				parts.get(i).removeFirst();
			}

			List<Linklist> nextParts = new ArrayList<Linklist>();
			for (Linklist part : parts) {
				if (part.head == null) {
					continue;
				}

				if (!nextParts.isEmpty() && nextParts.get(nextParts.size() - 1).tail.value >= part.head.value) {
					nextParts.get(nextParts.size() - 1).append(part);
				} else {
					nextParts.add(part);
				}
			}
			parts = nextParts;

			day++;
		}
		return day;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] p = new int[n];

		String[] pItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int pItem = Integer.parseInt(pItems[i]);
			p[i] = pItem;
		}

		int result = poisonousPlants(p);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
