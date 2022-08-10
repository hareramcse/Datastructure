package com.hs.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumNoOfSwapToSortAnArray {

	private int minSwaps(int[] nums) {
		int len = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++)
			map.put(nums[i], i);

		Arrays.sort(nums);

		// To keep track of visited elements. Initialize
		// all elements as not visited or false.
		boolean[] visited = new boolean[len];
		Arrays.fill(visited, false);

		// Initialize result
		int ans = 0;
		for (int i = 0; i < len; i++) {

			// already swapped and corrected or
			// already present at correct pos
			if (visited[i] || map.get(nums[i]) == i)
				continue;

			int j = i, cycle_size = 0;
			while (!visited[j]) {
				visited[j] = true;

				// move to next node
				j = map.get(nums[j]);
				cycle_size++;
			}

			// Update answer by adding current cycle.
			if (cycle_size > 0) {
				ans += (cycle_size - 1);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		MinimumNoOfSwapToSortAnArray array = new MinimumNoOfSwapToSortAnArray();
		int[] arr = { 1, 5, 4, 3, 2 };
		System.out.println(array.minSwaps(arr));
	}
}