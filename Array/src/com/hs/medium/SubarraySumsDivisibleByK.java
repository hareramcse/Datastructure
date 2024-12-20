package com.hs.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {
	public int subarraysDivByK(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		int sum = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int remainder = sum % k;
			if (remainder < 0)
				remainder += k;

			if (map.containsKey(remainder)) {
				count += map.get(remainder);
			}
			map.put(remainder, map.getOrDefault(remainder, 0) + 1);
		}

		return count;
	}

	public static void main(String[] args) {
		SubarraySumsDivisibleByK obj = new SubarraySumsDivisibleByK();
		int[] nums = { 4, 5, 0, -2, -3, 1 };
		int k = 5;
		int result = obj.subarraysDivByK(nums, k);
		System.out.println(result);
	}
}
