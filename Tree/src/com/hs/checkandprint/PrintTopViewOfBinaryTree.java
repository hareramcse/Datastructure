package com.hs.checkandprint;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

class PrintTopViewOfBinaryTree {

	// function should print the topView of
	// the binary tree
	private void topView(Node root) {
		class QueueObj {
			Node node;
			int hd;

			QueueObj(Node node, int hd) {
				this.node = node;
				this.hd = hd;
			}
		}
		Queue<QueueObj> queue = new LinkedList<QueueObj>();
		Map<Integer, Node> map = new TreeMap<Integer, Node>();

		if (root == null) {
			return;
		} else {
			queue.add(new QueueObj(root, 0));
		}

		System.out.println("The top view of the tree is : ");

		// count function returns 1 if the container
		// contains an element whose key is equivalent
		// to hd, or returns zero otherwise.
		while (!queue.isEmpty()) {
			QueueObj tmpNode = queue.poll();
			if (!map.containsKey(tmpNode.hd)) {
				map.put(tmpNode.hd, tmpNode.node);
			}

			if (tmpNode.node.left != null) {
				queue.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1));
			}
			if (tmpNode.node.right != null) {
				queue.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1));
			}

		}
		for (Entry<Integer, Node> entry : map.entrySet()) {
			System.out.print(entry.getValue().data);
		}
	}

	// Driver Program to test above functions
	public static void main(String[] args) {
		/*
		 * Create following Binary Tree 1 / \ 2 3 \ 4 \ 5 \ 6
		 */
		PrintTopViewOfBinaryTree tree = new PrintTopViewOfBinaryTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.left.right.right = new Node(5);
		root.left.right.right.right = new Node(6);
		System.out.println("Following are nodes in top view of Binary Tree");
		tree.topView(root);
	}
}