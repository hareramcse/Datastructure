package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> ans = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0)
				ans.add(Math.abs(nums[i]));

			nums[index] = -nums[index];
		}
		return ans;
	}
}
