package com.hs.summation;

import com.hs.tree.Node;

public class SumOfAllLeafNodes {

	int sum;

	public void leafSum(Node root) {
		if (root == null)
			return;

		if (root.left == null && root.right == null)
			sum += root.data;

		leafSum(root.left);
		leafSum(root.right);
	}

	public static void main(String args[]) {

		SumOfAllLeafNodes tree = new SumOfAllLeafNodes();
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right = new Node(3);
		root.right.right = new Node(7);
		root.right.left = new Node(6);
		root.right.left.right = new Node(8);

		// variable to store sum of leaf nodes
		tree.sum = 0;
		tree.leafSum(root);
		System.out.println(tree.sum);
	}
}