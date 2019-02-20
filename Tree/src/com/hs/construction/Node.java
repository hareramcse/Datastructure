package com.hs.construction;

public class Node {
	Node left;
	Node right;
	int data;
	char ch;

	Node(int data) {
		this.data = data;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	Node(char ch) {
		this.ch = ch;
	}
}
