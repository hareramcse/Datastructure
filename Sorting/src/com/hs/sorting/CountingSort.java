package com.hs.sorting;

public class CountingSort {
	private static void countingSort(int arr[]) {
		int array[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			array[arr[i]] = array[arr[i]] + 1;
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j <= array[i]; j++) {
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 5, 5, 6, 9, 8, 7, 4, 2, 9, 5};

		countingSort(arr);
	}
}
