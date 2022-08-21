package com.hs.basic;

import java.util.Arrays;

public class ReverseArray {
	public void reverse(int[] arr, int i, int n) {
		if (i >= n / 2)
			return;
		swap(arr, i, n - i - 1);
		reverse(arr, i + 1, n);
	}

	private void swap(int[] arr, int i, int n) {
		int temp = arr[i];
		arr[i] = arr[n];
		arr[n] = temp;
	}

	public static void main(String[] args) {
		ReverseArray obj = new ReverseArray();
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		obj.reverse(arr, 0, arr.length);
		System.out.println(Arrays.toString(arr));
	}
}