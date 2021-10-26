package com.hs.checkandprint;

class CheckIfBinaryTreeIsPerfect {

	private static boolean isPerfect(Node root) {
		int depth = findLeftDepth(root);
		return isPerfectTree(root, 0, depth);
	}

	// Returns depth of leftmost leaf.
	private static int findLeftDepth(Node root) {
		int d = 0;
		while (root != null) {
			d++;
			root = root.left;
		}
		return d;
	}

	/*
	 * This function tests if a binary tree is perfect or not. It basically checks
	 * for two things : 1) All leaves are at same level 2) All internal nodes have
	 * two children
	 */
	private static boolean isPerfectTree(Node root, int level, int depth) {
		// An empty tree is perfect
		if (root == null)
			return true;

		// If leaf node, then its depth must be same as depth of all other leaves.
		if (root.left == null && root.right == null)
			return (depth == level + 1);

		// If internal node and one child is empty
		if (root.left == null || root.right == null)
			return false;

		// Left and right subtrees must be perfect.
		return isPerfectTree(root.left, level + 1, depth) && isPerfectTree(root.right, level + 1, depth);
	}

	// Driver Program
	public static void main(String args[]) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.right = new Node(70);

		if (isPerfect(root) == true)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}