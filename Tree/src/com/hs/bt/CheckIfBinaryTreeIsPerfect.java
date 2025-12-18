package com.hs.bt;

import com.hs.tree.Node;

/*
A binary tree is perfect if:

1) All internal nodes have exactly two children
2) All leaf nodes are at the same depth (same level). */
//Time Complexity: O(n) where n = number of nodes
//Space Complexity: O(h) where h = height of tree.
class CheckIfBinaryTreeIsPerfect {
	public boolean isPerfect(Node root) {
		int depth = findDepth(root);
		return isPerfect(root, 0, depth);
	}

	private int findDepth(Node root) {
		int depth = 0;
		while (root != null) {
			depth++;
			root = root.left;
		}
		return depth;
	}

	private boolean isPerfect(Node root, int level, int depth) {
		if (root == null)
			return true;

		// if it is leaf node then its level should be same as other leaf node
		if (root.left == null && root.right == null)
			return depth == level + 1;

		// Internal node must have two children
		if (root.left == null || root.right == null)
			return false;

		return isPerfect(root.left, level + 1, depth) && isPerfect(root.right, level + 1, depth);
	}

	public static void main(String args[]) {
		CheckIfBinaryTreeIsPerfect tree = new CheckIfBinaryTreeIsPerfect();
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.right = new Node(70);

		if (tree.isPerfect(root) == true)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}