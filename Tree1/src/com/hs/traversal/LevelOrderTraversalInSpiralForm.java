package com.hs.traversal;

class LevelOrderTraversalInSpiralForm {

	static Node root;

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest path
	 * from the root node down to the farthest leaf node.
	 */
	int height(Node node) {
		if (node == null)
			return -1;
		else {

			/* compute the height of each subtree */
			int lheight = height(node.left);
			int rheight = height(node.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	// Function to print the spiral traversal of tree
	void printSpiral(Node node) {
		int h = height(node);

		/*
		 * ltr -> left to right. If this variable is set then the given label is
		 * transversed from left to right
		 */
		boolean leftToRight = false;
		for (int i = 1; i <= h; i++) {
			printGivenLevel(node, i, leftToRight);

			/* Revert leftToRight to traverse next level in opposite order */
			leftToRight = !leftToRight;
		}

	}

	/* Print nodes at a given level */
	void printGivenLevel(Node node, int level, boolean leftToRight) {
		if (node == null)
			return;
		if (level == 0)
			System.out.print(node.data + " ");
		else if (level > 0) {
			if (leftToRight != false) {
				printGivenLevel(node.left, level - 1, leftToRight);
				printGivenLevel(node.right, level - 1, leftToRight);
			} else {
				printGivenLevel(node.right, level - 1, leftToRight);
				printGivenLevel(node.left, level - 1, leftToRight);
			}
		}
	}

	/* Driver program to test the above functions */
	public static void main(String[] args) {
		LevelOrderTraversalInSpiralForm tree = new LevelOrderTraversalInSpiralForm();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(7);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(4);
		System.out.println("Spiral order traversal of Binary Tree is ");
		tree.printSpiral(root);
	}
}
