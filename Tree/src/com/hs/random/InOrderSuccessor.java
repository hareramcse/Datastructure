package com.hs.random;

public class InOrderSuccessor {

	Node next;

	/*
	 * Set next of p and all descendents of p by traversing them in reverse Inorder
	 */
	void populateNext(Node node) {

		// The first visited node will be the rightmost node
		// next of the rightmost node will be NULL
		if (node != null) {

			// First set the next pointer in right subtree
			populateNext(node.right);

			// Set the next as previously visited node in reverse Inorder
			node.next = next;

			// Change the prev for subsequent node
			next = node;

			// Finally, set the next pointer in left subtree
			populateNext(node.left);
		}
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {

		/*
		 * Constructed binary tree is 10 / \ 8 12 / 3
		 */
		InOrderSuccessor tree = new InOrderSuccessor();
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
