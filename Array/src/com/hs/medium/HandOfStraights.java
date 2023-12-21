package com.hs.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class HandOfStraights {
	public boolean isNStraightHand(int[] hand, int groupSize) {
		Queue<Integer> minHeap = new PriorityQueue<>();
		for (int i : hand) {
			minHeap.add(i);
		}

		while (!minHeap.isEmpty()) {
			int first = minHeap.poll();
			for (int i = 1; i < groupSize; i++) {
				if (!minHeap.remove(first + i)) {
					return false;
				}
			}
		}
		return true;
	}
}
