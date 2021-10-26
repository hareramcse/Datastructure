package com.hs.checkandprint;

class CheckIfTwoNodesAreCousin {
	// Recursive function to check if two Nodes are siblings
	private boolean isSibling(Node root, Node a, Node b) {
		// Base case
		if (root == null)
			return false;

		return ((root.left == a && root.right == b) || (root.left == b && root.right == a) || isSibling(root.left, a, b)
				|| isSibling(root.right, a, b));
	}

	// Recursive function to find level of Node 'ptr' in a binary tree
	private int level(Node root, Node ptr, int level) {
		// base cases
		if (root == null)
			return 0;

		if (root == ptr)
			return level;

		// Return level if Node is present in left subtree
		int l = level(root.left, ptr, level + 1);
		if (l != 0)
			return l;

		// Else search in right subtree
		return level(root.right, ptr, level + 1);
	}

	// Returns 1 if a and b are cousins, otherwise 0
	private boolean isCousin(Node node, Node a, Node b) {
		// 1. The two Nodes should be on the same level in the binary
		// 2. The two Nodes should not be siblings (means
		// that they should not have the same parent Node).
		return ((level(node, a, 1) == level(node, b, 1)) && (!isSibling(node, a, b)));
	}

	// Driver program to test above functions
	public static void main(String args[]) {
		CheckIfTwoNodesAreCousin tree = new CheckIfTwoNodesAreCousin();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.right = new Node(15);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);

		Node Node1, Node2;
		Node1 = root.left.left;
		Node2 = root.right.right;
		if (tree.isCousin(root, Node1, Node2))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}