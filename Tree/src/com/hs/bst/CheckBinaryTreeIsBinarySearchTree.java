package com.hs.bst;

import com.hs.tree.Node;

public class CheckBinaryTreeIsBinarySearchTree {

	public boolean isBinaryTreeBST(Node root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Node root, int minValue, int maxValue) {
		if (root == null)
			return true;

		if (root.data < minValue || root.data > maxValue)
			return false;

		return isBST(root.left, minValue, root.data) && isBST(root.right, root.data, maxValue);
	}

	public static void main(String[] args) {
		CheckBinaryTreeIsBinarySearchTree bst = new CheckBinaryTreeIsBinarySearchTree();
		Node root = new Node(6);
		root.left = new Node(3);
		root.right = new Node(11);
		root.right.left = new Node(9);
		root.right.right = new Node(4);
		System.out.println(bst.isBinaryTreeBST(root));
	}
}