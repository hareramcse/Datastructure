package com.hs.array.arrangement;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RearrangeAnArraySuchThatArrOfiEqualToi {

	// Function to rearrange an array such that arr[i] = i.
	public static int[] fix(int[] a) {
		Set<Integer> set = new HashSet<Integer>();

		// Storing all the values in the HashSet
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}

		for (int i = 0; i < a.length; i++) {
			if (set.contains(i))
				a[i] = i;
			else
				a[i] = -1;
		}

		return a;
	}

	public static void main(String[] args) {
		int A[] = { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };

		System.out.println(Arrays.toString(fix(A)));
	}
}
