package com.hs.medium;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {
	public int numberOfSubarrays(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		// if number is even then make it 0 and if it is odd then make it to 1
		// then problem reduces to number of subArray whose sum = k
		for (int i = 0; i < nums.length; i++) {
			nums[i] %= 2;
		}

		return subarraySum(nums, k);
	}

	private int subarraySum(int[] nums, int k) {
		int count = 0;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		for (int num : nums) {
			sum += num;
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		CountNumberOfNiceSubarrays obj = new CountNumberOfNiceSubarrays();
		int[] arr = { 1, 1, 2, 1, 1 };
		int k = 3;
		int result = obj.numberOfSubarrays(arr, k);
		System.out.println(result);
	}
}