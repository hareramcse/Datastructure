package com.hs.array.arrangement;

public class SplitArrayInTwoPartWithEqualSum {
	// Prints two parts after finding split point using findSplitPoint()
	private void printTwoParts(int arr[]) {
		int n = arr.length;
		int splitPoint = findSplitPoint(arr, n);

		if (splitPoint == -1 || splitPoint == n) {
			System.out.println("Not Possible");
			return;
		}
		for (int i = 0; i < n; i++) {
			if (splitPoint == i)
				System.out.println();

			System.out.print(arr[i] + " ");
		}
	}

	// Returns split point. If not possible, then return -1.
	private int findSplitPoint(int arr[], int n) {
		// traverse array element and compute sum
		// of whole array
		int leftSum = 0;

		for (int i = 0; i < n; i++)
			leftSum += arr[i];

		// again traverse array and compute right
		// sum and also check left_sum equal to
		// right sum or not
		int rightSum = 0;

		for (int i = n - 1; i >= 0; i--) {
			// add current element to right_sum
			rightSum += arr[i];

			// exclude current element to the left_sum
			leftSum -= arr[i];

			if (rightSum == leftSum)
				return i;
		}

		// if it is not possible to split array into two parts.
		return -1;
	}

	public static void main(String[] args) {
		SplitArrayInTwoPartWithEqualSum array = new SplitArrayInTwoPartWithEqualSum();
		int arr[] = { 1, 2, 3, 4, 5, 5 };
		array.printTwoParts(arr);

	}
}