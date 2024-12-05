package com.hs.basic;

import java.util.Stack;

public class ImplementQueueUsingStacks {
	private Stack<Integer> input = new Stack<>();
	private Stack<Integer> output = new Stack<>();

	public void push(int x) {
		input.add(x);
	}

	public int pop() {
		if (output.empty()) {
			while (!input.isEmpty()) {
				output.push(input.pop());
			}
		}
		return output.pop();
	}

	public int peek() {
		if (output.empty()) {
			while (!input.isEmpty()) {
				output.push(input.pop());
			}
		}
		return output.peek();
	}

	public boolean empty() {
		return input.isEmpty() && output.isEmpty();
	}

	public int size() {
		return output.size() + input.size();
	}

	public static void main(String args[]) {
		ImplementQueueUsingStacks q = new ImplementQueueUsingStacks();
		q.push(3);
		q.push(4);
		System.out.println("The element poped is " + q.pop());
		q.push(5);
		System.out.println("The top element is " + q.peek());
		System.out.println("The size of the queue is " + q.size());
	}
}