package com.hs.traversal;

import java.util.LinkedList;
import java.util.Queue;

class LevelOrderTraversal2 {

	private void printLevelOrder(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.print(tempNode.data + " ");

			/* Enqueue left child */
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			/* Enqueue right child */
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}

	public static void main(String args[]) {
		LevelOrderTraversal2 tree_level = new LevelOrderTraversal2();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("Level order traversal of binary tree is:");
		tree_level.printLevelOrder(root);
	}
}
