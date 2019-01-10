package com.hs.construction;

public class ConvertTreeThatHoldesLogicalANDProperty {
	// Convert the given tree to a tree where
	// each node is logical AND of its children
	// The main idea is to do Postorder traversal
	void convertTree(Node root) {
		if (root == null)
			return;

		/* first recur on left child */
		convertTree(root.left);

		/* then recur on right child */
		convertTree(root.right);

		if (root.left != null && root.right != null)
			root.data = (root.left.data) & (root.right.data);
	}

	void printInorder(Node root) {
		if (root == null)
			return;

		/* first recur on left child */
		printInorder(root.left);

		System.out.println(root.data);

		/* now recur on right child */
		printInorder(root.right);
	}

	// main function
	public static void main(String args[]) {
		ConvertTreeThatHoldesLogicalANDProperty c = new ConvertTreeThatHoldesLogicalANDProperty();
		Node root = new Node(0);
		root.left = new Node(1);
		root.right = new Node(0);
		root.left.left = new Node(0);
		root.left.right = new Node(1);
		root.right.left = new Node(1);
		root.right.right = new Node(1);

		c.printInorder(root);
		c.convertTree(root);
		c.printInorder(root);
	}
}
