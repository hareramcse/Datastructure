package com.hs.misc;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class TopViewOfBinaryTree {

	public void topView(Node node) {
		if (node == null) {
			return;
		}

		Map<Integer, Integer> m = new TreeMap<Integer, Integer>();

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		while (!q.isEmpty()) {
			Node temp = q.remove();
			int hd = temp.height;

			if (m.get(hd) == null) {
				m.put(hd, temp.data);
			}

			if (temp.left != null) {
				temp.left.height = hd - 1;
				q.add(temp.left);
			}

			if (temp.right != null) {
				temp.right.height = hd + 1;
				q.add(temp.right);
			}
		}
		System.out.println(m.values());
	}

	// Driver Program to test above functions
	public static void main(String[] args) {
		TopViewOfBinaryTree tree = new TopViewOfBinaryTree();
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