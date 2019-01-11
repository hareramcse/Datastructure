package com.hs.construction;

public class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}
