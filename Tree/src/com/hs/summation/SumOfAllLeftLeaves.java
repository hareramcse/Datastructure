package com.hs.summation;

class SumOfAllLeftLeaves {
	private int sum = 0;

	// This function returns sum of all left leaves in a given binary tree
	private void leftLeavesSum(Node node, boolean isleft) {
		if (node == null)
			return;

		// Check whether this node is a leaf node and is left.
		if (node.left == null && node.right == null && isleft)
			sum = sum + node.data;

		// Pass true for left and false for right
		leftLeavesSum(node.left, true);
		leftLeavesSum(node.right, false);
	}

	// Driver program
	public static void main(String args[]) {
		SumOfAllLeftLeaves tree = new SumOfAllLeftLeaves();
		Node root = new Node(20);
		root.left = new Node(9);
		root.right = new Node(49);
		root.left.right = new Node(12);
		root.left.left = new Node(5);
		root.right.left = new Node(23);
		root.right.right = new Node(52);
		root.left.right.right = new Node(12);
		root.right.right.left = new Node(50);

		tree.leftLeavesSum(root, false);
		System.out.println("The sum of leaves is " + tree.sum);
	}
}