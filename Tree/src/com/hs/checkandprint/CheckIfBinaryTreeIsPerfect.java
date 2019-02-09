package com.hs.checkandprint;

class CheckIfBinaryTreeIsPerfect {

	// Returns depth of leftmost leaf.
	static int findLeftDepth(Node node) {
		int d = 0;
		while (node != null) {
			d++;
			node = node.left;
		}
		return d;
	}

	/*
	 * This function tests if a binary tree is perfect or not. It basically checks
	 * for two things : 1) All leaves are at same level 2) All internal nodes have
	 * two children
	 */
	static boolean isPerfectUtil(Node root, int level, int depth) {
		// An empty tree is perfect
		if (root == null)
			return true;

		// If leaf node, then its depth must be same as
		// depth of all other leaves.
		if (root.left == null && root.right == null)
			return (depth == level + 1);

		// If internal node and one child is empty
		if (root.left == null || root.right == null)
			return false;

		// Left and right subtrees must be perfect.
		return isPerfectUtil(root.left, level + 1, depth) && isPerfectUtil(root.right, level + 1, depth);
	}

	// Wrapper over isPerfectRec()
	static boolean isPerfect(Node root) {
		int depth = findLeftDepth(root);
		return isPerfectUtil(root, 0, depth);
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