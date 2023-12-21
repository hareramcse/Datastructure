package com.hs.bst;

import java.util.LinkedList;
import java.util.Queue;

import com.hs.tree.Node;

public class BinarySearchTree {
	public void preOrderTraversal(Node root) {
		if (root == null)
			return;

		System.out.println(root.data);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	public void inOrderTraversal(Node root) {
		if (root == null)
			return;

		inOrderTraversal(root.left);
		System.out.println(root.data);
		inOrderTraversal(root.right);
	}

	public void postOrderTraversal(Node root) {
		if (root == null)
			return;

		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.println(root.data);
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
		if (root == null)
			return 0;

		int leftHeight = findHeightOfTree(root.left);
		int rightHeight = findHeightOfTree(root.right);
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public int findMaxInBST(Node root) {
		Node temp = root;
		if (temp == null)
			return -1;

		while (temp.right != null) {
			temp = temp.right;
		}
		return temp.data;
	}

	public Node insert(Node root, int data) {
		if (root == null) {
			root = new Node(data);
		} else {
			if (data < root.data) {
				root.left = insert(root.left, data);
			} else {
				root.right = insert(root.right, data);
			}
		}
		return root;
	}

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

	public boolean search(Node root, int data) {
		if (root == null)
			return false;

		if (root.data == data)
			return true;

		if (data < root.data)
			return search(root.left, data);
		else
			return search(root.right, data);
	}

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(7);

		BinarySearchTree obj = new BinarySearchTree();
		obj.preOrderTraversal(root);
	}
}