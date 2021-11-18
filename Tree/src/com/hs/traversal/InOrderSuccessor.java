package com.hs.traversal;

/*
 * Inorder Successor of a node in binary tree is the next node in Inorder traversal of the 
 * Binary Tree. Inorder Successor is NULL for the last node in Inorder traversal.*/
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
		if (root == null)
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

	// Given a binary tree, print its nodes in inorder
	private void printInorder(Node root) {
		if (root == null)
			return;

		/* first recur on left child */
		printInorder(root.left);

		/* then print the data of node */
		System.out.print(root.data + " ");

		/* now recur on right child */
		printInorder(root.right);
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

		tree.printInorder(root);
		System.out.println();

		// Case 1
		tree.inOrderSuccessorOfBinaryTree(root, new PreviousNode(), 3);

		// Case 2
		tree.inOrderSuccessorOfBinaryTree(root, new PreviousNode(), 4);

		// Case 3
		tree.inOrderSuccessorOfBinaryTree(root, new PreviousNode(), 6);

		// Case 4
		tree.inOrderSuccessorOfBinaryTree(root, new PreviousNode(), 5);
	}
}