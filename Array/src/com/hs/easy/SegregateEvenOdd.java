package com.hs.easy;

import java.util.Arrays;

public class SegregateEvenOdd {
	private void segregateEvenOdd(int arr[]) {
		int start = 0, end = arr.length - 1;
		while (start < end) {
			// Increment start index when we see even number in left
			while (arr[start] % 2 == 0 && start < end)
				start++;

			// Decrement right index when we see odd number from right
			while (arr[end] % 2 == 1 && start < end)
				end--;

			if (start < end) {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		SegregateEvenOdd array = new SegregateEvenOdd();
		int arr[] = { 12, 34, 45, 9, 8, 90, 3 };
		array.segregateEvenOdd(arr);
		System.out.println(Arrays.toString(arr));
	}
}