package com.hs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class KDiffPair {
	private int countPairsWithDiffK(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		int ans = 0;
		for (Integer num : map.keySet()) {
			if ((k > 0 && map.containsKey(num + k) || (k == 0 && map.containsKey(num)))) {
				ans++;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		KDiffPair obj = new KDiffPair();
		int arr[] = { 1, 5, 3, 4, 2 };
		int k = 3;
		int result = obj.countPairsWithDiffK(arr, k);
		System.out.println(result);
	}
}