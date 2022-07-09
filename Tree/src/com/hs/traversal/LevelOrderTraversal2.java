package com.hs.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 102. Binary Tree Level Order Traversal Leetcode
class LevelOrderTraversal2 {

	public List<List<Integer>> levelOrderTraversal(Node root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int level = queue.size();
			List<Integer> subList = new ArrayList<>();
			for (int i = 0; i < level; i++) {
				Node tempNode = queue.poll();
				subList.add(tempNode.data);
				
				/* Enqueue left child */
				if (tempNode.left != null) {
					queue.add(tempNode.left);
				}

				/* Enqueue right child */
				if (tempNode.right != null) {
					queue.add(tempNode.right);
				}
			}
			list.add(subList);
		}
		return list;
	}

	public static void main(String args[]) {
		LevelOrderTraversal2 tree = new LevelOrderTraversal2();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("Level order traversal of binary tree is:");
		List<List<Integer>> list = tree.levelOrderTraversal(root);
		System.out.println(list);
	}
}