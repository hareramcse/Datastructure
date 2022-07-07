package com.hs.misc;

class RightViewOfBinaryTree {

	private int max_level;

	// Recursive function to print right view of a binary
	private void rightView(Node root, int level) {

		// Base Case
		if (root == null)
			return;

		// If this is the last Node of its level
		if (max_level < level) {
			System.out.print(root.data + " ");
			max_level = level;
		}

		// Recur for right subtree first, then left subtree
		rightView(root.right, level + 1);
		rightView(root.left, level + 1);
	}

	// Driver program to test the above functions
	public static void main(String args[]) {
		RightViewOfBinaryTree tree = new RightViewOfBinaryTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);

		tree.rightView(root, 1);

	}
}