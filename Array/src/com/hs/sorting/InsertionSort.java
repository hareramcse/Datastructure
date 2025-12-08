package com.hs.sorting;

import java.util.Arrays;

public class InsertionSort {
	private void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int value = arr[i];
			int k = i;
			while (k > 0 && arr[k - 1] > value) {
				arr[k] = arr[k - 1];
				k--;
			}
			arr[k] = value;
			System.out.println("array : " + Arrays.toString(arr));
		}
	}

	public static void main(String[] args) {
		int[] arr = { 32, 24, 13, 21 };
		InsertionSort insertionSort = new InsertionSort();
		System.out.println("data Before sorting " + Arrays.toString(arr));
		insertionSort.sort(arr);
		System.out.println("data after sorting " + Arrays.toString(arr));
	}
}
