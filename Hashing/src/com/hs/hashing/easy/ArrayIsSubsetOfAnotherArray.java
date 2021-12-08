package com.hs.hashing.easy;

import java.util.HashSet;
import java.util.Set;

public class ArrayIsSubsetOfAnotherArray {

	/* Return true if arr2[] is a subset of arr1[] */
	private boolean isSubset(int arr1[], int arr2[], int m, int n) {
		Set<Integer> hset = new HashSet<>();

		// hset stores all the values of arr1
		for (int i = 0; i < m; i++) {
			if (!hset.contains(arr1[i]))
				hset.add(arr1[i]);
		}

		// loop to check if all elements
		// of arr2 also lies in arr1
		for (int i = 0; i < n; i++) {
			if (!hset.contains(arr2[i]))
				return false;
		}
		return true;
	}

	// Driver Code
	public static void main(String[] args) {
		ArrayIsSubsetOfAnotherArray array = new ArrayIsSubsetOfAnotherArray();
		int arr1[] = { 11, 1, 13, 21, 3, 7 };
		int arr2[] = { 11, 3, 7, 1 };

		int m = arr1.length;
		int n = arr2.length;

		if (array.isSubset(arr1, arr2, m, n))
			System.out.println("arr2 is a subset of arr1");
		else
			System.out.println("arr2 is not a subset of arr1");
	}

}