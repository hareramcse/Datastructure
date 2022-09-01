package com.hs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

//TODO using sliding window approach
public class SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

	public static void main(String[] args) {
		SubarraySumEqualsK obj = new SubarraySumEqualsK();
		int[] nums = { 1, 2, 3 };
		int k = 3;
		int result = obj.subarraySum(nums, k);
		System.out.println(result);
	}
}