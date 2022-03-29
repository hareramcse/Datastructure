package com.hs.slidingwindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxInSlidingWindow {
	private List<Integer> maxSlidingWindow(int[] nums, int k) {
		List<Integer> result = new ArrayList<>();
		Deque<Integer> queue = new LinkedList<>();

		int i = 0;
		int j = 0;

		while (j < nums.length) {
			// calculation
			if (queue.size() == 0) {
				queue.add(nums[j]);
			} else {
				while (queue.size() > 0 && queue.peekLast() < nums[j]) {
					queue.removeLast();
				}
				queue.add(nums[j]);
			}
			// now move j pointer
			if (j - i + 1 < k)
				j++;
			// if we hit the window size
			else if (j - i + 1 == k) {
				// answer -> calculation;
				result.add(queue.peek());
				// slide the window calculation
				if (nums[i] == queue.peek()) {
					queue.removeFirst();
				}
				// now slide the pointer
				i++;
				j++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MaxInSlidingWindow minsw = new MaxInSlidingWindow();
		int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
		List<Integer> max = minsw.maxSlidingWindow(arr, 3);
		System.out.println(max);
	}
}
