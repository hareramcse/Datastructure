package com.hs.stack;

public class MyStackWithArray {
	int top;
	int stack[];
	int size;

	public MyStackWithArray(int size) {
		this.size = size;
		stack = new int[size];
		top = -1;
	}

	private void push(int data) throws Exception {
		if (isFull()) {
			throw new Exception("stack is full");
		} else {
			stack[++top] = data;
		}
	}

	// this method removes and return the top element
	private void pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("stack is empty");
		} else {
			top--;
		}
	}

	private void printData() {
		for (int i = 0; i <= top; i++) {
			System.out.println(stack[i]);
		}
	}

	private int size() {
		return stack.length;
	}

	private boolean isEmpty() {
		return top == -1;
	}

	private boolean isFull() {
		return top == stack.length - 1;
	}

	public static void main(String[] args) {
		MyStackWithArray stack = new MyStackWithArray(5);
		try {
			stack.push(10);
			stack.push(20);
			stack.push(30);
			stack.printData();
			stack.pop();
			System.out.println("after pop stack is");
			stack.printData();
			System.out.println("stack size is " + stack.size());
			System.out.println("stack is Empty : " + stack.isEmpty());
		} catch (Exception e) {
			e.getMessage();
		}

	}
}
