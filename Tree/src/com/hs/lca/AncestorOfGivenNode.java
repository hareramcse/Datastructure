package com.hs.lca;

class AncestorOfGivenNode {
	Node root;

	/*
	 * If target is present in tree, then prints the ancestors and returns true,
	 * otherwise returns false.
	 */
	boolean printAncestors(Node node, int target) {
		/* base cases */
		if (node == null)
			return false;

		if (node.data == target)
			return true;

		/*
		 * If target is present in either left or right subtree of this node, then print
		 * this node
		 */
		if (printAncestors(node.left, target) || printAncestors(node.right, target)) {
			System.out.print(node.data + " ");
			return true;
		}

		/* Else return false */
		return false;
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		AncestorOfGivenNode tree = new AncestorOfGivenNode();

		/*
		 * Construct the following binary tree 1 / \ 2 3 / \ 4 5 / 7
		 */
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.left.left = new Node(7);

		tree.printAncestors(tree.root, 7);

	}
}

// This code has been contributed by Mayank Jaiswal
