package com.hs.bt;

import java.util.ArrayList;
import java.util.List;

import com.hs.tree.Node;

public class PathSumCount {
	public int pathSum(Node root, int targetSum) {
		List<Integer> path = new ArrayList<>();
		int[] count = new int[1];
		backtrack(root, targetSum, path, count);
		return count[0];
	}

	private void backtrack(Node root, int targetSum, List<Integer> path, int[] count) {
		if (root == null)
			return;

		path.add(root.data);

		// Here we need to check every node not only leaf node
		int sum = 0;
		for (int i = path.size() - 1; i >= 0; i--) {
			sum += path.get(i);
			if (sum == targetSum)
				count[0]++;
		}

		backtrack(root.left, targetSum, path, count);
		backtrack(root.right, targetSum, path, count);
		path.remove(path.size() - 1);
	}

	public static void main(String[] args) {
		PathSumCount tree = new PathSumCount();

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

		int count = tree.pathSum(root, 5);
		System.out.println(count);
	}
}