package com.hs.construction;

import com.hs.tree.Node;

// O(n^2), Worst case complexity is for a skewed tree such that nodes are in decreasing order from root to leaf.
public class ConvertBinaryTreeToChildrenSum {

	// Function to convert a given binary tree to satisfy the children-sum property
	public void convertTree(Node root) {
		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			return;
		}

		convertTree(root.left);
		convertTree(root.right);

		// calculate the difference between the root and its children
		int diff = root.data - findChildrenSum(root);

		// if the root is less than the children's sum, increment it by `abs(diff)`
		if (diff < 0) {
			root.data += Math.abs(diff);
		}

		// if the root is greater than the children's sum, fix the root by
		// either updating the left or right subtree by `diff`
		else if (diff > 0) {
			Node subtree = root.left != null ? root.left : root.right;
			subtree.data += diff;
			convertTree(subtree);
		}
	}

	private int findChildrenSum(Node node) {
		int left = node.left != null ? node.left.data : 0;
		int right = node.right != null ? node.right.data : 0;

		return left + right;
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