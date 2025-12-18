package com.hs.bst;

import com.hs.tree.Node;

//Time Complexity: O(n) where h = height of tree.
//Space Complexity: O(1) Iterative, no recursion
public class InOrderSuccessorOrPredecessor {

	public Node inOrderSuccessor(Node root, Node k) {
		if (root == null || k == null)
			return null;

		Node successor = null;

		while (root != null) {
			if (k.data < root.data) {
				successor = root;
				root = root.left;
			} else if (k.data > root.data) {
				root = root.right;
			} else {
				// Case 1: right subtree exists
				if (root.right != null) {
					Node temp = root.right;
					while (temp.left != null) {
						temp = temp.left;
					}
					successor = temp;
				}
				break;
			}
		}
		return successor;
	}

	public Node inOrderPredecessor(Node root, Node k) {
		if (root == null || k == null)
			return null;

		Node predecessor = null;

		while (root != null) {
			if (k.data > root.data) {
				predecessor = root;
				root = root.right;
			} else if (k.data < root.data) {
				root = root.left;
			} else {
				// Case 1: left subtree exists
				if (root.left != null) {
					Node temp = root.left;
					while (temp.right != null) {
						temp = temp.right;
					}
					predecessor = temp;
				}
				break;
			}
		}
		return predecessor;
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

		Node k = root.left.right; // 3

		Node successor = obj.inOrderSuccessor(root, k);
		System.out.println(successor != null ? successor.data : "null"); // 4

		Node predecessor = obj.inOrderPredecessor(root, k);
		System.out.println(predecessor != null ? predecessor.data : "null"); // 2
	}
}