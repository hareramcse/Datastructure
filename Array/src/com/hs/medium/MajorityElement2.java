package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
	public List<Integer> majorityElement(int[] nums) {
		int candidate1 = Integer.MIN_VALUE, candidate2 = Integer.MIN_VALUE, count1 = 0, count2 = 0;

		// Finding candidate
		for (int num : nums) {
			if (candidate1 == num) {
				count1++;
			} else if (candidate2 == num) {
				count2++;
			} else if (count1 == 0) {
				candidate1 = num;
				count1 = 1;
			} else if (count2 == 0) {
				candidate2 = num;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}

		// Verifying candidate
		List<Integer> ansList = new ArrayList<>();
		int ans1 = 0, ans2 = 0;
		for (int num : nums) {
			if (candidate1 == num)
				ans1++;
			if (candidate2 == num)
				ans2++;
		}

		// Checking if candidate is majority element
		if (ans1 > nums.length / 3)
			ansList.add(candidate1);
		if (ans2 > nums.length / 3)
			ansList.add(candidate2);

		return ansList;
	}
}