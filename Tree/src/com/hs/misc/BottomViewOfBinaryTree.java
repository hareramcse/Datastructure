package com.hs.misc;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {

	public void printBottomView(Node root) {
		if (root == null) {
			return;
		}

		Map<Integer, Integer> m = new TreeMap<Integer, Integer>();

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {
			Node temp = q.remove();
			int hd = temp.height;

			m.put(hd, temp.data);

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

	public static void main(String[] args) {
		BottomViewOfBinaryTree tree = new BottomViewOfBinaryTree();
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(25);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		tree.printBottomView(root);
	}
}