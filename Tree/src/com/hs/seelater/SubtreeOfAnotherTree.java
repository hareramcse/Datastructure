package com.hs.seelater;

import com.hs.tree.Node;

public class SubtreeOfAnotherTree {
	public boolean isSubtree(Node root, Node subRoot) {
		if (root == null && subRoot == null)
			return true;

		if (root == null || subRoot == null)
			return false;

		if (isSameTree(root, subRoot))
			return true;

		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	private boolean isSameTree(Node root, Node subRoot) {
		if (root == null && subRoot == null)
			return true;

		if (root == null || subRoot == null)
			return false;

		if (root.data == subRoot.data)
			return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);

		return false;
	}
}
