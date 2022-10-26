package com.hs.checkandprint;

import java.io.IOException;

import com.hs.tree.Node;

/* We need to check whether each non-leaf node (parent) satisfies the heap property. For 
 * this, we check whether each parent (at index i) is smaller than its children 
 * (at indices 2*i+1 and 2*i+2, if the parent has two children). If only one child,
 * we only check the parent against index 2*i+1.
 * */
public class CheckBinaryTreeIsMinHeap {

	public boolean isHeap(Node root) {
		int i = 0;
		int n = size(root);
		return isHeap(root, i, n);
	}

	private int size(Node root) {
		if (root == null)
			return 0;

		return 1 + size(root.left) + size(root.right);
	}

	// Function to check if a given binary tree is a complete binary tree
	// and each node has a higher value than its parent
	private boolean isHeap(Node root, int i, int n) {
		if (root == null)
			return true;

		// not complete binary tree: out of valid index range
		if (i >= n)
			return false;

		// current node has a higher value than its left or right child
		if ((root.left != null && root.left.data <= root.data)
				|| (root.right != null && root.right.data <= root.data)) {
			return false;
		}

		// check for left and right subtree
		return isHeap(root.left, 2 * i + 1, n) && isHeap(root.right, 2 * i + 2, n);
	}

	public static void main(String[] args) throws IOException {
		CheckBinaryTreeIsMinHeap tree = new CheckBinaryTreeIsMinHeap();
		Node root = new Node(2);
		root.left = new Node(3);
		root.right = new Node(4);
		root.left.left = new Node(5);
		root.left.right = new Node(6);
		root.right.left = new Node(8);
		root.right.right = new Node(10);

		if (tree.isHeap(root)) {
			System.out.print("The given binary tree is a min-heap");
		} else {
			System.out.print("The given binary tree is not a min-heap");
		}
	}
}