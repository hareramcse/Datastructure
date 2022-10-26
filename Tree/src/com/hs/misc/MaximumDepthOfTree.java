package com.hs.misc;

import com.hs.tree.Node;

class MaximumDepthOfTree {
	public int maxDepth(Node root) {
		if (root == null)
			return 0;

		int lDepth = maxDepth(root.left);
		int rDepth = maxDepth(root.right);

		return 1 + Math.max(lDepth, rDepth);
	}

	public static void main(String[] args) {
		MaximumDepthOfTree tree = new MaximumDepthOfTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		System.out.println("Height of tree is : " + tree.maxDepth(root));
	}
}