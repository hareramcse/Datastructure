package com.hs.misc;

import com.hs.tree.Node;

public class BinaryTreeMaximumPathSum {
	public int maxPathSum(Node root) {
		int[] maxValue = new int[1];
		maxValue[0] = Integer.MIN_VALUE;
		maxPath(root, maxValue);
		return maxValue[0];
	}

	private int maxPath(Node root, int[] maxValue) {
		if (root == null)
			return 0;

		int left = Math.max(0, maxPath(root.left, maxValue));
		int right = Math.max(0, maxPath(root.right, maxValue));
		maxValue[0] = Math.max(maxValue[0], left + right + root.data);
		return root.data + Math.max(left, right);
	}
}
