package com.hs.random;

public class Node {
	Node left;
	Node right;
	Node nextRight;
	Node next;
	String dataString;
	int data;

	Node(int data) {
		this.data = data;
	}

	Node(String dataString) {
		this.dataString = dataString;
		// Be default left and right child are null.
	}

	public String getDataString() {
		return dataString;
	}

}
