package com.hs.array.searching;

import java.util.Arrays;

class CheckForPairWithSumK {

	static void hasArrayTwoCandidates(int arr[], int n, int sum) {

		Arrays.sort(arr);

		int start = 0;
		int end = n - 1;
		while (start < end) {
			if (arr[start] + arr[end] == sum) {
				System.out.println("array has " + arr[start] + " and " + arr[end] + " which sum is " + sum);
				break;
			} else if (arr[start] + arr[end] < sum) {
				start++;
			} else { // A[i] + A[j] > sum
				end--;
			}
		}
	}

	public static void main(String args[]) {
		int arr[] = { 1, 4, 45, 6, 10, -8 };
		int sum = 16;
		int n = arr.length;

		hasArrayTwoCandidates(arr, n, sum);
	}
}
