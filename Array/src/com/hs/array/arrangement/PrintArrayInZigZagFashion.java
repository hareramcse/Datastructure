package com.hs.array.arrangement;

import java.util.Arrays;

public class PrintArrayInZigZagFashion {

	// Method for zig-zag conversion of array
	private void zigZag(int[] arr) {
		// Flag true indicates relation "<" is expected,
		// else ">" is expected. The first expected relation
		// is "<"
		boolean flag = true;

		int temp = 0;

		for (int i = 0; i <= arr.length - 2; i++) {
			if (flag) /* "<" relation expected */
			{
				/*
				 * If we have a situation like A > B > C, we get A > B < C by swapping B and C
				 */
				if (arr[i] > arr[i + 1]) {
					// swap
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}

			} else /* ">" relation expected */
			{
				/*
				 * If we have a situation like A < B < C, we get A < C > B by swapping B and C
				 */
				if (arr[i] < arr[i + 1]) {
					// swap
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			flag = !flag; /* flip flag */
		}
	}

	public static void main(String[] args) {
		PrintArrayInZigZagFashion array = new PrintArrayInZigZagFashion();
		int arr[] = new int[] { 4, 3, 7, 8, 6, 2, 1 };
		array.zigZag(arr);
		System.out.println(Arrays.toString(arr));
	}
}