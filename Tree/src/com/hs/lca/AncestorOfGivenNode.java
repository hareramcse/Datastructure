package com.hs.lca;

class AncestorOfGivenNode {

	private boolean printAncestors(Node root, int target) {
		/* base cases */
		if (root == null)
			return false;

		if (root.data == target)
			return true;

		/*
		 * If target is present in either left or right subtree of this node, then print
		 * this node
		 */
		if (printAncestors(root.left, target) || printAncestors(root.right, target)) {
			System.out.print(root.data + " ");
			return true;
		}

		return false;
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		AncestorOfGivenNode tree = new AncestorOfGivenNode();

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.left = new Node(7);

		tree.printAncestors(root, 7);

	}
}