package com.hs.summation;

import com.hs.tree.Node;

public class HasPathWithSumK {
	public boolean hasPathSum(Node root, int targetSum) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null && targetSum - root.data == 0)
			return true;
		return hasPathSum(root.left, targetSum - root.data) || hasPathSum(root.right, targetSum - root.data);
	}

	public static void main(String[] args) {
		HasPathWithSumK tree = new HasPathWithSumK();

		Node root = new Node(1);
		root.left = new Node(2);

		boolean hasPathSum = tree.hasPathSum(root, 2);
		System.out.println(hasPathSum);
	}
}
