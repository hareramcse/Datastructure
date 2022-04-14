package com.hs.heap;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortAnAlmostSortedArray {

	private void kSort(int[] arr, int k) {
		Queue<Integer> minHeap = new PriorityQueue<>();
		// add first k + 1 items to the min heap
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			minHeap.add(arr[i]);
			if(minHeap.size() > k) {
				arr[index++] = minHeap.poll();
			}
		}

		Iterator<Integer> itr = minHeap.iterator();
		while (itr.hasNext()) {
			arr[index++] = minHeap.poll();
		}
	}

	public static void main(String[] args) {
		SortAnAlmostSortedArray heap = new SortAnAlmostSortedArray();
		int[] arr = { 2, 6, 3, 12, 56, 8 };
		int k = 3;
		heap.kSort(arr, k);
		System.out.println("Following is sorted array");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}