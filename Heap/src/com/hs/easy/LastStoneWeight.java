package com.hs.easy;

import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
	public int lastStoneWeight(int[] stones) {
		Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
		for (int stone : stones) {
			maxHeap.add(stone);
		}

		while (maxHeap.size() > 1) {
			int x = maxHeap.poll();
			int y = maxHeap.poll();
			if (y <= x) {
				maxHeap.add(x - y);
			}
		}

		return maxHeap.size() == 0 ? 0 : maxHeap.peek();
	}

	public static void main(String[] args) {
		LastStoneWeight obj = new LastStoneWeight();
		int[] nums = { 2, 7, 4, 1, 8, 1 };
		int result = obj.lastStoneWeight(nums);
		System.out.println(result);
	}
}
