package com.hs.bt;

import com.hs.tree.Node;

class CheckBinaryTreeIsSumTree {
	public boolean isSumTree(Node root) {
		return sum(root) != -1;
	}

	private int sum(Node node) {
		// Empty tree
		if (node == null)
			return 0;

		// Leaf node
		if (node.left == null && node.right == null)
			return node.data;

		int leftSum = sum(node.left);
		if (leftSum == -1)
			return -1;

		int rightSum = sum(node.right);
		if (rightSum == -1)
			return -1;

		// Check Sum Tree property
		if (node.data != leftSum + rightSum)
			return -1;

		// Return total sum of subtree
		return node.data + leftSum + rightSum;
	}

	public static void main(String args[]) {
		CheckBinaryTreeIsSumTree tree = new CheckBinaryTreeIsSumTree();
		Node root = new Node(26);
		root.left = new Node(10);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(6);
		root.right.right = new Node(3);

		boolean result = tree.isSumTree(root);
		System.out.println(result);
	}
}