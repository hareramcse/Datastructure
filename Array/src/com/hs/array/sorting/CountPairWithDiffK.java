package com.hs.array.sorting;

import java.util.Arrays;

public class CountPairWithDiffK {

	private int countPairsWithDiffK(int arr[], int k) {
		int n = arr.length;
		Arrays.sort(arr);

		int count = 0;
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
		CountPairWithDiffK array = new CountPairWithDiffK();
		int arr[] = { 1, 5, 3, 4, 2 };
		int k = 3;
		System.out.println("Count of pairs with given diff is " + array.countPairsWithDiffK(arr, k));
	}
}