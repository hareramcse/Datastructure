package com.hs.hard.hard;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {
	private Queue<Integer> maxHeap;
	private Queue<Integer> minHeap;

	public FindMedianFromDataStream() {
		maxHeap = new PriorityQueue<>((a, b) -> b - a);
		minHeap = new PriorityQueue<>((a, b) -> a - b);
	}

	public void addNum(int num) {
		maxHeap.add(num);
		minHeap.add(maxHeap.poll());
		if (minHeap.size() > maxHeap.size())
			maxHeap.add(minHeap.poll());
	}

	public double findMedian() {
		if (maxHeap.size() > minHeap.size())
			return maxHeap.peek();
		return (minHeap.peek() + maxHeap.peek()) / 2.0d;
	}

	public static void main(String[] args) {
		FindMedianFromDataStream obj = new FindMedianFromDataStream();
		obj.addNum(3);
		obj.addNum(2);
		obj.addNum(7);
		obj.addNum(4);
		double result = obj.findMedian();
		System.out.println(result);
	}
}
