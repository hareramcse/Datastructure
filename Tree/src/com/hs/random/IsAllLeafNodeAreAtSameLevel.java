package com.hs.random;

class Leaf {

	int leaflevel = 0;
}

class IsAllLeafNodeAreAtSameLevel {

	Node root;
	Leaf mylevel = new Leaf();

	/* Recursive function which checks whether all leaves are at same level */

	boolean checkUtil(Node node, int level, Leaf leafLevel) {
		// Base case
		if (node == null) {
			return true;
		}

		// If a leaf node is encountered
		if (node.left == null && node.right == null) {
			// When a leaf node is found first time
			if (leafLevel.leaflevel == 0) {
				leafLevel.leaflevel = level; // Set first found leaf's level
				return true;
			}

			// If this is not first leaf node, compare its level with
			// first leaf's level
			return (level == leafLevel.leaflevel);
		}

		// If this node is not leaf, recursively check left and right subtrees
		return checkUtil(node.left, level + 1, leafLevel) && checkUtil(node.right, level + 1, leafLevel);
	}

	/*
	 * The main function to check if all leafs are at same level. It mainly uses
	 * checkUtil()
	 */
	boolean check(Node node) {
		int level = 0;
		return checkUtil(node, level, mylevel);
	}

	public static void main(String args[]) {
		IsAllLeafNodeAreAtSameLevel tree = new IsAllLeafNodeAreAtSameLevel();
		tree.root = new Node(12);
		tree.root.left = new Node(5);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(9);
		tree.root.left.left.left = new Node(1);
		tree.root.left.right.left = new Node(1);
		if (tree.check(tree.root)) {
			System.out.println("Leaves are at same level");

		} else {
			System.out.println("Leaves are not at same level");
		}

	}
}
