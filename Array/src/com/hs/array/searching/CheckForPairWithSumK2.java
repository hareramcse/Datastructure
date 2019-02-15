package com.hs.array.searching;

import java.util.HashSet;
import java.util.Set;

class CheckForPairWithSumK2 {
	static void printpairs(int arr[], int sum) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; ++i) {
			int temp = sum - arr[i];

			// checking for condition
			if (temp >= 0 && set.contains(temp)) {
				System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + temp + ")");
			}
			set.add(arr[i]);
		}
	}

	public static void main(String[] args) {
		int A[] = { 1, 4, 45, 6, 10, 8, 8};
		int n = 16;
		printpairs(A, n);
	}
}