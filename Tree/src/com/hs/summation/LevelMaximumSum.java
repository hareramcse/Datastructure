package com.hs.summation;

import java.util.LinkedList;
import java.util.Queue;

import com.hs.tree.Node;

public class LevelMaximumSum {
	public int maxLevelSum(Node root) {
		if (root == null)
			return 0;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		int level = 0;
		int maxSumLevel = 0;
		int max = Integer.MIN_VALUE;
		while (!queue.isEmpty()) {
			level++;
			int sum = 0;
			int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				Node temp = queue.poll();
				sum += temp.data;

				// Enqueue left child
				if (temp.left != null) {
					queue.add(temp.left);
				}

				// Enqueue right child
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
			if (sum > max) {
				max = sum;
				maxSumLevel = level;
			}
		}
		return maxSumLevel;
	}

	public static void main(String[] args) {
		LevelMaximumSum tree = new LevelMaximumSum();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(8);
		root.right.right.left = new Node(6);
		root.right.right.right = new Node(7);

		System.out.println("Level of maximum sum is: " + tree.maxLevelSum(root));
	}
}