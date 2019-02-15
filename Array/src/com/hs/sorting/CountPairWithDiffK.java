package com.hs.sorting;

import java.util.Arrays;

public class CountPairWithDiffK {

	static int countPairsWithDiffK(int arr[], int n, int k) {
		int count = 0;
		Arrays.sort(arr);

		int start = 0;
		int end = 0;
		while (end < n) {
			if (arr[end] - arr[start] == k) {
				count++;
				start++;
				end++;
			} else if (arr[end] - arr[start] > k)
				start++;
			else // arr[r] - arr[l] < sum
				end++;
		}
		return count;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 5, 3, 4, 2 };
		int n = arr.length;
		int k = 3;
		System.out.println("Count of pairs with given diff is " + countPairsWithDiffK(arr, n, k));
	}
}