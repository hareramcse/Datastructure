package com.hs.misc;

import com.hs.tree.Node;

// number of nodes along the longest path from the root node down to the farthest leaf node.
// 104. Maximum Depth of Binary Tree Leetcode
class MaximumDepthOfTree {

	public int maxDepth(Node root) {
		if (root == null)
			return 0;

		int lDepth = maxDepth(root.left);
		int rDepth = maxDepth(root.right);

		// use the larger one
		if (lDepth > rDepth)
			return lDepth + 1;
		else
			return rDepth + 1;
	}

	// Driver program to test above functions
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