package com.hs.misc;

import com.hs.tree.Node;

public class SameTree {
	public boolean isSameTree(Node a, Node b) {
		if (a == null && b == null)
			return true;

		if (a == null || b == null)
			return false;

		if (a.data != b.data)
			return false;

		boolean left = isSameTree(a.left, b.left);
		boolean right = isSameTree(a.right, b.right);

		return left && right;
	}
}
