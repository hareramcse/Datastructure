package com.hs.misc;

class Level {
	// maxlevel: gives the value of level of maximum left leaf
	int maxLevel = 0;
}

public class DeepestLeftNode {
	// Node to store resultant node after left traversal
	private Node result;

	// A wrapper over deepestLeftLeafUtil().
	private void deepestLeftLeaf(Node node) {
		Level level = new Level();
		deepestLeftLeafUtil(node, 0, level, false);
	}

	// A utility function to find deepest leaf node.
	// lvl: level of current node.
	// isLeft: A bool indicate that this node is left child
	private void deepestLeftLeafUtil(Node node, int lvl, Level level, boolean isLeft) {
		// Base case
		if (node == null)
			return;

		// Update result if this node is left leaf and its level is more
		// than the maxl level of the current result
		if (isLeft && node.left == null && node.right == null && lvl > level.maxLevel) {
			result = node;
			level.maxLevel = lvl;
		}

		// Recur for left and right subtrees
		deepestLeftLeafUtil(node.left, lvl + 1, level, true);
		deepestLeftLeafUtil(node.right, lvl + 1, level, false);
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		DeepestLeftNode tree = new DeepestLeftNode();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.right = new Node(7);
		root.right.right.right = new Node(8);
		root.right.left.right.left = new Node(9);
		root.right.right.right.right = new Node(10);

		tree.deepestLeftLeaf(root);
		if (tree.result != null)
			System.out.println("The deepest left child is " + tree.result.data);
		else
			System.out.println("There is no left leaf in the given tree");
	}
}
