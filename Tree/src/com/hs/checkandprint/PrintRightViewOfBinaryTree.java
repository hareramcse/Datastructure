package com.hs.checkandprint;

class PrintRightViewOfBinaryTree {

	Node root;
	int max_level;

	// Recursive function to print right view of a binary tree.
	void rightViewUtil(Node node, int level) {

		// Base Case
		if (node == null)
			return;

		// If this is the last Node of its level
		if (max_level < level) {
			System.out.print(node.data + " ");
			max_level = level;
		}

		// Recur for right subtree first, then left subtree
		rightViewUtil(node.right, level + 1);
		rightViewUtil(node.left, level + 1);
	}

	void rightView() {
		rightViewUtil(root, 1);
	}

	// Driver program to test the above functions
	public static void main(String args[]) {
		PrintRightViewOfBinaryTree tree = new PrintRightViewOfBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);

		tree.rightView();

	}
}