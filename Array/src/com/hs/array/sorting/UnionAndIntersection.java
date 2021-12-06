package com.hs.array.sorting;

import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersection {

	// Prints union of arr1[0..m-1] and arr2[0..n-1]
	private void printUnion(int arr1[], int arr2[]) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < arr1.length; i++)
			set.add(arr1[i]);
		for (int i = 0; i < arr2.length; i++)
			set.add(arr2[i]);
		System.out.println(set);
	}

	// Prints intersection of arr1[0..m-1] and arr2[0..n-1]
	private void printIntersection(int arr1[], int arr2[]) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < arr1.length; i++)
			set.add(arr1[i]);

		for (int i = 0; i < arr2.length; i++)
			if (set.contains(arr2[i]))
				System.out.print(arr2[i] + " ");
	}

	public static void main(String[] args) {
		UnionAndIntersection array = new UnionAndIntersection();
		int arr1[] = { 7, 1, 5, 2, 3, 6 };
		int arr2[] = { 3, 8, 6, 20, 7 };

		System.out.println("Union of two arrays is : ");
		array.printUnion(arr1, arr2);

		System.out.println("Intersection of two arrays is : ");
		array.printIntersection(arr1, arr2);
	}
}