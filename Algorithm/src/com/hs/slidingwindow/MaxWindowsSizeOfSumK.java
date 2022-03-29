package com.hs.slidingwindow;

public class MaxWindowsSizeOfSumK {

	private int solve(int[] arr, int k) {
		int n = arr.length;
		int i = 0, j = 0, max = Integer.MIN_VALUE, sum = 0;
		while (j < n) {
			sum += arr[j];
			if (sum < k) {
				j++;
			} else if (sum == k) {
				max = Math.max(max, j - i + 1);
				j++;
			} else {
				while (sum > k) {
					sum = sum - arr[i];
					i++;
					if (sum == k) {
						max = Math.max(max, j - i + 1);
					}
				}
				j++;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		MaxWindowsSizeOfSumK mwsok = new MaxWindowsSizeOfSumK();
		int arr[] = { 2, 4, 6, 1, 3, 9, 7, 5, 8 };
		int k = 13;
		int maxWindowsSize = mwsok.solve(arr, k);
		System.out.println(maxWindowsSize);
	}
}
