package com.hs.summation;

class Maximum {
	int maxSum = Integer.MIN_VALUE;
}

class MaxSumPathFromRootToLeaf {
	private Maximum max = new Maximum();
	private Node targetLeaf = null;

	// Returns the maximum sum and prints the nodes on max sum path
	private int maxSumPath(Node root) {
		// base case
		if (root == null)
			return 0;

		// find the target leaf and maximum sum
		getTargetLeaf(root, max, 0);

		// print the path from root to the target leaf
		printPath(root, targetLeaf);
		return max.maxSum; // return maximum sum
	}

	// This function Sets the target_leaf_ref to refer
	// the leaf node of the maximum path sum.
	private void getTargetLeaf(Node root, Maximum max_sum_ref, int currSum) {
		if (root == null)
			return;

		// Update current sum to hold sum of nodes on path from root to this node
		currSum = currSum + root.data;

		// If this is a leaf node and path to this node
		// has maximum sum so far, then make this node target_leaf
		if (root.left == null && root.right == null) {
			if (currSum > max_sum_ref.maxSum) {
				max_sum_ref.maxSum = currSum;
				targetLeaf = root;
			}
		}

		// If this is not a leaf node, then recur down to find the target_leaf
		getTargetLeaf(root.left, max_sum_ref, currSum);
		getTargetLeaf(root.right, max_sum_ref, currSum);
	}

	// A utility function that prints nodes on the path from root to target leaf
	private void printPath(Node root, Node targetLeaf) {
		// base case
		if (root == null)
			return;

		// return true if this node is the target_leaf or
		// target leaf is present in one of its descendants
		if (root == targetLeaf) {
			System.out.print(root.data + " ");
		}
		printPath(root.left, targetLeaf);
		printPath(root.right, targetLeaf);
	}

	// driver function to test the above functions
	public static void main(String args[]) {
		MaxSumPathFromRootToLeaf tree = new MaxSumPathFromRootToLeaf();
		Node root = new Node(10);
		root.left = new Node(-2);
		root.right = new Node(7);
		root.left.left = new Node(8);
		root.left.right = new Node(-4);
		System.out.println("Following are the nodes on maximum sum path");
		int sum = tree.maxSumPath(root);
		System.out.println("");
		System.out.println("Sum of nodes is : " + sum);
	}
}