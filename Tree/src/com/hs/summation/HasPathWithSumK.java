package com.hs.summation;

import com.hs.tree.Node;

public class HasPathWithSumK {
	public boolean hasPathSum(Node root, int targetSum) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null && targetSum == root.data)
			return true;
		return hasPathSum(root.left, targetSum - root.data) || hasPathSum(root.right, targetSum - root.data);
	}

	public static void main(String[] args) {
		HasPathWithSumK tree = new HasPathWithSumK();

		Node root = new Node(1);
		root.left = new Node(3);
		root.left.left = new Node(2);
		root.left.right = new Node(1);
		root.left.right.left = new Node(1);
		root.right = new Node(-1);
		root.right.left = new Node(4);
		root.right.left.left = new Node(1);
		root.right.left.right = new Node(2);
		root.right.right = new Node(5);
		root.right.right.right = new Node(2);

		int k = 5;

		boolean hasPathSum = tree.hasPathSum(root, k);
		System.out.println(hasPathSum);
	}
}