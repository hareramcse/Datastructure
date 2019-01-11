package com.hs.construction;

public class ConstructSumTree {
	int toSumTree(Node node) {
		// Base case
		if (node == null)
			return 0;

		// Store the old value
		int old_val = node.data;

		// Recursively call for left and right subtrees and store the sum
		// as new value of this node
		node.data = toSumTree(node.left) + toSumTree(node.right);

		// Return the sum of values of nodes in left and right subtrees
		// and old_value of this node
		return node.data + old_val;
	}

	// A utility function to print inorder traversal of a Binary Tree
	void printInorder(Node node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	/* Driver function to test above functions */
	public static void main(String args[]) {

		/* Constructing tree given in the above figure */
		Node root = new Node(10);
		root.left = new Node(-2);
		root.right = new Node(6);
		root.left.left = new Node(8);
		root.left.right = new Node(-4);
		root.right.left = new Node(7);
		root.right.right = new Node(5);

		ConstructSumTree cst = new ConstructSumTree();
		cst.toSumTree(root);

		// Print inorder traversal of the converted tree to test result
		// of toSumTree()
		System.out.println("Inorder Traversal of the resultant tree is:");
		cst.printInorder(root);
	}
}
