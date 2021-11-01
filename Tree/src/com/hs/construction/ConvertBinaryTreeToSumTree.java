package com.hs.construction;

class ConvertBinaryTreeToSumTree {

	// Convert a given tree to a tree where every node contains sum of
	// values of nodes in left and right subtrees in the original tree
	private int toSumTree(Node root) {
		// Base case
		if (root == null)
			return 0;

		// Store the old value
		int old_val = root.data;

		// Recursively call for left and right subtrees and store the sum
		// as new value of this node
		root.data = toSumTree(root.left) + toSumTree(root.right);

		// Return the sum of values of nodes in left and right subtrees
		// and old_value of this node
		return root.data + old_val;
	}

	// A utility function to print inorder traversal of a Binary Tree
	private void printInorder(Node root) {
		if (root == null)
			return;
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

	/* Driver function to test above functions */
	public static void main(String args[]) {
		ConvertBinaryTreeToSumTree tree = new ConvertBinaryTreeToSumTree();

		/* Constructing tree given in the above figure */
		Node root = new Node(10);
		root.left = new Node(-2);
		root.right = new Node(6);
		root.left.left = new Node(8);
		root.left.right = new Node(-4);
		root.right.left = new Node(7);
		root.right.right = new Node(5);

		tree.toSumTree(root);

		System.out.println("Inorder Traversal of the resultant tree is:");
		tree.printInorder(root);
	}
}