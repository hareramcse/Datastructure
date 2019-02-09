package com.hs.checkandprint;

class PrintRightViewOfBinaryTree {

	int max_level;

	// Recursive function to print right view of a binary
	void rightViewUtil(Node root, int level) {

		// Base Case
		if (root == null)
			return;

		// If this is the last Node of its level
		if (max_level < level) {
			System.out.print(root.data + " ");
			max_level = level;
		}

		// Recur for right subtree first, then left subtree
		rightViewUtil(root.right, level + 1);
		rightViewUtil(root.left, level + 1);
	}

	void rightView(Node root) {
		rightViewUtil(root, 1);
	}

	// Driver program to test the above functions
	public static void main(String args[]) {
		PrintRightViewOfBinaryTree tree = new PrintRightViewOfBinaryTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);

		tree.rightView(root);

	}
}