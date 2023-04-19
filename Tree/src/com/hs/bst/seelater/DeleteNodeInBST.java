package com.hs.bst.seelater;

import com.hs.tree.Node;

public class DeleteNodeInBST {
	public Node delete(Node root, int data) {
		// tree is empty
		if (root == null) {
			return null;
		} else if (data < root.data) {
			root.left = delete(root.left, data);
		} else if (data > root.data) {
			root.right = delete(root.right, data);
		} else {
			// if data is equal to node data, means this node we need to delete
			// case 1, node with no child
			if (root.left == null && root.right == null) {
				root = null;
			}
			// case 2, node with only one child
			else if (root.left == null) {
				root = root.right;
			} else if (root.right == null) {
				root = root.left;
			}
			// case 3, node with 2 child
			else {
				Node temp = findMinInBST(root.right);
				root.data = temp.data;
				root.right = delete(root.right, temp.data);
			}
		}
		return root;
	}

	// min value comes left to root so we traverse left to root
	private Node findMinInBST(Node root) {
		Node temp = root;
		if (temp == null) {
			return temp;
		}
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp;
	}
}
