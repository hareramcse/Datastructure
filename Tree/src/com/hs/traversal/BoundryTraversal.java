package com.hs.traversal;

import java.util.ArrayList;
import java.util.List;

import com.hs.tree.Node;

class BoundryTraversal {
	public List<Integer> printBoundary(Node root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		// if there is only node in the BT
		if (root.left == null && root.right == null) {
			result.add(root.data);
			return result;
		} else {
			result.add(root.data);
		}

		// Print the left boundary in top-down manner.
		leftBoundary(root.left, result);

		// Print all leaf nodes
		printLeaves(root, result);

		// Print the right boundary in bottom-up manner
		rightBoundary(root.right, result);
		return result;
	}

	// Print the nodes in TOP DOWN manner
	private void leftBoundary(Node root, List<Integer> result) {
		if (root == null)
			return;
		
		if (root.left == null && root.right == null) {
			return;
		}

		result.add(root.data);
		if (root.left != null) {
			leftBoundary(root.left, result);
		} else if (root.right != null) {
			leftBoundary(root.right, result);
		}
	}

	// A simple function to print leaf nodes of a binary tree
	private void printLeaves(Node root, List<Integer> result) {
		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			result.add(root.data);
		}

		printLeaves(root.left, result);
		printLeaves(root.right, result);
	}

	// Print the nodes in BOTTOM UP manner
	private void rightBoundary(Node root, List<Integer> result) {
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}

		if (root.right != null) {
			rightBoundary(root.right, result);
		} else if (root.left != null) {
			rightBoundary(root.left, result);
		}
		result.add(root.data);
	}

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
		List<Integer> result = tree.printBoundary(root);
		System.out.println(result);
	}
}