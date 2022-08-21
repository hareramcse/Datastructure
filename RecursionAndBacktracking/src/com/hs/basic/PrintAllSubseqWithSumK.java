package com.hs.basic;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubseqWithSumK {
	public void print(int[] arr, int i, int n, List<Integer> ans, int sum, int k) {
		if (i >= n) {
			if (sum == k) {
				System.out.println(ans);
			}
			return;
		}

		// pick
		ans.add(arr[i]);
		sum = sum + arr[i];
		print(arr, i + 1, n, ans, sum, k);
		ans.remove(ans.size() - 1);
		sum = sum - arr[i];

		// not pick
		print(arr, i + 1, n, ans, sum, k);
	}

	public static void main(String[] args) {
		PrintAllSubseqWithSumK obj = new PrintAllSubseqWithSumK();
		int[] arr = { 1, 2, 1 };
		List<Integer> ans = new ArrayList<>();
		obj.print(arr, 0, arr.length, ans, 0, 2);
	}
}
