package com.hs.misc;

import java.util.LinkedList;
import java.util.Queue;

class IterativeWayToFindHightOfTree {

	// Iterative method to find height of Bianry Tree
	int treeHeight(Node node) {
		// Base Case
		if (node == null)
			return 0;

		// Create an empty queue for level order tarversal
		Queue<Node> q = new LinkedList<Node>();

		// Enqueue Root and initialize height
		q.add(node);
		int height = 0;

		while (true) {
			// nodeCount (queue size) indicates number of nodes
			// at current level.
			int nodeCount = q.size();
			if (nodeCount == 0)
				return height;
			height++;

			// Dequeue all nodes of current level and Enqueue all
			// nodes of next level
			while (nodeCount > 0) {
				Node newnode = q.peek();
				q.remove();
				if (newnode.left != null)
					q.add(newnode.left);
				if (newnode.right != null)
					q.add(newnode.right);
				nodeCount--;
			}
		}
	}

	// Driver program to test above functions
	public static void main(String args[]) {
		IterativeWayToFindHightOfTree tree = new IterativeWayToFindHightOfTree();

		// Let us create a binary tree shown in above diagram
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		System.out.println("Height of tree is " + tree.treeHeight(root));
	}
}