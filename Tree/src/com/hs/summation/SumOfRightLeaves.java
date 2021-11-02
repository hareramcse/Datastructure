package com.hs.summation;

class SumOfRightLeaves {

	private int sum = 0;

	// utility function to calculate sum of right leaf nodes
	private void rightLeafSum(Node root) {
		if (root == null)
			return;

		// check if the right child of root is leaf node
		if (root.right != null) {
			if (root.right.left == null && root.right.right == null) {
				sum += root.right.data;
			}
		}
		rightLeafSum(root.left);
		rightLeafSum(root.right);
	}

	// Driver Code
	public static void main(String args[]) {
		SumOfRightLeaves tree = new SumOfRightLeaves();

		// construct binary tree
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.right = new Node(2);
		root.right = new Node(3);
		root.right.right = new Node(8);
		root.right.right.left = new Node(6);
		root.right.right.right = new Node(7);

		// variable to store sum
		// of right leaves
		tree.rightLeafSum(root);
		System.out.println(tree.sum);
	}
}