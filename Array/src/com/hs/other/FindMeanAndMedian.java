package com.hs.other;

import java.util.Arrays;

class FindMeanAndMedian {
	// Function for calculating mean
	private double findMean(int a[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += a[i];

		return (double) sum / (double) n;
	}

	// Function for calculating median
	private double findMedian(int a[], int n) {
		// First we sort the array
		Arrays.sort(a);

		// check for even case
		if (n % 2 != 0)
			return (double) a[n / 2];

		return (double) (a[(n - 1) / 2] + a[n / 2]) / 2.0;
	}

	public static void main(String args[]) {
		FindMeanAndMedian array = new FindMeanAndMedian();
		int a[] = { 1, 3, 4, 2, 7, 5, 8, 6 };
		int n = a.length;
		System.out.println("Mean = " + array.findMean(a, n));
		System.out.println("Median = " + array.findMedian(a, n));
	}
}