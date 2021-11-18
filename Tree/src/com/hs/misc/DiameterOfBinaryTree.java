package com.hs.misc;
/* diameter of a tree is nothing but maximum value of (left_height + right_height + 1) for each 
 * node.*/

// O(n)
class DiameterOfBinaryTree {

	class Result {
		int ans = Integer.MIN_VALUE;
	}

	// Computes the diameter of binary tree with given root.
	private int diameter(Node root) {
		if (root == null)
			return 0;

		// This will store the final answer
		Result result = new Result();
		maxHeightOfEachNode(root, result);
		return result.ans;
	}

	/* Function to find height of a tree */
	private int maxHeightOfEachNode(Node root, Result result) {
		if (root == null)
			return 0;

		int leftHeight = maxHeightOfEachNode(root.left, result);

		int rightHeight = maxHeightOfEachNode(root.right, result);

		// update the answer, because diameter of a tree is nothing but maximum value of
		// (left_height + right_height + 1) for each node
		result.ans = Math.max(result.ans, 1 + leftHeight + rightHeight);

		return 1 + Math.max(leftHeight, rightHeight);
	}

	public static void main(String[] args) {
		DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("Diameter is " + tree.diameter(root));
	}
}