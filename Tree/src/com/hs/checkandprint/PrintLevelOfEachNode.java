package com.hs.checkandprint;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelOfEachNode {

	// User defined class Pair to hold the node and its level
	private class Pair {
		Node node;
		int i;

		Pair(Node node, int i) {
			this.node = node;
			this.i = i;
		}

	}

	// function to print the nodes and its corresponding level
	private void printLevel(Node root) {
		if (root == null)
			return;

		// queue to hold tree node with level
		Queue<Pair> q = new LinkedList<Pair>();

		// let root node be at level 1
		q.add(new Pair(root, 1));

		// Do level Order Traversal of tree
		while (!q.isEmpty()) {
			Pair p = q.peek();
			q.remove();

			System.out.println("Level of " + p.node.data + " is " + p.i);
			if (p.node.left != null)
				q.add(new Pair(p.node.left, p.i + 1));
			if (p.node.right != null)
				q.add(new Pair(p.node.right, p.i + 1));
		}
	}

	/*
	 * Driver function to test above functions
	 */
	public static void main(String args[]) {
		PrintLevelOfEachNode tree = new PrintLevelOfEachNode();
		Node root = null;
		root = new Node(3);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(4);

		tree.printLevel(root);
	}
}