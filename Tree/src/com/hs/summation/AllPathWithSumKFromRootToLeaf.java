package com.hs.summation;

import java.util.ArrayList;
import java.util.List;

import com.hs.tree.Node;

// 113. Path Sum II Leetcode
public class AllPathWithSumKFromRootToLeaf {

	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> pathSum(Node root, int targetSum) {
		if (root == null) {
			return result;
		}
		List<Integer> path = new ArrayList<>();
		pathSumUtil(root, path, targetSum);
		return result;
	}

	private void pathSumUtil(Node root, List<Integer> path, int targetSum) {
		path.add(root.data);

		if (root.left == null && root.right == null) {
			int sum = 0;
			for (int i = path.size() - 1; i >= 0; i--) {
				sum += path.get(i);
			}
			if (sum == targetSum)
				result.add(new ArrayList<>(path));
		}

		if (root.left != null)
			pathSumUtil(root.left, path, targetSum);

		if (root.right != null)
			pathSumUtil(root.right, path, targetSum);
		path.remove(path.size() - 1);
	}

	public static void main(String[] args) {

		AllPathWithSumKFromRootToLeaf tree = new AllPathWithSumKFromRootToLeaf();

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
		List<List<Integer>> pathSum = tree.pathSum(root, k);
		System.out.println(pathSum);
	}
}