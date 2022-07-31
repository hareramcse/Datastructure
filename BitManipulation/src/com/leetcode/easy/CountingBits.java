package com.leetcode.easy;

import java.util.Arrays;

public class CountingBits {
	public int[] countBits(int n) {
		int[] ans = new int[n + 1];
		ans[0] = 0;

		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {
				ans[i] = ans[i / 2];
			} else {
				ans[i] = ans[i - 1] + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		CountingBits obj = new CountingBits();
		int n = 5;
		int[] result = obj.countBits(n);
		System.out.println(Arrays.toString(result));
	}
}