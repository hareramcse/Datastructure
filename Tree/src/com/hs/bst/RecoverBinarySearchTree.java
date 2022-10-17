package com.hs.bst;

import com.hs.tree.Node;

public class RecoverBinarySearchTree {
	private Node first;
	private Node prev;
	private Node middle;
	private Node last;

	private void inorder(Node root) {
		if (root == null)
			return;

		inorder(root.left);

		if (prev != null && (root.data < prev.data)) {

			// If this is first violation, mark these two nodes as
			// 'first' and 'middle'
			if (first == null) {
				first = prev;
				middle = root;
			}

			// If this is second violation, mark this node as last
			else
				last = root;
		}

		// Mark this node as previous
		prev = root;
		inorder(root.right);
	}

	public void recoverTree(Node root) {
		first = middle = last = null;
		prev = new Node(Integer.MIN_VALUE);
		inorder(root);
		if (first != null && last != null) {
			int t = first.data;
			first.data = last.data;
			last.data = t;
		} else if (first != null && middle != null) {
			int t = first.data;
			first.data = middle.data;
			middle.data = t;
		}
	}
}
