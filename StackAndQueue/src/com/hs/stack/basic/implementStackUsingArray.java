package com.hs.stack.basic;

public class implementStackUsingArray {
	private int top;
	private int[] arr;
	private int capacity;

	public implementStackUsingArray(int size) {
		this.capacity = size;
		arr = new int[size];
		top = -1;
	}

	private void push(int data) throws Exception {
		if (isFull()) {
			throw new Exception("stack is full");
		} else {
			arr[++top] = data;
		}
	}

	private int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("stack is empty");
		} else {
			return arr[top--];
		}
	}

	private void printData() {
		for (int i = 0; i <= top; i++) {
			System.out.println(arr[i]);
		}
	}

	private int size() {
		return top + 1;
	}

	private boolean isEmpty() {
		return top < 0;
	}

	private int top() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is empty");
		} else {
			return arr[top];
		}
	}

	private boolean isFull() {
		return size() == capacity;
	}

	public static void main(String[] args) {
		implementStackUsingArray stack = new implementStackUsingArray(5);
		try {
			stack.push(10);
			stack.push(20);
			stack.push(30);
			System.out.println("Stack data is ");
			stack.printData();
			stack.pop();
			System.out.println("after pop stack is");
			stack.printData();
			System.out.print("stack size is " + stack.size());
			System.out.print("\nstack is Empty : " + stack.isEmpty());
			System.out.print("\ntop element is " + stack.top());
		} catch (Exception e) {
			e.getMessage();
		}
	}
}