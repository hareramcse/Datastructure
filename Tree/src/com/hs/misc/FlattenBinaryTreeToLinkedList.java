package com.hs.misc;

import com.hs.tree.Node;

public class FlattenBinaryTreeToLinkedList {
	Node prev = null;

	public void flatten(Node root) {
		if (root == null)
			return;

		flatten(root.right);
		flatten(root.left);

		root.right = prev;
		root.left = null;
		prev = root;
	}
}
