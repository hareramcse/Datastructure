package com.hs.bst;

public class CheckBinaryTreeIsBinarySearchTree {

	// best way (O(n)
	public boolean isBinaryTreeBST(Node root) {
		return isBST3rdWay(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isBST3rdWay(Node root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		} else {
			if (root.data > minValue && root.data < maxValue && isBST3rdWay(root.left, minValue, root.data)
					&& isBST3rdWay(root.right, root.data, maxValue)) {
				return true;
			} else {
				return false;
			}
		}
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