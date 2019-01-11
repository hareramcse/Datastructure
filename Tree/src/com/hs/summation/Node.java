package com.hs.summation;

public class Node {
	int data;
	Node left, right, next;

	public Node(int item) {
		data = item;
		left = right = next = null;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}
