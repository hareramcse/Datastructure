package com.hs.array.arrangement;

import java.util.Arrays;

public class SegregateZeroAndOne {

	static int[] segregateZeroAndOne(int arr[]) {
		/* Initialize left and right indexes */
		int left = 0, right = arr.length - 1;
		while (left < right) {
			/* Increment left index while we see 0 at left */
			while (arr[left] == 0 && left < right)
				left++;

			/* Decrement right index while we see 1 at right */
			while (arr[right] == 1 && left < right)
				right--;

			if (left < right) {
				/* Swap arr[left] and arr[right] */
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 };
		int temp[] = segregateZeroAndOne(arr);
		System.out.println(Arrays.toString(temp));
	}
}
