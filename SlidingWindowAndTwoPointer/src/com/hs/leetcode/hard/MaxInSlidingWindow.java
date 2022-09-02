package com.hs.leetcode.hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxInSlidingWindow {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] result = new int[n - k + 1];
		Deque<Integer> queue = new LinkedList<>();

		int i = 0;
		int j = 0;
		int m = 0;
		while (j < n) {
			while (queue.size() > 0 && queue.peekLast() < nums[j]) {
				queue.removeLast();
			}
			queue.add(nums[j]);

			if (j - i + 1 == k) {
				result[m++] = queue.peek();
				if (queue.peek() == nums[i]) {
					queue.removeFirst();
				}
				i++;
			}
			j++;
		}
		return result;
	}

	public static void main(String[] args) {
		MaxInSlidingWindow sw = new MaxInSlidingWindow();
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		int[] max = sw.maxSlidingWindow(nums, k);
		System.out.println(Arrays.toString(max));
	}
}