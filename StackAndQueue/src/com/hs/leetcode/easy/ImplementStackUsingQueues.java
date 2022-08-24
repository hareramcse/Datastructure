package com.hs.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
	Queue<Integer> queue = new LinkedList<>();

	public void push(int x) {
		queue.add(x);
		for (int i = 0; i < queue.size() - 1; i++) {
			queue.add(queue.remove());
		}
	}

	public int pop() {
		return queue.remove();
	}

	public int top() {
		return queue.peek();
	}

	public boolean empty() {
		return queue.isEmpty();
	}

	public int size() {
		return queue.size();
	}

	public static void main(String[] args) {
		ImplementStackUsingQueues s = new ImplementStackUsingQueues();
		s.push(3);
		s.push(2);
		s.push(4);
		s.push(1);
		System.out.println("Top of the stack: " + s.top());
		System.out.println("Size of the stack before removing element: " + s.size());
		System.out.println("The deleted element is: " + s.pop());
		System.out.println("Top of the stack after removing element: " + s.top());
		System.out.println("Size of the stack after removing element: " + s.size());
	}
}