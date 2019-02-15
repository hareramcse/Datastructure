package com.hs.array.sorting;

import java.util.Arrays;

public class SortArrayInWaveForm {

	private static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	// This function sorts arr[0..n-1] in wave form, i.e.,
	// arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4]....
	private static void sortInWave(int arr[], int n) {
		// Traverse all even elements
		for (int i = 0; i < n; i += 2) {
			// If current even index element is smaller than previous
			if (i > 0 && arr[i - 1] > arr[i])
				swap(arr, i - 1, i);

			// If current even index element is smaller than next
			if (i < n - 1 && arr[i] < arr[i + 1])
				swap(arr, i, i + 1);
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int arr[] = { 100, 90, 49, 2, 1, 5, 23 };
		sortInWave(arr, arr.length);
	}
}
