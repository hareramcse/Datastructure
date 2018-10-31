package com.hs.array.rotation;

public class FiveMaxiumValueSumWithOnlyRotation {

	private static void findMaxSum(int arr[]) {
		int arrSum = 0; // Stores sum of arr[i]
		int currVal = 0; // Stores sum of i*arr[i]
		for (int i = 0; i < arr.length; i++) {
			arrSum = arrSum + arr[i];
			currVal = currVal + (i * arr[i]);
		}

		// Initialize result as 0 rotation sum
		int maxVal = currVal;

		// Try all rotations one by one and find the maximum rotation sum.
		for (int j = 1; j < arr.length; j++) {
			currVal = currVal + arrSum - arr.length * arr[arr.length - j];
			if (currVal > maxVal)
				maxVal = currVal;
		}
		System.out.println(maxVal);
	}

	public static void main(String[] args) {
		int arr[] = { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		findMaxSum(arr);
	}
}
