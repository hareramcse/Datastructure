package com.hs.bst;

import com.hs.tree.Node;

// Time Complexity: O(n) where n = number of nodes
// Space Complexity: O(h) where h = height of tree.
class NodeInfo {
	public int min, max, size;

	NodeInfo() {

	}

	NodeInfo(int min, int max, int size) {
		this.min = min;
		this.max = max;
		this.size = size;
	}
}

public class LargestBSTInBinaryTree {
	public int largestBSTSubtree(Node root) {
		return findLargestBst(root).size;
	}

	private NodeInfo findLargestBst(Node root) {
		if (root == null) {
			return new NodeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		}

		NodeInfo left = findLargestBst(root.left);
		NodeInfo right = findLargestBst(root.right);

		// if root is BST
		if (left.max < root.data && root.data < right.min) {
			return new NodeInfo(Math.min(root.data, left.min), Math.max(root.data, right.max),
					1 + left.size + right.size);
		}

		// if root is not BST
		return new NodeInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.max, right.min));
	}
}