package com.hs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;

            visited[i] = true;
            list.add(nums[i]);
            backtrack(result, list, nums, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

	public static void main(String[] args) {
		Permutation2 obj = new Permutation2();
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> result = obj.permuteUnique(nums);
		System.out.println(result);
	}
}