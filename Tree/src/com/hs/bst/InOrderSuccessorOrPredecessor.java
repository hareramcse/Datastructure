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
				// once we find the root greater than K then we will go to left
				// this node is greater than k node, but we are not sure
				// whether this is the immediate greater node
				// to find out immediate greater node we will go left left
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
			if ( k.data < root.data) {
				root = root.left;
			} else {
				prev = root;
				root = root.right;
			}
		}
		return prev;
	}

	public static void main(String[] args) {
		InOrderSuccessorOrPredecessor obj = new InOrderSuccessorOrPredecessor();
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(7);
		Node k = root.left.right;
		Node successor = obj.inOrderSuccessor(root, k);
		System.out.println(successor.data);
		Node predecessor = obj.inOrderPredecessor(root, k);
		System.out.println(predecessor.data);
	}
}