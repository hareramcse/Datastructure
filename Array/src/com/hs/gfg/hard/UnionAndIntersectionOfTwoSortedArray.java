package com.hs.gfg.hard;

import java.util.ArrayList;
import java.util.List;

public class UnionAndIntersectionOfTwoSortedArray {
	public List<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
		int i = 0, j = 0; // pointers
		List<Integer> union = new ArrayList<>(); // Uninon vector
		while (i < n && j < m) {
			if (arr1[i] <= arr2[j]) // Case 1 and 2
			{
				if (union.size() == 0 || union.get(union.size() - 1) != arr1[i])
					union.add(arr1[i]);
				i++;
			} else // case 3
			{
				if (union.size() == 0 || union.get(union.size() - 1) != arr2[j])
					union.add(arr2[j]);
				j++;
			}
		}
		while (i < n) // IF any element left in arr1
		{
			if (union.get(union.size() - 1) != arr1[i])
				union.add(arr1[i]);
			i++;
		}
		while (j < m) // If any elements left in arr2
		{
			if (union.get(union.size() - 1) != arr2[j])
				union.add(arr2[j]);
			j++;
		}
		return union;
	}

	public List<Integer> findIntersction(int arr1[], int arr2[], int n, int m) {
		List<Integer> ans = new ArrayList<>();

		int i = 0, j = 0; // to traverse the arrays

		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) { // if current element in i is smaller
				i++;
			} else if (arr2[j] < arr1[i]) {
				j++;
			} else {
				ans.add(arr1[i]); // both elements are equal
				i++;
				j++;
			}
		}
		return ans;
	}
}
