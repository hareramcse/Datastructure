package com.hs.checkandprint;

class PrintLeftViewOfBinaryTree {
	private int max_level;

	// recursive function to print left view
	private void leftView(Node root, int level) {
		// Base Case
		if (root == null)
			return;

		// If this is the first node of its level
		if (max_level < level) {
			System.out.print(" " + root.data);
			max_level = level;
		}

		// Recur for left and right subtrees
		leftView(root.left, level + 1);
		leftView(root.right, level + 1);
	}

	/* testing for example nodes */
	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		PrintLeftViewOfBinaryTree tree = new PrintLeftViewOfBinaryTree();
		Node root = new Node(12);
		root.left = new Node(10);
		root.right = new Node(30);
		root.right.left = new Node(25);
		root.right.right = new Node(40);

		tree.leftView(root, 1);
	}
}
