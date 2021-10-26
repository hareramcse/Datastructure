package com.hs.checkandprint;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelOfEachNode {

	// User defined class Pair to hold the node and its level
	private static class Pair {
		Node n;
		int i;

		Pair(Node n, int i) {
			this.n = n;
			this.i = i;
		}

	}

	// function to print the nodes and its corresponding level
	private static void printLevel(Node root) {
		if (root == null)
			return;

		// queue to hold tree node with level
		Queue<Pair> q = new LinkedList<Pair>();

		// let root node be at level 1
		q.add(new Pair(root, 1));

		Pair p;

		// Do level Order Traversal of tree
		while (!q.isEmpty()) {
			p = q.peek();
			q.remove();

			System.out.println("Level of " + p.n.data + " is " + p.i);
			if (p.n.left != null)
				q.add(new Pair(p.n.left, p.i + 1));
			if (p.n.right != null)
				q.add(new Pair(p.n.right, p.i + 1));
		}
	}

	/*
	 * Driver function to test above functions
	 */
	public static void main(String args[]) {
		Node root = null;

		/*
		 * Constructing tree given in the above figure
		 */
		root = new Node(3);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(4);

		printLevel(root);
	}
}