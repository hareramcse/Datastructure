package com.hs.array.arrangement;

public class MaximumSubArrayProduct {
	/*
	 * Returns the product of max product sub array. Assumes that the given array
	 * always has a sub array with product more than 1
	 */
	private int maxSubarrayProduct(int arr[]) {
		int n = arr.length;
		// max positive product
		// ending at the current position
		int max_ending_here = arr[0];

		// min negative product ending
		// at the current position
		int min_ending_here = arr[0];

		// Initialize overall max product
		int max_so_far = arr[0];
		/*
		 * Traverse through the array. the maximum product subarray ending at an index
		 * will be the maximum of the element itself, the product of element and max
		 * product ending previously and the min product ending previously.
		 */
		for (int i = 1; i < n; i++) {
			int temp = Math.max(arr[i], Math.max(arr[i] * max_ending_here, arr[i] * min_ending_here));
			min_ending_here = Math.min(arr[i], Math.min(arr[i] * max_ending_here, arr[i] * min_ending_here));
			max_ending_here = temp;
			max_so_far = Math.max(max_so_far, max_ending_here);
		}
		return max_so_far;
	}

	public static void main(String[] args) {
		MaximumSubArrayProduct array = new MaximumSubArrayProduct();
		int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
		System.out.println("Maximum Sub array product is " + array.maxSubarrayProduct(arr));
	}
}
