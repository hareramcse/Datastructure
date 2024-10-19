package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0)
				result.add(Math.abs(nums[i]));

			nums[index] = -nums[index];
		}
		return result;
	}

	public static void main(String[] args) {
		FindAllDuplicatesInArray obj = new FindAllDuplicatesInArray();
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> result = obj.findDuplicates(nums);
		System.out.println(result);
	}
}
