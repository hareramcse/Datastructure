package com.hs.bt;

import com.hs.tree.Node;

class PrintMaxValue {
	public int findMax(Node root) {
		if (root == null)
			return Integer.MIN_VALUE;

		int data = root.data;
		int left = findMax(root.left);
		int right = findMax(root.right);

		return Math.max(data, Math.max(left, right));
	}

	public int findMin(Node root) {
		if (root == null)
			return Integer.MAX_VALUE;

		int data = root.data;
		int left = findMin(root.left);
		int right = findMin(root.right);

		return Math.min(data, Math.min(left, right));
	}

	public static void main(String args[]) {
		PrintMaxValue tree = new PrintMaxValue();
		Node root = new Node(2);
		root.left = new Node(7);
		root.right = new Node(5);
		root.left.right = new Node(6);
		root.left.right.left = new Node(1);
		root.left.right.right = new Node(11);
		root.right.right = new Node(9);
		root.right.right.left = new Node(4);

		System.out.println("Maximum element is " + tree.findMax(root));
	}
}