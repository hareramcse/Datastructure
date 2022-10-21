package com.hs.bst;

import com.hs.tree.Node;

class NodeValue {
	public int minNode, maxNode, maxSize;

	NodeValue(int minNode, int maxNode, int maxSize) {
		this.minNode = minNode;
		this.maxNode = maxNode;
		this.maxSize = maxSize;
	}
}

public class LargestBSTInBinaryTree {
	public int largestBSTSubtree(Node root) {
		return largestBSTSubtreeHelper(root).maxSize;
	}

	private NodeValue largestBSTSubtreeHelper(Node root) {
		// An empty tree is a BST of size 0.
		if (root == null) {
			return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		}

		// Get values from left and right subtree of current tree.
		NodeValue left = largestBSTSubtreeHelper(root.left);
		NodeValue right = largestBSTSubtreeHelper(root.right);

		// Current node is greater than max in left AND smaller than min in right
		// it is a BST.
		if (left.maxNode < root.data && root.data < right.minNode) {
			// It is a BST.
			return new NodeValue(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode),
					left.maxSize + right.maxSize + 1);
		}

		// Otherwise, return [-inf, inf] so that parent can't be valid BST
		return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
	}

}
