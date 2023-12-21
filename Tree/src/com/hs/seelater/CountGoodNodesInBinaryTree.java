package com.hs.seelater;

import com.hs.tree.Node;

public class CountGoodNodesInBinaryTree {
	public int goodNodes(Node root) {
		return helper(root, -99999);
	}

	public int helper(Node root, int max) {
		if (root == null)
			return 0;

		int res = root.data >= max ? 1 : 0;

		res += helper(root.left, Math.max(root.data, max));
		res += helper(root.right, Math.max(root.data, max));

		return res;
	}
}
