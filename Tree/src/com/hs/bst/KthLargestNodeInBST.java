package com.hs.bst;

// 230. Kth Smallest Element in a BST Leetcode
public class KthLargestNodeInBST {

	private int count = 0;

	private Node kthLargest(Node root, int k) {
		if (root == null)
			return null;

		// reverse inorder traversal so that largest element is visited first
		Node right = kthLargest(root.right, k);
		if(right != null) {
			return right;
		}

		// Increment count of visited nodes
		count++;

		// If count becomes k now, then this is the k'th largest
		if (count == k) {
			return root;
		}

		return kthLargest(root.left, k);
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

		Node kthNode = tree.kthLargest(root, 4);
		System.out.println("4th largest node is: " + kthNode.data);
	}
}