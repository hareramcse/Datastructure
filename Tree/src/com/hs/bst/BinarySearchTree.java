package com.hs.bst;

import java.util.LinkedList;
import java.util.Queue;
import com.hs.tree.Node;

public class BinarySearchTree {

	public void preOrderTraversal(Node root) {
		if (root == null) {
			return;
		} else {
			System.out.println(root.data);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	public void inOrderTraversal(Node root) {
		if (root == null) {
			return;
		} else {
			inOrderTraversal(root.left);
			System.out.println(root.data);
			inOrderTraversal(root.right);
		}
	}

	public void postOrderTraversal(Node root) {
		if (root == null) {
			return;
		} else {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.println(root.data);
		}
	}

	public void levelOrderTraversal(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.println(temp.data);
			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}
	}

	public int findHeightOfTree(Node root) {
		if (root == null) {
			return 0;
		} else {
			int leftHeight = findHeightOfTree(root.left);
			int rightHeight = findHeightOfTree(root.right);
			return 1 + Math.max(leftHeight, rightHeight);
		}
	}

	public int findMaxInBST(Node root) {
		Node temp = root;
		if (temp == null) {
			return -1;
		}
		while (temp.right != null) {
			temp = temp.right;
		}
		return temp.data;
	}
}