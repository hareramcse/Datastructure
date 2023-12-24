package com.hs.medium;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {
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
		int result = obj.numberOfSubarrays(arr, k);
		System.out.println(result);
	}
}
