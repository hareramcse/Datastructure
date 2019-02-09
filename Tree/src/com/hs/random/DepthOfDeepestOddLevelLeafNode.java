package com.hs.random;

public class DepthOfDeepestOddLevelLeafNode {

	// A recursive function to find depth of the deepest odd level leaf
	int depthOfOddLeafUtil(Node node, int level) {
		// Base Case
		if (node == null) {
			return 0;
		}

		// If this node is a leaf and its level is odd, return its level
		if (node.left == null && node.right == null && (level & 1) != 0) {
			return level;
		}

		// If not leaf, return the maximum value from left and right subtrees
		return Math.max(depthOfOddLeafUtil(node.left, level + 1), depthOfOddLeafUtil(node.right, level + 1));
	}

	/*
	 * Main function which calculates the depth of deepest odd level leaf. This
	 * function mainly uses depthOfOddLeafUtil()
	 */
	int depthOfOddLeaf(Node node) {
		int level = 1;
		return depthOfOddLeafUtil(node, level);
	}

	public static void main(String args[]) {
		DepthOfDeepestOddLevelLeafNode tree = new DepthOfDeepestOddLevelLeafNode();
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
		root.right.right.right.right.left = new Node(11);
		System.out.println(tree.depthOfOddLeaf(root) + " is the required depth");
	}
}
