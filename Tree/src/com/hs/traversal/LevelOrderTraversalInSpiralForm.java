package com.hs.traversal;

class LevelOrderTraversalInSpiralForm {

	// Function to print the spiral traversal of tree
	public void printSpiral(Node root) {
		int h = height(root);

		/*
		 * ltr -> left to right. If this variable is set then the given label is
		 * traversed from left to right
		 */
		boolean ltr = false;
		for (int i = 1; i <= h; i++) {
			printGivenLevel(root, i, ltr);

			/* Revert ltr to traverse next level in opposite order */
			ltr = !ltr;
		}
	}

	private int height(Node root) {
		if (root == null)
			return 0;
		
		/* compute height of each subtree */
		int lHeight = height(root.left);
		int rHeight = height(root.right);

		/* use the larger one */
		if (lHeight > rHeight)
			return lHeight + 1;
		else
			return rHeight + 1;
	}

	/* Print nodes at a given level */
	private void printGivenLevel(Node root, int level, boolean ltr) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			if (ltr) {
				printGivenLevel(root.left, level - 1, ltr);
				printGivenLevel(root.right, level - 1, ltr);
			} else {
				printGivenLevel(root.right, level - 1, ltr);
				printGivenLevel(root.left, level - 1, ltr);
			}
		}
	}

	/* Driver program to test the above functions */
	public static void main(String[] args) {
		LevelOrderTraversalInSpiralForm tree = new LevelOrderTraversalInSpiralForm();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(4);
		System.out.println("Spiral order traversal of Binary Tree is ");
		tree.printSpiral(root);
	}
}