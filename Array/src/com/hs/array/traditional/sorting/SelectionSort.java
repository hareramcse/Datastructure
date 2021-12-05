package com.hs.array.traditional.sorting;

import java.util.Arrays;

public class SelectionSort {
	public void sort(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {// last element is already sorted so till n-1
			int minIndex = i; // first lets assume 0th index value is the minimum value in the array
								// it compares like 0th to 1st, 0th to 2nd, 0th to 3rd and so on
			for (int j = i + 1; j < arr.length; j++) {// in each iteration till ith element is sorted, so we need to
														// start comparing from i+1 after each iteration
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
			System.out.println("array : " + Arrays.toString(arr));
		}
	}

	public static void main(String[] args) {
		int arr[] = { 32, 24, 13, 21 };
		SelectionSort selectionSort = new SelectionSort();
		System.out.println("data Before sorting " + Arrays.toString(arr));
		selectionSort.sort(arr);
		System.out.println("data after sorting " + Arrays.toString(arr));
	}
}
