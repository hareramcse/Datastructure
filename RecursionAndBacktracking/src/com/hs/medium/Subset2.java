package com.hs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();
		subsetsWithDupUtil(0, nums, ans, new ArrayList<>());
		return ans;
    }
    
    private static void subsetsWithDupUtil(int i, int[] nums, List<List<Integer>> ans, List<Integer> list) {
		ans.add(new ArrayList<>(list));
		for (int k = i; k < nums.length; k++) {
			if (k != i && nums[k] == nums[k - 1])
				continue;
			list.add(nums[k]);
			subsetsWithDupUtil(k + 1, nums, ans, list);
			list.remove(list.size() - 1);
		}
	}
}
