package com.hs.misc;

import com.hs.tree.Node;

// diameter of a tree is maximum value of (left_height + right_height + 1) for each node
// 543. Diameter of Binary Tree Leetcode
class DiameterOfBinaryTree {

	int ans = Integer.MAX_VALUE;

	public int diameterOfBinaryTree(Node root) {
		if (root == null)
			return 0;

		maxHeightOfEachNode(root);
		return ans;
	}

	private int maxHeightOfEachNode(Node root) {
		if (root == null)
			return 0;

		int leftHeight = maxHeightOfEachNode(root.left);
		int rightHeight = maxHeightOfEachNode(root.right);
		ans = Math.max(ans, leftHeight + rightHeight);
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public static void main(String[] args) {
		DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("Diameter is " + tree.diameterOfBinaryTree(root));
	}
}