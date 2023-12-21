package com.hs.hard.hard;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {
	private Queue<Integer> smallHeap; // small elements - maxHeap
	private Queue<Integer> largeHeap; // large elements - minHeap

	public FindMedianFromDataStream() {
		smallHeap = new PriorityQueue<>((a, b) -> b - a);
		largeHeap = new PriorityQueue<>((a, b) -> a - b);
	}

	public void addNum(int num) {
		smallHeap.add(num);
		if (smallHeap.size() - largeHeap.size() > 1 || !largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek()) {
			largeHeap.add(smallHeap.poll());
		}
		if (largeHeap.size() - smallHeap.size() > 1) {
			smallHeap.add(largeHeap.poll());
		}
	}

	public double findMedian() {
		if (smallHeap.size() == largeHeap.size()) {
			return (double) (largeHeap.peek() + smallHeap.peek()) / 2;
		} else if (smallHeap.size() > largeHeap.size()) {
			return (double) smallHeap.peek();
		} else {
			return (double) largeHeap.peek();
		}
	}
}
