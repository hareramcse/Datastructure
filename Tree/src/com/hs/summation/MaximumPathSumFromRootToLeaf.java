package com.hs.summation;

import java.util.ArrayList;
import java.util.List;

import com.hs.tree.Node;

class MaximumPathSumFromRootToLeaf {
	int maxPathSum = Integer.MIN_VALUE;

	public int maxPathSum(Node root) {
		if (root == null) {
			return 0;
		}
		List<Integer> path = new ArrayList<>();
		maxPathSumutil(root, path);
		return maxPathSum;
	}

	private void maxPathSumutil(Node root, List<Integer> path) {
		path.add(root.data);

		if (root.left == null && root.right == null) {
			int sum = 0;
			for (int i = path.size() - 1; i >= 0; i--) {
				sum += path.get(i);
			}
			maxPathSum = Math.max(maxPathSum, sum);
		}

		if (root.left != null)
			maxPathSumutil(root.left, path);

		if (root.right != null)
			maxPathSumutil(root.right, path);
		path.remove(path.size() - 1);
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