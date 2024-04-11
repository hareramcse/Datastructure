package com.hs.bt;

import com.hs.tree.Node;

/*
1) Find depth of any node. Let this depth be d. Now recursively traverse the tree and check 
for following two conditions. Every internal node should have both children non-empty 
2) All leaves are at depth d*/
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