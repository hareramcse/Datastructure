package com.hs.array.sorting;

import java.util.Arrays;

public class SumOfTwoElementsClosestToZero {

	static void minAbsSumPair(int arr[], int n) {
		// Variables to keep track of current sum and minimum sum
		int sum, min_sum = 0;

		// left and right index variables
		int start = 0, end = n - 1;

		// variable to keep track of the left and right pair for min_sum
		int min_start = start, min_end = n - 1;

		/* Array should have at least two elements */
		if (n < 2) {
			System.out.println("Invalid Input");
			return;
		}

		/* Sort the elements */
		Arrays.sort(arr, start, end);

		while (start < end) {
			sum = arr[start] + arr[end];

			/* If abs(sum) is less then update the result items */
			if (Math.abs(sum) < Math.abs(min_sum)) {
				min_sum = sum;
				min_start = start;
				min_end = end;
			}
			if (sum < 0)
				start++;
			else
				end--;
		}

		System.out.println("The two elements whose " + "sum is minimum are " + arr[min_start] + " and " + arr[min_end]);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 60, -10, 70, -80, 85 };
		int n = arr.length;
		minAbsSumPair(arr, n);
	}
}