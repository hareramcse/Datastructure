package com.hs.tree;

public class Node {
	public int data;
	public int height;
	public Node left;
	public Node right;

	public Node(int data) {
		this.data = data;
		height = 0;
	}
}
