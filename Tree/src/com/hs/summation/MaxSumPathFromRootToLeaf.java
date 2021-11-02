package com.hs.summation;

class Maximum {
	int max_no = Integer.MIN_VALUE;
}

class MaxSumPathFromRootToLeaf {
	private Maximum max = new Maximum();
	private Node targetLeaf = null;

	// A utility function that prints all nodes on the path from root to target_leaf
	private boolean printPath(Node root, Node targetLeaf) {
		// base case
		if (root == null)
			return false;

		// return true if this node is the target_leaf or
		// target leaf is present in one of its descendants
		if (root == targetLeaf || printPath(root.left, targetLeaf) || printPath(root.right, targetLeaf)) {
			System.out.print(root.data + " ");
			return true;
		}

		return false;
	}

	// This function Sets the target_leaf_ref to refer
	// the leaf node of the maximum path sum.
	private void getTargetLeaf(Node root, Maximum max_sum_ref, int curr_sum) {
		if (root == null)
			return;

		// Update current sum to hold sum of nodes on path from root to this node
		curr_sum = curr_sum + root.data;

		// If this is a leaf node and path to this node
		// has maximum sum so far, then make this node target_leaf
		if (root.left == null && root.right == null) {
			if (curr_sum > max_sum_ref.max_no) {
				max_sum_ref.max_no = curr_sum;
				targetLeaf = root;
			}
		}

		// If this is not a leaf node, then recur down to find the target_leaf
		getTargetLeaf(root.left, max_sum_ref, curr_sum);
		getTargetLeaf(root.right, max_sum_ref, curr_sum);
	}

	// Returns the maximum sum and prints the nodes on max sum path
	private int maxSumPath(Node root) {
		// base case
		if (root == null)
			return 0;

		// find the target leaf and maximum sum
		getTargetLeaf(root, max, 0);

		// print the path from root to the target leaf
		printPath(root, targetLeaf);
		return max.max_no; // return maximum sum
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