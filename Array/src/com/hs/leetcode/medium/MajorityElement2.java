package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {

	public List<Integer> majorityElement(int[] nums) {
		int candidate1 = Integer.MIN_VALUE, candidate2 = Integer.MIN_VALUE, count1 = 0, count2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == candidate1) {
				count1++;
			} else if (nums[i] == candidate2) {
				count2++;
			} else if (count1 == 0) {
				candidate1 = nums[i];
				count1 = 1;
			} else if (count2 == 0) {
				candidate2 = nums[i];
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}

		List<Integer> ansList = new ArrayList<>();
		int ans1 = 0, ans2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == candidate1)
				ans1++;
			if (nums[i] == candidate2)
				ans2++;
		}

		if (ans1 > nums.length / 3)
			ansList.add(candidate1);
		if (ans2 > nums.length / 3)
			ansList.add(candidate2);

		return ansList;
	}
}