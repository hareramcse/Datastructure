package com.hs.bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hs.tree.Node;

// do level order traversal and print the first node in every level
class LeftViewOfBinaryTree {
	private List<Integer> leftView(Node root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				Node temp = queue.poll();
				if (i == 0) {
					result.add(temp.data);
				}

				// Enqueue left child
				if (temp.left != null) {
					queue.add(temp.left);
				}

				// Enqueue right child
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
		}
		return result;
	}

	public static void main(String args[]) {
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