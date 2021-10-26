package com.hs.traversal;

public class InOrderSuccessor {

	// to store previous node
	private static class PreviousNode {
		Node previous;

		PreviousNode() {
			previous = null;
		}
	}

	// do the reverse inorder traversal
	private void inOrderSuccessorOfBinaryTree(Node root, PreviousNode pre, int searchNode) {
		if(root == null)
			return;
		
		// Case1: If right child is not NULL
		if (root.right != null)
			inOrderSuccessorOfBinaryTree(root.right, pre, searchNode);

		// Case2: If root data is equal to search node
		if (root.data == searchNode)
			System.out.println("inorder successor of " + searchNode + " is: "
					+ (pre.previous != null ? pre.previous.data : "null"));

		pre.previous = root;

		if (root.left != null)
			inOrderSuccessorOfBinaryTree(root.left, pre, searchNode);
	}

	public static void main(String[] args) {
		InOrderSuccessor tree = new InOrderSuccessor();

		// Let's construct the binary tree
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);

		// Case 1
		tree.inOrderSuccessorOfBinaryTree(root, new PreviousNode(), 3);

		// Case 2
		tree.inOrderSuccessorOfBinaryTree(root, new PreviousNode(), 4);

		// Case 3
		tree.inOrderSuccessorOfBinaryTree(root, new PreviousNode(), 6);
	}
}