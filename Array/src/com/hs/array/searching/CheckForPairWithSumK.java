package com.hs.array.searching;

import java.util.Arrays;

// this method to find out sum is called 2 pointer technique.
class CheckForPairWithSumK {

	private void printSum(int arr[], int sum) {
		int n = arr.length;
		Arrays.sort(arr);

		int start = 0;
		int end = n - 1;
		while (start < end) {
			if (arr[start] + arr[end] == sum) {
				System.out.println("array has " + arr[start] + " and " + arr[end] + " which sum is " + sum);
				break;
			} else if (arr[start] + arr[end] < sum) {
				start++;
			} else {
				end--;
			}
		}
	}

	public static void main(String args[]) {
		CheckForPairWithSumK array = new CheckForPairWithSumK();
		int arr[] = { 1, 4, 45, 6, 10, -8 };
		int sum = 16;
		array.printSum(arr, sum);
	}
}
