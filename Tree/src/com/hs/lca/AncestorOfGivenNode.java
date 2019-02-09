package com.hs.lca;

class AncestorOfGivenNode {

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
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.left = new Node(7);

		tree.printAncestors(root, 7);

	}
}