package com.hs.bst;

import com.hs.tree.Node;

class NodeInfo {
	public int min, max, size;
	public boolean isBST;

	NodeInfo() {

	}

	NodeInfo(int min, int max, boolean isBST, int size) {
		this.min = min;
		this.max = max;
		this.size = size;
		this.isBST = isBST;
	}
}

public class LargestBSTInBinaryTree {
	public int largestBSTSubtree(Node root) {
		return findLargestBst(root).size;
	}

	private NodeInfo findLargestBst(Node root) {
		if (root == null) {
			return new NodeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0);
		}

		NodeInfo left = findLargestBst(root.left);
		NodeInfo right = findLargestBst(root.right);

		NodeInfo current = new NodeInfo();
		current.min = Math.min(root.data, left.min);
		current.max = Math.max(root.data, right.max);
		current.isBST = left.isBST && right.isBST && root.data > left.max && root.data < right.min;

		if (current.isBST) {
			current.size = 1 + left.size + right.size;
		} else {
			current.size = Math.max(left.size, right.size);
		}
		return current;
	}
}