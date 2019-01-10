package com.hs.random;

class PrintAllPathFromRootIterativeWay {

	static Node root;

	/*
	 * Given a binary tree, print out all of its root-to-leaf paths, one per line.
	 * Uses a recursive helper to do the work.
	 */

	void printPaths(Node node) {
		int path[] = new int[100];
		printPathsRecur(node, path, 0);
	}

	/*
	 * Recursive helper function -- given a node, and an array containing the path
	 * from the root node up to but not including this node, print out all the
	 * root-leaf paths.
	 */
	void printPathsRecur(Node root, int path[], int pathLen) {
		if (root == null) {
			return;
		}

		// put this node in the path array
		path[pathLen++] = root.data;

		// it's a leaf, so print the path that led to here
		if (root.left == null && root.right == null) {
			printArray(path, pathLen);
		} else {

			// otherwise try both subtrees
			printPathsRecur(root.left, path, pathLen);
			printPathsRecur(root.right, path, pathLen);
		}
	}

	// Utility that prints out an array on a line
	void printArray(int ints[], int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(ints[i] + " ");
		}
		System.out.println("");
	}

	// Driver program to test mirror()
	public static void main(String[] args) {

		PrintAllPathFromRootIterativeWay tree = new PrintAllPathFromRootIterativeWay();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		// Print all root-to-leaf paths of the input tree
		tree.printPaths(root);

	}
}
