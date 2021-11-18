package com.hs.checkandprint;

public class Node {
	int data, height;
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

	public Node() {

	}

	public boolean isLeaf() {
		return (left == null && right == null);
	}
}
