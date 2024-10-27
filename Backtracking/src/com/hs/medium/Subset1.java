package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class Subset1 {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

	public static void main(String[] args) {
		Subset1 obj = new Subset1();
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> result = obj.subsets(nums);
		System.out.println(result);
	}
}
