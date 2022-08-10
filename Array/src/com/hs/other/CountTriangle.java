package com.hs.other;

import java.util.Arrays;

public class CountTriangle {
	// Function to count all possible triangles with arr[] elements
	private int findNumberOfTriangles(int arr[]) {
		int n = arr.length;

		Arrays.sort(arr);

		int count = 0;

		for (int i = n - 1; i >= 1; i--) {
			int l = 0, r = i - 1;
			while (l < r) {
				if (arr[l] + arr[r] > arr[i]) {

					// If it is possible with a[l], a[r]
					// and a[i] then it is also possible
					// with a[l+1]..a[r-1], a[r] and a[i]
					count += r - l;

					// checking for more possible solutions
					r--;
				} else // if not possible check for
				// higher values of arr[l]
				{
					l++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		CountTriangle array = new CountTriangle();
		int arr[] = { 4, 3, 5, 7, 6 };
		System.out.println("Total number of triangles is " + array.findNumberOfTriangles(arr));
	}
}