package com.hs.checkandprint;

import com.hs.tree.Node;

// balanced binary tree is a tree which left height and right height difference is not more than 1
public class CheckForBalancedBinaryTree {
	public boolean isBalanced(Node root) {
		return height(root) != -1;
	}

	private int height(Node root) {
		if (root == null)
			return 0;

		int lHeight = height(root.left);
		if (lHeight == -1)
			return -1;

		int rHeight = height(root.right);
		if (rHeight == -1)
			return -1;

		if (Math.abs(lHeight - rHeight) > 1)
			return -1;

		return 1 + Math.max(lHeight, rHeight);
	}
}
