package com.hs.summation;

import java.util.ArrayList;
import java.util.List;

import com.hs.tree.Node;

// 437. Path Sum III Leetcode
public class PathSumCount {
	int count = 0;

	public int pathSum(Node root, int targetSum) {
		if (root == null)
			return count;
		List<Integer> path = new ArrayList<>();
		pathSumUtil(root, path, targetSum);
		return count;
	}

	private void pathSumUtil(Node root, List<Integer> path, int targetSum) {
		path.add(root.data);
		
		// Here we need to check every node not only leaf node
		int sum = 0;
		for (int i = path.size() - 1; i >= 0; i--) {
			sum += path.get(i);
			if (sum == targetSum)
				count++;
		}
		
		if (root.left != null)
			pathSumUtil(root.left, path, targetSum);

		if (root.right != null)
			pathSumUtil(root.right, path, targetSum);
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
