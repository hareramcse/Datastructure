package com.hs.checkandprint;

public class PrintLongestRootToLeafPath {

	private static int ans, lh, rh, f;
	private static Node k;
	private Node root;

	// Function to find height of a tree
	private static int height(Node root) {
		if (root == null)
			return 0;
		int left_height = height(root.left);
		int right_height = height(root.right);

		// update the answer, because diameter of a
		// tree is nothing but maximum value of
		// (left_height + right_height + 1) for each node
		if (ans < 1 + left_height + right_height) {
			ans = 1 + left_height + right_height;

			// save the root, this will help us finding the
			// left and the right part of the diameter
			k = root;

			// save the height of left & right subtree as well.
			lh = left_height;
			rh = right_height;
		}
		return 1 + Math.max(left_height, right_height);

	}

	// prints the root to leaf path
	private static void printArray(int[] ints, int len) {
		int i;

		// print left part of the path in reverse order
		if (f == 0) {
			for (i = len - 1; i >= 0; i--) {
				System.out.print(ints[i] + " ");
			}
		} else if (f == 1) {
			for (i = 0; i < len; i++) {
				System.out.print(ints[i] + " ");
			}
		}
	}

	// this function finds out all the root to leaf paths
	private static void printPathsRecur(Node node, int[] path, int pathLen, int max) {
		if (node == null)
			return;

		// append this node to the path array
		path[pathLen] = node.data;
		pathLen++;

		// If it's a leaf, so print the path that led to here
		if (node.left == null && node.right == null) {

			// print only one path which is equal to the
			// height of the tree.
			if (pathLen == max && (f == 0 || f == 1)) {
				printArray(path, pathLen);
				f = 2;
			}
		} else {

			// otherwise try both subtrees
			printPathsRecur(node.left, path, pathLen, max);
			printPathsRecur(node.right, path, pathLen, max);
		}
	}

	// Computes the diameter of a binary tree with given root.
	private static void diameter(Node root) {
		if (root == null)
			return;

		// lh will store height of left subtree
		// rh will store height of right subtree
		ans = Integer.MIN_VALUE;
		lh = 0;
		rh = 0;

		// f is a flag whose value helps in printing
		// left & right part of the diameter only once
		f = 0;
		height(root);

		int[] lPath = new int[100];
		int pathlen = 0;

		// print the left part of the diameter
		printPathsRecur(k.left, lPath, pathlen, lh);
		System.out.print(k.data + " ");
		int[] rPath = new int[100];
		f = 1;

		// print the right part of the diameter
		printPathsRecur(k.right, rPath, pathlen, rh);
	}

	// Driver code
	public static void main(String[] args) {

		PrintLongestRootToLeafPath tree = new PrintLongestRootToLeafPath();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.right.left = new Node(6);
		tree.root.left.right.right = new Node(7);
		tree.root.left.left.right = new Node(8);
		tree.root.left.left.right.left = new Node(9);
		diameter(tree.root);

	}

}
