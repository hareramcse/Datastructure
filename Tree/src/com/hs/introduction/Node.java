package com.hs.introduction;

public class Node {
	String info;
	int data;
	Node left, right, next;

	public Node(int item) {
		data = item;
		left = right = next = null;
	}
	
	public Node() {

	}
	
	public Node(String x) {
		this.info = x;
	}
}
