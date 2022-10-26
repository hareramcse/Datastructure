package com.hs.checkandprint;

import com.hs.tree.Node;

class PrintMaxValue {

	// Returns the max value in a binary tree
	private int findMax(Node root) {
		if (root == null)
			return Integer.MIN_VALUE;

		int res = root.data;
		int lRes = findMax(root.left);
		int rRes = findMax(root.right);

		return Math.max(res, Math.max(lRes, rRes));
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