package com.hs.stack.madeeasy;

import java.util.EmptyStackException;

public class ArrayWithThreeStacks {
	private Integer[] dataArray;
	private int size, topOne, topTwo, baseThree, topThree;

	public ArrayWithThreeStacks(int size) {
		if (size < 3)
			throw new IllegalStateException("size < 3 is no permissble");
		dataArray = new Integer[size];
		this.size = size;
		topOne = -1;
		topTwo = size;
		baseThree = size / 2;
		topThree = baseThree;
	}

	public void push(int stackId, int data) {
		if (stackId == 1) {
			if (topOne + 1 == baseThree) {
				if (stack3IsRightShiftable()) {
					shiftStack3ToRight();
					dataArray[++topOne] = data;
				} else {
					throw new StackOverflowError("Stack1 has reached max limit");
				}
			} else {
				dataArray[++topOne] = data;
			}
		} else if (stackId == 2) {
			if (topTwo - 1 == topThree) {
				if (stack3IsLeftShiftable()) {
					shiftStack3ToLeft();
					dataArray[--topTwo] = data;
				} else {
					throw new StackOverflowError("Stack2 has reached max limit");
				}
			} else {
				dataArray[--topTwo] = data;
			}
		} else if (stackId == 3) {
			if (topTwo - 1 == topThree) {
				if (stack3IsLeftShiftable()) {
					shiftStack3ToLeft();
					dataArray[++topThree] = data;
				} else {
					throw new StackOverflowError("Stack3 has reached max limit");
				}
			} else {
				dataArray[++topThree] = data;
			}
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
		} else if (stackId == 3) {
			if (topTwo == this.size && dataArray[topThree] == null)
				throw new EmptyStackException();
			int toPop = dataArray[topThree];
			if (topThree > baseThree) {
				dataArray[topThree--] = null;
			}
			if (topThree == baseThree) {
				dataArray[topThree] = null;
			}
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
		} else if (stackId == 3) {
			if (topThree == baseThree && dataArray[baseThree] == null)
				throw new EmptyStackException();
			return dataArray[topThree];
		} else {
			return null;
		}
	}

	public boolean isEmpty(int stackId) {
		if (stackId == 1) {
			return topOne == -1;
		} else if (stackId == 2) {
			return topTwo == this.size;
		} else if (stackId == 3) {
			return (topThree == baseThree) && (dataArray[baseThree] == null);
		} else {
			return true;
		}
	}

	public void shiftStack3ToLeft() {
		for (int i = baseThree - 1; i <= topThree - 1; i++) {
			dataArray[i] = dataArray[i + 1];
		}
		dataArray[topThree--] = null;
		baseThree--;
	}

	public boolean stack3IsLeftShiftable() {
		if (topOne + 1 < baseThree) {
			return true;
		}
		return false;
	}

	public void shiftStack3ToRight() {
		for (int i = topThree + 1; i >= baseThree + 1; i--) {
			dataArray[i] = dataArray[i - 1];
		}
		dataArray[baseThree++] = null;
		topThree++;
	}

	public boolean stack3IsRightShiftable() {
		if (topThree + 1 < topTwo) {
			return true;
		}
		return false;
	}

	public void printStack() {
		for (int i = 0; i < dataArray.length; i++) {
			System.out.println(dataArray[i]);
		}
	}

	public static void main(String[] args) {
		ArrayWithThreeStacks stack = new ArrayWithThreeStacks(15);
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

		stack.push(3, 110);
		stack.push(3, 120);
		stack.push(3, 130);
		stack.push(3, 140);
		stack.printStack();
	}
}
