package com.hs.random;

public class DiffBetSumOfOddLevelAndEvenLevelNodes {

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
		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.left.right.left = new Node(3);
		root.right.right = new Node(8);
		root.right.right.right = new Node(9);
		root.right.right.left = new Node(7);
		System.out.println(tree.getLevelDiff(root) + " is the required difference");

	}
}
