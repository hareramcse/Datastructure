package com.hs.basic;

public class MyStackWithDynamicArray {
	private static final int CAPACITY = 2;
	private static final int MINCAPACITY = 1 << 15;
	private int stack[];
	private int capacity;
	private int top;

	public MyStackWithDynamicArray() {
		this(CAPACITY);
	}

	public MyStackWithDynamicArray(int cap) {
		capacity = cap;
		stack = new int[capacity];
		top = -1;
	}

	private void push(int data) throws Exception {
		if (isFull()) {
			expand();
		}
		stack[++top] = data;
	}

	private void expand() {
		int length = size();
		int[] newStack = new int[length << 1];
		System.arraycopy(stack, 0, newStack, 0, length);
		stack = newStack;
		this.capacity = this.capacity << 1;
	}

	private void shrink() {
		int length = top + 1;
		if (length <= MINCAPACITY || top << 2 >= length) {
			return;
		}
		length = length + (top << 1);
		if (top < MINCAPACITY) {
			length = MINCAPACITY;
		}
		int[] newStack = new int[length];
		System.arraycopy(stack, 0, newStack, 0, top + 1);
		stack = newStack;
		this.capacity = length;
	}

	// this method removes and return the top element
	private int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("stack is empty");
		} else {
			int data = stack[top--];
			shrink();
			return data;
		}
	}

	private void printData() {
		for (int i = 0; i <= top; i++) {
			System.out.println(stack[i]);
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
			return stack[top];
		}
	}

	private boolean isFull() {
		return size() == capacity;
	}

	public static void main(String[] args) {
		MyStackWithDynamicArray stack = new MyStackWithDynamicArray();
		try {
			stack.push(10);
			stack.push(20);
			stack.push(30);
			System.out.println("Stack data is ");
			stack.printData();
			stack.pop();
			System.out.println("After pop Stack is");
			stack.printData();
			System.out.print("Stack size is " + stack.size());
			System.out.print("\nStack is Empty : " + stack.isEmpty());
			System.out.print("\nTop element is " + stack.top());
		} catch (Exception e) {
			e.getMessage();
		}

	}
}
