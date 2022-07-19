package com.hs.bst;

import com.hs.tree.Node;

// 285. Inorder successor in BST Leetcode
public class InOrderSuccessor {

	public Node inOrderSuccessor(Node root, Node k) {
		if (root == null)
			return null;

		Node current = root;
		Node prev = null;
		while (current != null) {
			if (k.data < current.data) {
				prev = current;
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return prev;
	}

	public static void main(String[] args) {
		InOrderSuccessor tree = new InOrderSuccessor();
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