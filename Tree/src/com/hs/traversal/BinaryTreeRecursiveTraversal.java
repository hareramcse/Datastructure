package com.hs.traversal;

import com.hs.tree.Node;

public class BinaryTreeRecursiveTraversal {
	public void printPostorder(Node root) {
		if (root == null)
			return;

		printPostorder(root.left);
		printPostorder(root.right);
		System.out.print(root.data + " ");
	}

	private void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

	private void printPreorder(Node root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}

	public static void main(String[] args) {
		BinaryTreeRecursiveTraversal tree = new BinaryTreeRecursiveTraversal();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder(root);

		System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder(root);

		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printPostorder(root);
	}
}