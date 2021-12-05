package com.hs.array.rotation;

import java.util.HashSet;
import java.util.Set;

public class PairSumWithHashing {

	private void printPairs(int arr[], int sum) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			int temp = sum - arr[i];

			// checking for condition
			if (temp >= 0 && set.contains(temp)) {
				System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + temp + ")");
			}
			set.add(arr[i]);
		}
	}

	public static void main(String[] args) {
		PairSumWithHashing array = new PairSumWithHashing();
		int A[] = { 1, 4, 45, 6, 10, 8 };
		int n = 16;
		array.printPairs(A, n);
	}
}