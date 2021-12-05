package com.hs.array.rotation;

// Maximum sum of i*arr[i] among all rotations of a given array
public class MaximumSumAmongAllRotation {

	private int findMaximumSum(int arr[]) {
		// Compute sum of all array elements
		int arrSum = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++)
			arrSum += arr[i];

		// Compute sum of i*arr[i] for initial configuration.
		int currVal = 0;
		for (int i = 0; i < n; i++)
			currVal += i * arr[i];

		// Initialize result
		int res = currVal;

		// Compute values for other iterations
		for (int i = 1; i < n; i++) {
			// Compute next value using previous value in
			// O(1) time
			/*
			 * nextVal = currVal - (arrSum - arr[i-1]) + arr[i-1] * (n-1);
			 * 
			 * nextVal = Value of ∑i*arr[i] after one rotation. currVal = Current value of
			 * ∑i*arr[i] arrSum = Sum of all array elements, i.e., ∑arr[i].
			 * 
			 * Lets take example {1, 2, 3}. Current value is 1*0+2*1+3*2 = 8. Shifting it by
			 * one will make it {2, 3, 1} and next value will be 8 - (6 - 1) + 1*2 = 5 which
			 * is same as 2*0 + 3*1 + 1*2
			 */
			int nextVal = currVal - (arrSum - arr[i - 1]) + arr[i - 1] * (n - 1);

			// Update current value
			currVal = nextVal;

			// Update result if required
			if (nextVal > res) {
				res = nextVal;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		MaximumSumAmongAllRotation array = new MaximumSumAmongAllRotation();
		int arr[] = { 3, 2, 1 };
		int maxSum = array.findMaximumSum(arr);
		System.out.println("max sum is " + maxSum);
	}
}
