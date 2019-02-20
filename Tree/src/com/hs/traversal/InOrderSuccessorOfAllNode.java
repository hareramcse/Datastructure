package com.hs.traversal;

public class InOrderSuccessorOfAllNode {
	Node next = null;

	void populateNext(Node root) {

		// The first visited node will be the rightmost node
		// next of the rightmost node will be NULL
		populateNextRecur(root, next);
	}

	/* Set next of all descendents of p by traversing them in reverse Inorder */
	void populateNextRecur(Node p, Node next_ref) {
		if (p != null) {

			// First set the next pointer in right subtree
			populateNextRecur(p.right, next_ref);

			// Set the next as previously visited node in reverse Inorder
			p.next = next_ref;

			// Change the prev for subsequent node
			next_ref = p;

			// Finally, set the next pointer in right subtree
			populateNextRecur(p.left, next_ref);
		}
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		/*
		 * Constructed binary tree is 10 / \ 8 12 / 3
		 */
		InOrderSuccessorOfAllNode tree = new InOrderSuccessorOfAllNode();
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(12);
		root.left.left = new Node(3);

		// Populates nextRight pointer in all nodes
		tree.populateNext(root);

		// Let us see the populated values
		Node ptr = root.left.left;
		while (ptr != null) {
			// -1 is printed if there is no successor
			int print = ptr.next != null ? ptr.next.data : -1;
			System.out.println("Next of " + ptr.data + " is: " + print);
			ptr = ptr.next;
		}
	}
}