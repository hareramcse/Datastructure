package com.hs.bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hs.tree.Node;

class LevelOrderIterative {
	public List<List<Integer>> levelOrderTraversal(Node root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < levelSize; i++) {
				Node tempNode = queue.poll();
				list.add(tempNode.data);
				
				// Enqueue left child
				if (tempNode.left != null) {
					queue.add(tempNode.left);
				}

				// Enqueue right child
				if (tempNode.right != null) {
					queue.add(tempNode.right);
				}
			}
			result.add(list);
		}
		return result;
	}

	public static void main(String args[]) {
		LevelOrderIterative tree = new LevelOrderIterative();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(4);

		System.out.println("Level order traversal of binary tree is:");
		List<List<Integer>> list = tree.levelOrderTraversal(root);
		System.out.println(list);
	}
}