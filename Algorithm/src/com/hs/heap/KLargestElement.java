package com.hs.heap;

import java.util.PriorityQueue;

public class KLargestElement {

	public static void kLargestElement(int arr[], int k) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			minHeap.add(arr[i]);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		System.out.println(minHeap.toString());
	}

	public static void main(String[] args) {
		int arr[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
		int k = 4;
		kLargestElement(arr, k);
	}
}