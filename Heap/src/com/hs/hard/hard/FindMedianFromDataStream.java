package com.hs.hard.hard;

import java.util.PriorityQueue;
import java.util.Queue;

// maxHeap to store all the element smaller than minHeap
// minHeap to store all the elements greater than MaxHeap
// initially add all the elements in maxHeap and eventually based on condition 
// 1) difference in Heap size should not be > 1
// 2) all the elements in the maxHeap <= minHeap
public class FindMedianFromDataStream {
	private Queue<Integer> maxHeap;
	private Queue<Integer> minHeap;

	public FindMedianFromDataStream() {
		maxHeap = new PriorityQueue<>((a, b) -> b - a);
		minHeap = new PriorityQueue<>((a, b) -> a - b);
	}

	public void addNum(int num) {
		maxHeap.add(num);
		if (maxHeap.size() - minHeap.size() > 1 || !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
			minHeap.add(maxHeap.poll());
		}
		if (minHeap.size() - maxHeap.size() > 1) {
			maxHeap.add(minHeap.poll());
		}
	}

	public double findMedian() {
		if (maxHeap.size() == minHeap.size()) {
			return (double) (minHeap.peek() + maxHeap.peek()) / 2;
		} else if (maxHeap.size() > minHeap.size()) {
			return (double) maxHeap.peek();
		} else {
			return (double) minHeap.peek();
		}
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
