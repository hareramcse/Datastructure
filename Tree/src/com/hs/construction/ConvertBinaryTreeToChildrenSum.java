package com.hs.construction;

import com.hs.tree.Node;

// sum up the left and right child value
// if child sum is less than parent then update the child value to root data
// do left and right recursion
// while coming back sum up the child value and replace to the parent value.
public class ConvertBinaryTreeToChildrenSum {
	public void convertTree(Node root) {
		if (root == null)
			return;

		int child = 0;

		if (root.left != null) {
			child += root.left.data;
		}
		if (root.right != null) {
			child += root.right.data;
		}

		if (child < root.data) {
			if (root.left != null)
				root.left.data = root.data;
			else if (root.right != null)
				root.right.data = root.data;
		}

		convertTree(root.left);
		convertTree(root.right);

		int total = 0;
		if (root.left != null)
			total += root.left.data;

		if (root.right != null)
			total += root.right.data;

		if (root.left != null || root.right != null)
			root.data = total;
	}

	private void printInorder(Node node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	public static void main(String args[]) {
		ConvertBinaryTreeToChildrenSum tree = new ConvertBinaryTreeToChildrenSum();
		Node root = new Node(50);
		root.left = new Node(7);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(1);
		root.right.right = new Node(30);

		System.out.println("Inorder traversal before conversion is :");
		tree.printInorder(root);

		tree.convertTree(root);
		System.out.println("");

		System.out.println("Inorder traversal after conversion is :");
		tree.printInorder(root);
	}
}