package com.hs.dp.mcm;

public class MCMRecursive {

	private int solve(int[] arr, int i, int j) {
		if (i >= j) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int k = i; k < j; k++) {
			int temp = solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
			min = Math.min(min, temp);
		}
		return min;
	}

	public static void main(String[] args) {
		MCMRecursive mcm = new MCMRecursive();
		int[] arr = { 1, 2, 3, 4, 3 };
		int i = 1;
		int j = arr.length - 1;
		int ans = mcm.solve(arr, i, j);
		System.out.println(ans);
	}
}