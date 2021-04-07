package com.hs.stack.madeeasy;

import java.util.EmptyStackException;

public class ArrayWithTwoStacks {
	private Integer[] dataArray;
	private int size, topOne, topTwo;

	public ArrayWithTwoStacks(int size) {
		if (size < 2)
			throw new IllegalStateException("size < 2 is no permissble");
		dataArray = new Integer[size];
		this.size = size;
		topOne = -1;
		topTwo = size;
	}

	public void push(int stackId, int data) {
		if (topTwo == topOne + 1)
			throw new StackOverflowError("Array is full");
		if (stackId == 1) {
			dataArray[++topOne] = data;
		} else if (stackId == 2) {
			dataArray[--topTwo] = data;
		} else {
			return;
		}
	}

	public Integer pop(int stackId) {
		if (stackId == 1) {
			if (topOne == -1)
				throw new EmptyStackException();
			int toPop = dataArray[topOne];
			dataArray[topOne--] = null;
			return toPop;
		} else if (stackId == 2) {
			if (topTwo == this.size)
				throw new EmptyStackException();
			int toPop = dataArray[topTwo];
			dataArray[topTwo++] = null;
			return toPop;
		} else {
			return null;
		}
	}

	public Integer top(int stackId) {
		if (stackId == 1) {
			if (topOne == -1)
				throw new EmptyStackException();
			return dataArray[topOne];
		} else if (stackId == 2) {
			if (topTwo == this.size)
				throw new EmptyStackException();
			return dataArray[topTwo];
		} else {
			return null;
		}
	}

	public boolean isEmpty(int stackId) {
		if (stackId == 1) {
			return topOne == -1;
		} else if (stackId == 2) {
			return topTwo == this.size;
		} else {
			return true;
		}
	}

	public void printStack() {
		for (int i = 0; i < dataArray.length; i++) {
			System.out.println(dataArray[i]);
		}
	}

	public static void main(String[] args) {
		ArrayWithTwoStacks stack = new ArrayWithTwoStacks(10);
		stack.push(1, 10);
		stack.push(1, 20);
		stack.push(1, 30);
		stack.push(1, 40);
		stack.push(1, 50);
		stack.push(1, 60);
		
		stack.push(2, 70);
		stack.push(2, 80);
		stack.push(2, 90);
		stack.push(2, 100);
		stack.printStack();
	}
}
