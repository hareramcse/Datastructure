package com.hs.basic;

import java.util.ArrayList;
import java.util.List;

// TC : n*pow(2,n)
// SC : O(n)
public class PrintSubSeq {
	public void print(int[] arr, int i, int n, List<Integer> ans) {
		if (i >= n) {
			System.out.println(ans);
			return;
		}

		// take into seq
		ans.add(arr[i]);
		print(arr, i + 1, n, ans);
		ans.remove(ans.size() - 1);

		// dont take into seq
		print(arr, i + 1, n, ans);
	}

	public static void main(String[] args) {
		PrintSubSeq obj = new PrintSubSeq();
		int[] arr = { 3, 2, 1 };
		List<Integer> ans = new ArrayList<>();
		obj.print(arr, 0, arr.length, ans);
	}
}
