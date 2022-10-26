package com.hs.misc;

import com.hs.tree.Node;

public class FlattenBinaryTreeToLinkedList {
	Node prev = null;

	public void flatten(Node root) {
		if (root == null)
			return;

		flatten(root.right);
		flatten(root.left);

		root.right = prev;
		root.left = null;
		prev = root;
	}

	public void preOrder(Node root) {
		if (root == null) {
			System.out.println("NULL ");
			return;
		}

		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList obj = new FlattenBinaryTreeToLinkedList();
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right = new Node(5);
		root.right.right = new Node(6);
		obj.flatten(root);
		obj.preOrder(root);
	}
}
