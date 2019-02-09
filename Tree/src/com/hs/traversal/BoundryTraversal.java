package com.hs.traversal;

class BoundryTraversal {

	// A simple function to print leaf nodes of a binary tree
	void printLeaves(Node root) {
		if (root != null) {
			printLeaves(root.left);

			// Print it if it is a leaf node
			if (root.left == null && root.right == null) {
				System.out.print(root.data + " ");
			}
			printLeaves(root.right);
		}
	}

	// A function to print all left boundary nodes, except a leaf node.
	// Print the nodes in TOP DOWN manner
	void printBoundaryLeft(Node root) {
		if (root != null) {
			if (root.left != null) {

				// to ensure top down order, print the node
				// before calling itself for left subtree
				System.out.print(root.data + " ");
				printBoundaryLeft(root.left);
			}
		}
	}

	// A function to print all right boundary nodes, except a leaf node
	// Print the nodes in BOTTOM UP manner
	void printBoundaryRight(Node root) {
		if (root != null) {
			if (root.right != null) {
				// to ensure bottom up order, first call for right
				// subtree, then print this node
				printBoundaryRight(root.right);
				System.out.print(root.data + " ");
			}
		}
	}

	// A function to do boundary traversal of a given binary tree
	void printBoundary(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");

			// Print the left boundary in top-down manner.
			printBoundaryLeft(root.left);

			// Print all leaf nodes
			printLeaves(root);

			// Print the right boundary in bottom-up manner
			printBoundaryRight(root.right);
		}
	}

	// Driver program to test above functions
	public static void main(String args[]) {
		BoundryTraversal tree = new BoundryTraversal();
		Node root = new Node(20);
		root.left = new Node(8);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		root.right = new Node(22);
		root.right.right = new Node(25);
		tree.printBoundary(root);
	}
}