package com.hs.array.rotation;

import java.util.Arrays;

public class NineReverseArray {
	private static void reverse1(int arr[]) {
		int length = arr.length;
		int start = 0;
		int end = length - 1;
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	private static void reverse2(int arr[], int start, int end) {
		int temp;
		if (start >= end)
			return;
		temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		reverse2(arr, start + 1, end - 1);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		NineReverseArray.reverse1(arr);
		System.out.println(Arrays.toString(arr));
		NineReverseArray.reverse2(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
