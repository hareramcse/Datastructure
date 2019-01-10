package com.hs.construction;

public class ConvertBinaryTreeFromLeftRightToDownRight {
	void convert(Node root) {
		// Base Case
		if (root == null)
			return;

		// Recursively convert left and right subtrees
		convert(root.left);
		convert(root.right);

		// If left child is NULL, make right child as left
		// as it is the first child.
		if (root.left == null)
			root.left = root.right;

		// If left child is NOT NULL, then make right child
		// as right of left child
		else
			root.left.right = root.right;

		// Set root's right as NULL
		root.right = null;
	}

	// A utility function to traverse a tree stored in
	// down-right form.
	void downRightTraversal(Node root) {
		if (root != null) {
			System.out.print(root.data+" ");
			downRightTraversal(root.right);
			downRightTraversal(root.left);
		}
	}

	// Driver program to test above functions
	public static void main(String args[]) {
		ConvertBinaryTreeFromLeftRightToDownRight c = new ConvertBinaryTreeFromLeftRightToDownRight();
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		root.right.left.left = new Node(6);
		root.right.right.left = new Node(7);
		root.right.right.right = new Node(8);

		c.convert(root);
		c.downRightTraversal(root);
	}
}