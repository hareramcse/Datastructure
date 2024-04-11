package com.hs.basic;

public class CountSubseqWithSumK {
	public int print(int[] arr, int i, int n, int sum, int k) {
		if (i >= n) {
			if (sum == k) {
				return 1;
			} else {
				return 0;
			}
		}

		// pick
		sum = sum + arr[i];
		int left = print(arr, i + 1, n, sum, k);
		sum = sum - arr[i];

		// not pick
		int right = print(arr, i + 1, n, sum, k);
		return left + right;
	}

	public static void main(String[] args) {
		CountSubseqWithSumK obj = new CountSubseqWithSumK();
		int[] arr = { 1, 2, 1 };
		int result = obj.print(arr, 0, arr.length, 0, 2);
		System.out.println(result);
	}
}