package com.hs.summation;

import java.util.ArrayList;
import java.util.List;

import com.hs.tree.Node;

// 112. Path Sum Leetcode
public class HasPathWithSumK {

	boolean isPath;

	public boolean hasPathSum(Node root, int targetSum) {
		if (root == null)
			return isPath;

		List<Integer> path = new ArrayList<>();
		pathSumUtil(root, path, targetSum);
		return isPath;
	}

	public void pathSumUtil(Node root, List<Integer> path, int targetSum) {
		path.add(root.data);
		if (root.left == null && root.right == null) {
			int sum = 0;
			for (int i = path.size() - 1; i >= 0; i--) {
				sum += path.get(i);
				if (sum == targetSum) {
					isPath = true;
					return;
				}
			}
		}

		if (root.left != null)
			pathSumUtil(root.left, path, targetSum);

		if (root.right != null)
			pathSumUtil(root.right, path, targetSum);
		path.remove(path.size() - 1);
	}

	public static void main(String[] args) {
		HasPathWithSumK tree = new HasPathWithSumK();

		Node root = new Node(1);
		root.left = new Node(2);

		boolean hasPathSum = tree.hasPathSum(root, 2);
		System.out.println(hasPathSum);
	}
}
