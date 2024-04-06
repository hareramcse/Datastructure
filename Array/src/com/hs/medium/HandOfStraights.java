package com.hs.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class HandOfStraights {
	public boolean isNStraightHand(int[] hand, int groupSize) {
		if (hand.length % groupSize != 0)
			return false;
		
		Queue<Integer> minHeap = new PriorityQueue<>();
		for (int i : hand) {
			minHeap.add(i);
		}

		while (!minHeap.isEmpty()) {
			int first = minHeap.poll();

			// it checks next consecutive groupSize cards
			// if its not present it means its not possible to create a group
			for (int i = 1; i < groupSize; i++) {
				if (!minHeap.remove(first + i)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		HandOfStraights obj = new HandOfStraights();
		int[] hand = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
		int groupSize = 3;
		boolean result = obj.isNStraightHand(hand, groupSize);
		System.out.println(result);
	}
}
