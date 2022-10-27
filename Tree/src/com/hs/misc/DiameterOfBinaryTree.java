package com.hs.misc;

import com.hs.tree.Node;

// this is also called as longest distance from any 2 nodes.
// diameter of a tree is maximum value of (left_height + right_height) for each node + 1
class DiameterOfBinaryTree {
	public int diameterOfBinaryTree(Node root) {
		int[] diameter = new int[1];
		height(root, diameter);
		return diameter[0];
	}

	private int height(Node root, int[] diameter) {
		if (root == null)
			return 0;

		int leftHeight = height(root.left, diameter);
		int rightHeight = height(root.right, diameter);
		diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public static void main(String[] args) {
		DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("Diameter is " + tree.diameterOfBinaryTree(root));
	}
}