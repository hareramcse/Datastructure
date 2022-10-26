package com.hs.misc;

import java.util.LinkedList;
import java.util.Queue;

import com.hs.tree.Node;

public class FindLevelOfNode {

	public int getLevel(Node root, int data) {
		if (root == null)
			return 0;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		int level = 0;
		while (!queue.isEmpty()) {
			level++;
			int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				Node temp = queue.poll();
				if (temp.data == data) {
					return level;
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
		return -1;
	}

	public static void main(String[] args) {
		FindLevelOfNode tree = new FindLevelOfNode();

		Node root = new Node(3);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		for (int x = 1; x <= 5; x++) {
			int level = tree.getLevel(root, x);
			if (level != 0)
				System.out.println("Level of " + x + " is " + tree.getLevel(root, x));
			else
				System.out.println(x + " is not present in tree");
		}
	}
}