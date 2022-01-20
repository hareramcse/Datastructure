package com.hs.greedy;

import java.util.Vector;

public class FindMinmumNumberOfCoins {

	// All denominations of Indian Currency
	private int deno[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
	private int n = deno.length;

	private void findMin(int V) {
		// Initialize result
		Vector<Integer> ans = new Vector<>();

		// Traverse through all denomination
		for (int i = n - 1; i >= 0; i--) {
			// Find denominations
			while (V >= deno[i]) {
				V -= deno[i];
				ans.add(deno[i]);
			}
		}

		// Print result
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(" " + ans.elementAt(i));
		}
	}

	// Driver code
	public static void main(String[] args) {
		FindMinmumNumberOfCoins fmoc = new FindMinmumNumberOfCoins();
		int n = 93;
		System.out.print("Following is minimal number " + "of change for " + n + ": ");
		fmoc.findMin(n);
	}
}
