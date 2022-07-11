package com.hs.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hs.tree.Node;

// do level order traversal and print the first node in every level
class LeftViewOfBinaryTree {
	private List<Integer> leftView(Node root) {
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				Node tempNode = queue.poll();
				if (i == 0) {
					list.add(tempNode.data);
				}

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
		return list;
	}

	/* testing for example nodes */
	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		LeftViewOfBinaryTree tree = new LeftViewOfBinaryTree();
		Node root = new Node(12);
		root.left = new Node(10);
		root.right = new Node(30);
		root.right.left = new Node(25);
		root.right.right = new Node(40);

		List<Integer> list = tree.leftView(root);
		System.out.println(list);
	}
}
