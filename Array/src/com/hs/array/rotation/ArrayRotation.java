package com.hs.array.rotation;

import java.util.Arrays;

public class ArrayRotation {

	private static void rotate(int arr[], int d, int n) {
		int i, j;
		for (i = 0; i < d; i++) {
			int temp = arr[0];
			for (j = 0; j < n - 1; j++) {
				arr[j] = arr[j + 1];
			}
			arr[j] = temp;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int n = arr.length;
		ArrayRotation.rotate(arr, 2, n);
		System.out.println(Arrays.toString(arr));
	}
}
