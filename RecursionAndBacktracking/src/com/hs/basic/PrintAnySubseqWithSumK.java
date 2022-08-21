package com.hs.basic;

import java.util.ArrayList;
import java.util.List;

public class PrintAnySubseqWithSumK {
	public boolean print(int[] arr, int i, int n, List<Integer> ans, int sum, int k) {
		if (i >= n) {
			if (sum == k) {
				System.out.println(ans);
				return true;
			} else {
				return false;
			}
		}

		// pick
		ans.add(arr[i]);
		sum = sum + arr[i];
		boolean left = print(arr, i + 1, n, ans, sum, k);
		if (left) {
			return true;
		}
		ans.remove(ans.size() - 1);
		sum = sum - arr[i];

		// not pick
		boolean right = print(arr, i + 1, n, ans, sum, k);
		if (right) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		PrintAnySubseqWithSumK obj = new PrintAnySubseqWithSumK();
		int[] arr = { 1, 2, 1 };
		List<Integer> ans = new ArrayList<>();
		obj.print(arr, 0, arr.length, ans, 0, 2);
	}
}