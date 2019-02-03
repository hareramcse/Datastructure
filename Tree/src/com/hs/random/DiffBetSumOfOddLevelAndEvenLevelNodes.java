package com.hs.random;

public class DiffBetSumOfOddLevelAndEvenLevelNodes {

	// The main function that return difference between odd and even level
	// nodes

	Node root;

	int getLevelDiff(Node node) {
		// Base case
		if (node == null) {
			return 0;
		}

		// Difference for root is root's data - difference for left subtree
		// - difference for right subtree
		return node.data - getLevelDiff(node.left) - getLevelDiff(node.right);
	}

	// Driver program to test above functions
	public static void main(String args[]) {

		DiffBetSumOfOddLevelAndEvenLevelNodes tree = new DiffBetSumOfOddLevelAndEvenLevelNodes();
		tree.root = new Node(5);
		tree.root.left = new Node(2);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(4);
		tree.root.left.right.left = new Node(3);
		tree.root.right.right = new Node(8);
		tree.root.right.right.right = new Node(9);
		tree.root.right.right.left = new Node(7);
		System.out.println(tree.getLevelDiff(tree.root) + " is the required difference");

	}
}
