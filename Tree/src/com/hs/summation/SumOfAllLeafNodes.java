package com.hs.summation;

public class SumOfAllLeafNodes {

	// user define class node
	static class Node {
		int data;
		Node left, right;

		// constructor
		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	static int sum;

	// utility function which calculates
	// sum of all leaf nodes
	static void leafSum(Node root) {
		if (root == null)
			return;

		// add root data to sum if
		// root is a leaf node
		if (root.left == null && root.right == null)
			sum += root.data;

		// propagate recursively in left
		// and right subtree
		leafSum(root.left);
		leafSum(root.right);
	}

	// driver program
	public static void main(String args[]) {
		// contruct binary tree
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right = new Node(3);
		root.right.right = new Node(7);
		root.right.left = new Node(6);
		root.right.left.right = new Node(8);

		// variable to store sum of leaf nodes
		sum = 0;
		leafSum(root);
		System.out.println(sum);
	}
}
// This code is contributed by Sumit Ghosh
