package com.hs.heap;

import java.util.PriorityQueue;

public class KthLargestElement {
	private int kthSmallest(int[] arr, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			queue.add(arr[i]);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		return queue.peek();
	}

	public static void main(String[] args) {
		KthLargestElement queue = new KthLargestElement();
		int arr[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
		int k = 3;
		int kthSmallest = queue.kthSmallest(arr, k);
		System.out.println(kthSmallest);
	}
}