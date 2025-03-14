package com.hs.medium;

import java.util.Arrays;

public class RotateArray {
	public void rotate(int[] nums, int k) {
		if (nums == null) {
			return;
		}

		int n = nums.length;
		k = k % n;
		reverseArray(nums, 0, n - 1);
		reverseArray(nums, 0, k - 1);
		reverseArray(nums, k, n - 1);
	}

	private void reverseArray(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		RotateArray obj = new RotateArray();
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int d = 2;
		obj.rotate(arr, d);
		System.out.println(Arrays.toString(arr));
	}
}