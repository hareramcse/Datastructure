package com.hs.bst;

import com.hs.tree.Node;

//Time Complexity: O(n) where n = number of nodes
//Space Complexity: O(h) where h = height of tree.
public class RecoverBinarySearchTree {
	private Node first;
	private Node second;
	private Node prev;

	public void recoverTree(Node root) {
		first = second = prev = null;
		inorder(root);

		// Swap the misplaced nodes
		int temp = first.data;
		first.data = second.data;
		second.data = temp;
	}

	private void inorder(Node root) {
		if (root == null)
			return;

		inorder(root.left);

		if (prev != null && root.data < prev.data) {
			if (first == null) {
				first = prev;
			}

			// Always update second
			second = root;
		}

		prev = root;
		inorder(root.right);
	}
}
