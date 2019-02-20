package com.hs.introduction;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	/* function to insert element in binary tree */
	void insert(Node root, int key) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		// Do level order traversal until we find
		// an empty place.
		while (!q.isEmpty()) {
			root = q.peek();
			q.remove();

			if (root.left == null) {
				root.left = new Node(key);
				break;
			} else
				q.add(root.left);

			if (root.right == null) {
				root.right = new Node(key);
				break;
			} else
				q.add(root.right);
		}
	}

	/*
	 * function to delete the given deepest node (d_node) in binary tree
	 */
	void deletDeepest(Node root, Node deepestNode) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		// Do level order traversal until last node
		Node temp;
		while (!q.isEmpty()) {
			temp = q.peek();
			q.poll();

			if (temp.right != null) {
				if (temp.right == deepestNode) {
					temp.right = null;
					return;
				} else
					q.add(temp.right);
			}

			if (temp.left != null) {
				if (temp.left == deepestNode) {
					temp.left = null;
					return;
				} else
					q.add(temp.left);
			}
		}
	}

	/* function to delete element in binary tree */
	void deletion(Node root, int key) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		Node temp = new Node();
		Node key_node = null;

		// Do level order traversal to find deepest
		// node(temp) and node to be deleted (key_node)
		while (!q.isEmpty()) {
			temp = q.peek();
			q.poll();

			if (temp.data == key)
				key_node = temp;

			if (temp.left != null)
				q.add(temp.left);

			if (temp.right != null)
				q.add(temp.right);
		}

		int x = temp.data;
		deletDeepest(root, temp);
		key_node.data = x;
	}

	/* Inorder traversal of a binary tree */
	void inorder(Node root) {
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static void main(String args[]) {

		BinaryTree tree = new BinaryTree();

		Node root = new Node(10);
		root.left = new Node(11);
		root.left.left = new Node(7);
		root.right = new Node(9);
		root.right.left = new Node(15);
		root.right.right = new Node(8);

		System.out.print("Inorder traversal before insertion:");
		tree.inorder(root);

		int data = 12;
		tree.insert(root, data);

		System.out.print("\nInorder traversal after insertion:");
		tree.inorder(root);

		tree.deletion(root, 12);
		System.out.print("\nInorder traversal after deletion:");
		tree.inorder(root);
	}
}