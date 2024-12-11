package com.hs.bt;

import java.util.ArrayList;
import java.util.List;

import com.hs.tree.Node;

public class AllPathWithSumKFromRootToLeaf {
	public List<List<Integer>> pathSum(Node root, int targetSum) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		backtrack(root, targetSum, path, result);
		return result;
	}

	public void backtrack(Node root, int targetSum, List<Integer> path, List<List<Integer>> result) {
		if (root == null)
			return;

		path.add(root.data);

		if (root.left == null && root.right == null && root.data == targetSum) {
			result.add(new ArrayList<>(path));
		}

		backtrack(root.left, targetSum - root.data, path, result);
		backtrack(root.right, targetSum - root.data, path, result);
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