package com.hs.bst;

public class KthLargestNodeInBST {

	public class count {
		int c = 0;
	}

	// utility function to find kth largest no in a given tree
	void kthLargestUtil(Node node, int k, count C) {
		// Base cases, the second condition is important to
		// avoid unnecessary recursive calls
		if (node == null || C.c >= k)
			return;

		// Follow reverse inorder traversal so that the
		// largest element is visited first
		this.kthLargestUtil(node.right, k, C);

		// Increment count of visited nodes
		C.c++;

		// If c becomes k now, then this is the k'th largest
		if (C.c == k) {
			System.out.println(k + "th largest element is " + node.data);
			return;
		}

		// Recur for left subtree
		this.kthLargestUtil(node.left, k, C);
	}

	void kthLargest(Node root, int k) {
		count c = new count(); // object of class count
		this.kthLargestUtil(root, k, c);
	}

	public static void main(String[] args) {
		KthLargestNodeInBST tree = new KthLargestNodeInBST();

		Node root = new Node(50);
		root.left = new Node(30);
		root.left.left = new Node(20);
		root.left.right = new Node(40);
		root.right = new Node(70);
		root.right.left = new Node(60);
		root.right.right = new Node(80);

		tree.kthLargest(root, 4);
	}
}