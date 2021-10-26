package com.hs.summation;

class SumOfAllLeftLeaves {

	// A utility function to check if a given node is leaf or not
	private boolean isLeaf(Node node) {
		if (node == null)
			return false;
		if (node.left == null && node.right == null)
			return true;
		return false;
	}

	// This function returns sum of all left leaves in a given binary tree
	private int leftLeavesSum(Node node) {
		// Initialize result
		int res = 0;

		// Update result if root is not NULL
		if (node != null) {
			// If left of root is NULL, then add key of left child
			if (isLeaf(node.left))
				res += node.left.data;
			else // Else recur for left child of root
				res += leftLeavesSum(node.left);

			// Recur for right child of root and update res
			res += leftLeavesSum(node.right);
		}

		// return result
		return res;
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

		System.out.println("The sum of leaves is " + tree.leftLeavesSum(root));
	}
}