package com.hs.slidingwindow.variable;

// This will work only for +ve numbers in input
public class LargestSubaArrayOfSumK {

	private int solve(int[] arr, int k) {
		int n = arr.length;
		int i = 0, j = 0, max = Integer.MIN_VALUE, sum = 0;
		while (j < n) {
			sum += arr[j];
			if (sum == k) {
				max = Math.max(max, j - i + 1);
			} else {
				while (sum > k) {
					sum = sum - arr[i];
					i++;
					if (sum == k) {
						max = Math.max(max, j - i + 1);
					}
				}
			}
			j++;
		}
		return max;
	}

	public static void main(String[] args) {
		LargestSubaArrayOfSumK mwsok = new LargestSubaArrayOfSumK();
		int arr[] = { 2, 4, 6, 1, 3, 9, 7, 5, 8 };
		int k = 13;
		int maxWindowsSize = mwsok.solve(arr, k);
		System.out.println(maxWindowsSize);
	}
}