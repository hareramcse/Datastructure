package com.hs.traversal;

import com.hs.tree.Node;

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
	public Node inOrderSuccessor(Node root, PreviousNode pre, int searchNode) {
		if (root == null)
			return root;

		// Case1: If right child is not NULL
		Node right = inOrderSuccessor(root.right, pre, searchNode);
		if (right != null) {
			return right;
		}

		// Case2: If root data is equal to search node
		if (root.data == searchNode)
			return pre.previous;

		pre.previous = root;
		return inOrderSuccessor(root.left, pre, searchNode);
	}

	// Given a binary tree, print its nodes in inorder
	private void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");
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
		Node inOrderSuccessor = tree.inOrderSuccessor(root, new PreviousNode(), 3);
		if (inOrderSuccessor != null) {
			System.out.println(inOrderSuccessor.data);
		} else {
			System.out.println("null");
		}

		// Case 2
		inOrderSuccessor = tree.inOrderSuccessor(root, new PreviousNode(), 4);
		if (inOrderSuccessor != null) {
			System.out.println(inOrderSuccessor.data);
		} else {
			System.out.println("null");
		}

		// Case 3
		inOrderSuccessor = tree.inOrderSuccessor(root, new PreviousNode(), 6);
		if (inOrderSuccessor != null) {
			System.out.println(inOrderSuccessor.data);
		} else {
			System.out.println("null");
		}

		// Case 4
		inOrderSuccessor = tree.inOrderSuccessor(root, new PreviousNode(), 5);
		if (inOrderSuccessor != null) {
			System.out.println(inOrderSuccessor.data);
		} else {
			System.out.println("null");
		}
	}
}