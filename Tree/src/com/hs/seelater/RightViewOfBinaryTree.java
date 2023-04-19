package com.hs.seelater;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hs.tree.Node;

class RightViewOfBinaryTree {
	public List<Integer> rightView(Node root) {
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				Node temp = queue.poll();
				if (i == 0) {
					list.add(temp.data);
				}

				// Enqueue right child
				if (temp.right != null) {
					queue.add(temp.right);
				}

				// Enqueue left child
				if (temp.left != null) {
					queue.add(temp.left);
				}
			}
		}
		return list;
	}

	public static void main(String args[]) {
		RightViewOfBinaryTree tree = new RightViewOfBinaryTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);

		List<Integer> list = tree.rightView(root);
		System.out.println(list);
	}
}