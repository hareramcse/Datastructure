package com.hs.array.arrangement;

import java.util.Arrays;

public class SegregateEvenOdd {

	static void segregateEvenOdd(int arr[]) {
		/* Initialize left and right indexes */
		int start = 0, end = arr.length - 1;
		while (start < end) {
			/* Increment left index while we see 0 at left */
			while (arr[start] % 2 == 0 && start < end)
				start++;

			/* Decrement right index while we see 1 at right */
			while (arr[end] % 2 == 1 && start < end)
				end--;

			if (start < end) {
				/* Swap arr[left] and arr[right] */
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}
		}
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		int arr[] = { 12, 34, 45, 9, 8, 90, 3 };
		segregateEvenOdd(arr);
		System.out.println(Arrays.toString(arr));
	}
}
