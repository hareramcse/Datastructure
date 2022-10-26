package com.hs.summation;

import com.hs.tree.Node;

class MaximumPathSumFromRootToLeaf {
	public int maxPathSum(Node root) {
		int[] maxValue = new int[1];
		maxValue[0] = Integer.MIN_VALUE;
		maxPath(root, maxValue);
		return maxValue[0];
	}

	private int maxPath(Node root, int[] maxValue) {
		if (root == null)
			return 0;

		int left = Math.max(0, maxPath(root.left, maxValue));
		int right = Math.max(0, maxPath(root.right, maxValue));
		maxValue[0] = Math.max(maxValue[0], left + right + root.data);
		return root.data + Math.max(left, right);
	}

	public static void main(String[] args) {
		MaximumPathSumFromRootToLeaf tree = new MaximumPathSumFromRootToLeaf();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.left = new Node(8);
		root.right.right.right = new Node(9);
		System.out.println("Maximum path sum is: ");
		int maxPathSum = tree.maxPathSum(root);
		System.out.println(maxPathSum);
	}
}