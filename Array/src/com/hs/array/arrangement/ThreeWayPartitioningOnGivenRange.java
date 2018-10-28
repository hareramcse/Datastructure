package com.hs.array.arrangement;

import java.util.Arrays;

public class ThreeWayPartitioningOnGivenRange {

	// Partitions arr[0..n-1] around [lowVal..highVal]
	public static void threeWayPartition(int[] arr, int lowVal, int highVal) {

		int n = arr.length;

		// Initialize ext available positions for
		// smaller (than range) and greater elements
		int start = 0, end = n - 1;

		// Traverse elements from left
		for (int i = 0; i < end;) {
			// If current element is smaller than
			// range, put it on next available smaller position.
			if (arr[i] < lowVal) {
				int temp = arr[start];
				arr[start] = arr[i];
				arr[i] = temp;
				start++;
				i++;
			}

			// If current element is greater than
			// range, put it on next available greater position.
			else if (arr[i] > highVal) {
				int temp = arr[end];
				arr[end] = arr[i];
				arr[i] = temp;
				end--;
			} else
				i++;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 14, 5, 25, 4, 34, 22};
		int low = 10;
		int high = 20;
		threeWayPartition(arr, low, high);
		System.out.println(Arrays.toString(arr));
	}
}
