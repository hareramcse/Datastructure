package com.hs.sorting;

import java.util.Arrays;

// best or average case O(nlogn) and in worst case O(n2)
public class QuickSort {

	private void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	private void sort(int[] arr, int start, int end) {
		if (start >= end)
			return;

		int pIndex = partition(arr, start, end);
		sort(arr, start, pIndex - 1);
		sort(arr, pIndex + 1, end);
	}

	private int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int pIndex = start; // index for smaller element section
		for (int i = start; i < end; i++) {
			if (arr[i] < pivot) {
				swap(arr, i, pIndex);
				pIndex++;
			}
		}
		swap(arr, pIndex, end); // place pivot in correct sorted position
		return pIndex;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 17, 5, 4, 15, 13, 18, 11 };
		QuickSort quickSort = new QuickSort();
		System.out.println("data Before sorting " + Arrays.toString(arr));
		quickSort.sort(arr);
		System.out.println("data After sorting " + Arrays.toString(arr));
	}
}