package com.hs.bst;

import com.hs.tree.Node;

public class InOrderSuccessorOrPredecessor {

	public Node inOrderSuccessor(Node root, Node k) {
		if (root == null)
			return null;

		Node prev = null;
		while (root != null) {
			if (k.data < root.data) {
				prev = root;
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return prev;
	}
	
	public Node inOrderPredecessor(Node root, Node k) {
		if (root == null)
			return null;

		Node prev = null;
		while (root != null) {
			if (k.data < root.data) {
				root = root.left;
			} else {
				prev = root;
				root = root.right;
			}
		}
		return prev;
	}

	public static void main(String[] args) {
		InOrderSuccessorOrPredecessor tree = new InOrderSuccessorOrPredecessor();
		Node root = new Node(50);
		root.left = new Node(30);
		root.left.left = new Node(20);
		root.left.right = new Node(40);
		root.right = new Node(70);
		root.right.left = new Node(60);
		root.right.right = new Node(80);
		Node temp = root.left.right;
		System.out.println(tree.inOrderSuccessor(root, temp).data);
	}
}