package com.hs.searching;

import java.util.HashSet;
import java.util.Set;

class CountPairsWithGivenSum {

	static int countPairs(int arr[], int sum) {
		int count = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; ++i) {
			int temp = sum - arr[i];

			// checking for condition
			if (temp >= 0 && set.contains(temp)) {
				count++;
			}
			set.add(arr[i]);
		}
		return count;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 5, 7, -1, 5 };
		int sum = 6;
		System.out.println("Count of pairs is " + countPairs(arr, sum));
	}
}