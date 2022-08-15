package com.hs.leetcode.medium;

import java.util.Arrays;

public class RotateArray {
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		if (nums == null || n == 1) {
			return;
		}

		k = k % n;
		int a = nums.length - k;
		reverseArray(nums, 0, a - 1);
		reverseArray(nums, a, n - 1);
		reverseArray(nums, 0, n - 1);
	}

	private void reverseArray(int arr[], int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		RotateArray rotation = new RotateArray();
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int d = 2;
		rotation.rotate(arr, d);
		System.out.println(Arrays.toString(arr));
	}
}