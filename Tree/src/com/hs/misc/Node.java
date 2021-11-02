package com.hs.misc;

public class Node {
	int data;
	Node left, right, next, nextRight;

	public Node(int item) {
		data = item;
		left = right = next = nextRight = null;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}
