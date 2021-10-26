package com.hs.introduction;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	/* function to insert element in binary tree where 1st space is empty */
	private void insert(Node root, int data) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		// Do level order traversal until we find an empty place.
		while (!q.isEmpty()) {
			root = q.poll();

			if (root.left == null) {
				root.left = new Node(data);
				break;
			} else
				q.add(root.left);

			if (root.right == null) {
				root.right = new Node(data);
				break;
			} else
				q.add(root.right);
		}
	}

	/* function to delete the given deepest node in binary tree */
	private void deletDeepest(Node root, Node deepestNode) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		// Do level order traversal until last node
		while (!q.isEmpty()) {
			Node temp = q.poll();

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
	private void deletion(Node root, int key) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		Node temp = new Node();
		Node toBeDeleted = null;

		// Do level order traversal to find deepest
		// node(temp) and node to be deleted (key_node)
		while (!q.isEmpty()) {
			temp = q.poll();

			if (temp.data == key)
				toBeDeleted = temp;

			if (temp.left != null)
				q.add(temp.left);

			if (temp.right != null)
				q.add(temp.right);
		}

		int x = temp.data;
		deletDeepest(root, temp);
		toBeDeleted.data = x;
	}

	/* Inorder traversal of a binary tree */
	private void inorder(Node root) {
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