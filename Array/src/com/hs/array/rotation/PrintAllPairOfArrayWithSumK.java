package com.hs.array.rotation;

public class PrintAllPairOfArrayWithSumK {

	// This function returns count of number of pairs with sum equals to x.
	static int pairsInSortedRotated(int arr[], int n, int x) {
		// Find largest element of array.
		int i;
		for (i = 0; i < n - 1; i++)
			if (arr[i] > arr[i + 1])
				break;

		// l is index of smallest element.
		int low = (i + 1) % n;

		// r is index of largest element.
		int high = i;

		// Variable to store count of number of pairs.
		int count = 0;

		// Find sum of pair formed by arr[l]
		// and arr[r] and update l, r and cnt accordingly.
		while (low != high) {
			// If we find a pair with sum x, then increment
			// cnt, move l and r to next element.
			if (arr[low] + arr[high] == x) {
				count++;

				// This condition is required to be checked, otherwise low
				// and high will cross each other and loop will never terminate.
				if (low == (high - 1 + n) % n) {
					return count;
				}

				low = (low + 1) % n;
				high = (high - 1 + n) % n;
			}

			// If current pair sum is less, move to the higher sum side.
			else if (arr[low] + arr[high] < x)
				low = (low + 1) % n;

			// If current pair sum is greater, move to the lower sum side.
			else
				high = (n + high - 1) % n;
		}

		return count;
	}

	public static void main(String[] args) {
		int arr[] = { 11, 15, 6, 7, 9, 10 };
		int sum = 16;
		int n = arr.length;

		System.out.println(pairsInSortedRotated(arr, n, sum));
	}
}