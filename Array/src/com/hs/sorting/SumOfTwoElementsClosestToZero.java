package com.hs.sorting;

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
		sort(arr, start, end);

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

	private static int partition(int arr[], int start, int end) {
		int pivot = arr[end];
		int pIndex = start;
		for (int i = start; i < end; i++) {
			if (arr[i] < pivot) {
				int tmp = arr[i];
				arr[i] = arr[pIndex];
				arr[pIndex] = tmp;
				pIndex++;
			}
		}
		int tmp = arr[pIndex];
		arr[pIndex] = arr[end];
		arr[end] = tmp;
		return pIndex;
	}

	private static void sort(int arr[], int start, int end) {
		if (start >= end) {
			return;
		}
		int pIndex = partition(arr, start, end);
		sort(arr, start, pIndex - 1);
		sort(arr, pIndex + 1, end);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 60, -10, 70, -80, 85 };
		int n = arr.length;
		minAbsSumPair(arr, n);
	}
}