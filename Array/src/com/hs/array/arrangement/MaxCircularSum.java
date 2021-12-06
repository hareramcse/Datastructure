package com.hs.array.arrangement;

public class MaxCircularSum {

	// The function returns maximum circular contiguous sum in a[]
	private int maxCircularSum(int arr[]) {
		int n = arr.length;

		// Case 1: get the maximum sum using standard kadane's algorithm
		int max_kadane = kadane(arr);

		// Case 2: Now find the maximum sum that includes corner elements.
		int max_arr_sum = 0;
		for (int i = 0; i < n; i++) {
			max_arr_sum += arr[i]; // Calculate arraySum
			arr[i] = -arr[i]; // invert the array (change sign)
		}

		// max sum with corner elements will be: arraySum - (-max subarray sum of
		// inverted array)
		max_arr_sum = max_arr_sum + kadane(arr);

		// The maximum circular sum will be maximum of two sums
		return max_arr_sum > max_kadane ? max_arr_sum : max_kadane;
	}

	// Standard Kadane's algorithm to find maximum subarray sum
	private int kadane(int arr[]) {
		int n = arr.length;
		int max_so_far = 0, max_ending_here = 0;
		for (int i = 0; i < n; i++) {
			max_ending_here = max_ending_here + arr[i];
			if (max_ending_here < 0)
				max_ending_here = 0;
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		return max_so_far;
	}

	public static void main(String[] args) {
		MaxCircularSum array = new MaxCircularSum();
		int a[] = { 11, 10, -20, 5, -3, -5, 8, -13, 10 };
		System.out.println("Maximum circular sum is: " + array.maxCircularSum(a));
	}
}