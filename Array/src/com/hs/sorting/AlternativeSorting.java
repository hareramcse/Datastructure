package com.hs.sorting;

import java.util.Arrays;

public class AlternativeSorting {
	// Function to print alternate sorted values
	static void alternateSort(int arr[], int n) {
		Arrays.sort(arr);

		// Printing the last element of array
		// first and then first element and then
		// second last element and then second
		// element and so on.
		int start = 0, end = n - 1;
		while (start < end) {
			System.out.print(arr[start] + " ");
			System.out.print(arr[end] + " ");
			start++;
			end--;
		}

		// If the total element in array is odd
		// then print the last middle element.
		if (n % 2 != 0)
			System.out.print(arr[start]);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 12, 4, 6, 7, 10 };
		int n = arr.length;
		alternateSort(arr, n);
	}
}
