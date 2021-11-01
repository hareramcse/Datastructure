package com.hs.construction;

/*
 * Given a Binary Tree (Every node has at most 2 children) where each node has value 
 * either 0 or 1. Convert a given Binary tree to a tree that holds Logical AND 
 * property, i.e., each node value should be the logical AND between its children*/

/* The idea is to traverse given binary tree in postorder fashion. For each node check 
 * (recursively) if the node has one children then we don’t have any need to check else 
 * if the node has both its child then simply update the node data with the logical AND 
 * of its child data*/
public class ConvertTreeThatHoldesLogicalANDProperty {

	private void convertTree(Node root) {
		if (root == null)
			return;

		// first recur on left child
		convertTree(root.left);

		// then recur on right child
		convertTree(root.right);

		if (root.left != null && root.right != null)
			root.data = (root.left.data) & (root.right.data);
	}

	private void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.println(root.data);
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
