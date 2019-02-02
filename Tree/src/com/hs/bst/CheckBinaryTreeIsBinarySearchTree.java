package com.hs.bst;

public class CheckBinaryTreeIsBinarySearchTree {

	public static Node root;

	// best way (O(n)
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
		bst.root = new Node(6);
		bst.root.left = new Node(3);
		bst.root.right = new Node(11);
		bst.root.right.left = new Node(9);
		bst.root.right.right = new Node(4);

		System.out.println(bst.isBST3rdWay(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE));

	}
}
