package com.hs.random;

class MaximumWidthOfBinaryTree1 {

	Node root;

	/* Function to get the maximum width of a binary tree */
	int getMaxWidth(Node node) {
		int h = height(node);

		// Create an array that will store count of nodes at each level
		int count[] = new int[10];

		int level = 0;

		// Fill the count array using preorder traversal
		getMaxWidthRecur(node, count, level);

		// Return the maximum value from count array
		return getMax(count, h);
	}

	// A function that fills count array with count of nodes at every
	// level of given binary tree
	void getMaxWidthRecur(Node node, int count[], int level) {
		if (node != null) {
			count[level]++;
			getMaxWidthRecur(node.left, count, level + 1);
			getMaxWidthRecur(node.right, count, level + 1);
		}
	}

	/* UTILITY FUNCTIONS */
	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest path
	 * from the root node down to the farthest leaf node.
	 */
	int height(Node node) {
		if (node == null) {
			return 0;
		} else {

			/* compute the height of each subtree */
			int lHeight = height(node.left);
			int rHeight = height(node.right);

			/* use the larger one */
			return (lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1);
		}
	}

	// Return the maximum value from count array
	int getMax(int arr[], int n) {
		int max = arr[0];
		int i;
		for (i = 0; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	public static void main(String args[]) {
		MaximumWidthOfBinaryTree1 tree = new MaximumWidthOfBinaryTree1();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(8);
		tree.root.right.right.left = new Node(6);
		tree.root.right.right.right = new Node(7);

		System.out.println("Maximum width is " + tree.getMaxWidth(tree.root));
	}
}
