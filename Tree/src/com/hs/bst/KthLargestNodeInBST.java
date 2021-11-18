package com.hs.bst;

public class KthLargestNodeInBST {

	private int count = 0;

	private void kthLargest(Node node, int k) {
		// Base cases, the second condition is important to
		// avoid unnecessary recursive calls
		if (node == null)
			return;

		// Follow reverse inorder traversal so that the
		// largest element is visited first
		this.kthLargest(node.right, k);

		// Increment count of visited nodes
		count++;

		// If c becomes k now, then this is the k'th largest
		if (count == k) {
			System.out.println(k + "th largest element is " + node.data);
			return;
		}

		// Recur for left subtree
		this.kthLargest(node.left, k);
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