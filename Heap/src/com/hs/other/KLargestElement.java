package com.hs.other;

import java.util.PriorityQueue;
import java.util.Queue;

public class KLargestElement {

	private void kLargestElement(int arr[], int k) {
		Queue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			minHeap.add(arr[i]);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		System.out.println(minHeap.toString());
	}

	public static void main(String[] args) {
		KLargestElement sol = new KLargestElement();
		int arr[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
		int k = 4;
		sol.kLargestElement(arr, k);
	}
}