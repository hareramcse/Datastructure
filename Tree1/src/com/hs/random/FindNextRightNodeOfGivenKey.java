package com.hs.random;

import java.util.LinkedList;
import java.util.Queue;

public class FindNextRightNodeOfGivenKey {

	static Node root;

	// Method to find next right of given key k, it returns NULL if k is
	// not present in tree or k is the rightmost node of its level
	Node nextRight(Node first, int k) {

		// Base Case
		if (first == null) {
			return null;
		}

		// Create an empty queue for level order tarversal
		Queue<Node> qn = new LinkedList<Node>(); // A queue to store node
													// addresses
		Queue<Integer> ql = new LinkedList<Integer>(); // Another queue to store
														// node levels

		int level = 0; // Initialize level as 0

		// Enqueue Root and its level
		qn.add(first);
		ql.add(level);

		// A standard BFS loop
		while (qn.size() != 0) {

			// dequeue an node from qn and its level from ql
			Node node = qn.peek();
			level = ql.peek();
			qn.remove();
			ql.remove();

			// If the dequeued node has the given key k
			if (node.data == k) {

				// If there are no more items in queue or given node is
				// the rightmost node of its level, then return NULL
				if (ql.size() == 0 || ql.peek() != level) {
					return null;
				}

				// Otherwise return next node from queue of nodes
				return qn.peek();
			}

			// Standard BFS steps: enqueue children of this node
			if (node.left != null) {
				qn.add(node.left);
				ql.add(level + 1);
			}
			if (node.right != null) {
				qn.add(node.right);
				ql.add(level + 1);
			}
		}

		// We reach here if given key x doesn't exist in tree
		return null;
	}

	// A utility function to test above functions
	void test(Node node, int k) {
		Node nr = nextRight(root, k);
		if (nr != null) {
			System.out.println("Next Right of " + k + " is " + nr.data);
		} else {
			System.out.println("No next right node found for " + k);
		}
	}

	// driver program to test above functions
	public static void main(String args[]) {
		FindNextRightNodeOfGivenKey tree = new FindNextRightNodeOfGivenKey();
		tree.root = new Node(10);
		tree.root.left = new Node(2);
		tree.root.right = new Node(6);
		tree.root.right.right = new Node(5);
		tree.root.left.left = new Node(8);
		tree.root.left.right = new Node(4);

		tree.test(root, 10);
		tree.test(root, 2);
		tree.test(root, 6);
		tree.test(root, 5);
		tree.test(root, 8);
		tree.test(root, 4);

	}
}
