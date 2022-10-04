package com.hs.leetcode.medium;

public class ShortestUnsortedContinuousSubarray {
	public int findUnsortedSubarray(int[] nums) {
		if (nums.length == 1)
			return 0;

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				if (nums[i] > nums[i + 1]) {
					min = Math.min(min, nums[i]);
					max = Math.max(max, nums[i]);
				}
			} else if (i == nums.length - 1) {
				if (nums[i] < nums[i - 1]) {
					min = Math.min(min, nums[i]);
					max = Math.max(max, nums[i]);
				}
			} else {
				if (nums[i] > nums[i + 1] || nums[i] < nums[i - 1]) {
					min = Math.min(min, nums[i]);
					max = Math.max(max, nums[i]);
				}
			}
		}

		if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
			return 0;
		}

		int i, j;
		for (i = 0; i < nums.length; i++){
            if(nums[i] > min){
                break;
            }
        }
		for (j = nums.length - 1; j >= 0; j--){
            if(nums[j] < max){
                break;
            }
        }

		return j - i + 1;
	}
}
