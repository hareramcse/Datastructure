package com.hs.bst;

import com.hs.tree.Node;

public class KthSmallestNodeInBST {
	public int kthSmallest(Node root, int k) {
		int[] kthSmallest = new int[1];
		kthSmallest[0] = k;
		Node res = findKthSmallest(root, kthSmallest);
		return res.data;
	}

	private Node findKthSmallest(Node root, int[] k) {
		if (root == null)
			return null;

		Node left = findKthSmallest(root.left, k);
		if (left != null) {
			return left;
		}

		k[0]--;
		if (k[0] == 0) {
			return root;
		}

		return findKthSmallest(root.right, k);
	}

	public static void main(String[] args) {
		KthSmallestNodeInBST tree = new KthSmallestNodeInBST();

		Node root = new Node(50);
		root.left = new Node(30);
		root.left.left = new Node(20);
		root.left.right = new Node(40);
		root.right = new Node(70);
		root.right.left = new Node(60);
		root.right.right = new Node(80);

		int kthSmallest = tree.kthSmallest(root, 4);
		System.out.println("4th smallest node is: " + kthSmallest);
	}
}