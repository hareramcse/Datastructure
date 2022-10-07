package com.hs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {
	public int brutForce(int[] nums, int k) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			int odd = 0;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] % k != 0) {
					odd++;
				}
				if (odd == k) {
					max++;
				}
			}
		}
		return max;
	}

	public int numberOfSubarrays(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		int count = 0;
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			count += nums[i] % 2 == 1 ? 1 : 0;
			map.put(count, map.getOrDefault(count, 0) + 1);
			res += map.getOrDefault(count - k, 0);
		}
		return res;
	}

	public static void main(String[] args) {
		CountNumberOfNiceSubarrays obj = new CountNumberOfNiceSubarrays();
		int[] arr = { 1, 1, 2, 1, 1 };
		int k = 3;
		// int result = obj.brutForce(arr, k);
		int result = obj.numberOfSubarrays(arr, k);
		System.out.println(result);
	}
}
