package com.hs.checkandprint;

import java.util.LinkedList;
import java.util.Queue;

public class CheckSymmetricBinaryTree {
	Node root;

	static class Node {
		int val;
		Node left, right;

		Node(int v) {
			val = v;
			left = null;
			right = null;
		}
	}

	/* constructor to initialise the root */
	CheckSymmetricBinaryTree(Node r) {
		root = r;
	}

	/* empty constructor */
	CheckSymmetricBinaryTree() {
	}

	/* function to check if the tree is Symmetric */
	public boolean isSymmetric(Node root) {
		/* This allows adding null elements to the queue */
		Queue<Node> q = new LinkedList<Node>();

		/* Initially, add left and right nodes of root */
		q.add(root.left);
		q.add(root.right);

		while (!q.isEmpty()) {
			/*
			 * remove the front 2 nodes to check for equality
			 */
			Node tempLeft = q.remove();
			Node tempRight = q.remove();

			/*
			 * if both are null, continue and chcek for further elements
			 */
			if (tempLeft == null && tempRight == null)
				continue;

			/* if only one is null---inequality, retun false */
			if ((tempLeft == null && tempRight != null) || (tempLeft != null && tempRight == null))
				return false;

			/*
			 * if both left and right nodes exist, but have different values-- inequality,
			 * return false
			 */
			if (tempLeft.val != tempRight.val)
				return false;

			/*
			 * Note the order of insertion of elements to the queue : 1) left child of left
			 * subtree 2) right child of right subtree 3) right child of left subtree 4)
			 * left child of right subtree
			 */
			q.add(tempLeft.left);
			q.add(tempRight.right);
			q.add(tempLeft.right);
			q.add(tempRight.left);
		}

		/* if the flow reaches here, return true */
		return true;
	}

	/* driver function to test other functions */
	public static void main(String[] args) {
		Node n = new Node(1);
		CheckSymmetricBinaryTree bt = new CheckSymmetricBinaryTree(n);
		bt.root.left = new Node(2);
		bt.root.right = new Node(2);
		bt.root.left.left = new Node(3);
		bt.root.left.right = new Node(4);
		bt.root.right.left = new Node(4);
		bt.root.right.right = new Node(3);

		if (bt.isSymmetric(bt.root))
			System.out.println("The given tree is Symmetric");
		else
			System.out.println("The given tree is not Symmetric");
	}
}
