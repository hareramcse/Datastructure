package com.hs.checkandprint;

import com.hs.tree.Node;

/*
1) Find depth of any node. Let this depth be d. Now recursively traverse the tree and check 
for following two conditions. Every internal node should have both children non-empty 
2) All leaves are at depth ‘d’*/
// O(n) 
class CheckIfBinaryTreeIsPerfect {

	public boolean isPerfect(Node root) {
		int depth = findLeftDepth(root);
		return isPerfectTree(root, 0, depth);
	}

	// Returns depth of leftmost leaf.
	private int findLeftDepth(Node root) {
		int d = 0;
		while (root != null) {
			d++;
			root = root.left;
		}
		return d;
	}

	private boolean isPerfectTree(Node root, int level, int depth) {
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
		CheckIfBinaryTreeIsPerfect tree = new CheckIfBinaryTreeIsPerfect();
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.right = new Node(70);

		if (tree.isPerfect(root) == true)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}