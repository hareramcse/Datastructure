package com.hs.sorting;

import java.util.Arrays;

public class BubbleSort {
	private void sort(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			System.out.println("array : " + Arrays.toString(arr));
		}
	}

	public static void main(String[] args) {
		int arr[] = { 32, 24, 13, 21 };
		BubbleSort bubbleSort = new BubbleSort();
		System.out.println("data Before sorting " + Arrays.toString(arr));
		bubbleSort.sort(arr);
		System.out.println("data after sorting " + Arrays.toString(arr));
	}
}
