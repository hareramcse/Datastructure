package com.hs.construction;

import com.hs.tree.Node;

public class ConstructTreeFromInorderData {
	public Node buildTree(Node root, int start, int end, int inorder[]) {
		if (start > end)
			return null;

		// Find index of the maximum element from Binary Tree
		int i = max(inorder, start, end);

		// Pick the maximum value and make it root
		root = new Node(inorder[i]);

		// If this is the only element in inorder[start..end], then return it
		if (start == end)
			return root;

		// Using index in Inorder traversal, construct left and right subtrees
		root.left = buildTree(root.left, start, i - 1, inorder);
		root.right = buildTree(root.right, i + 1, end, inorder);

		return root;
	}

	// Function to find index of the maximum value in arr[start...end]
	private int max(int arr[], int strt, int end) {
		int i, max = arr[strt], maxind = strt;
		for (i = strt + 1; i <= end; i++) {
			if (arr[i] > max) {
				max = arr[i];
				maxind = i;
			}
		}
		return maxind;
	}

	private void printInorder(Node node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	public static void main(String args[]) {
		ConstructTreeFromInorderData tree = new ConstructTreeFromInorderData();

		int inorder[] = new int[] { 5, 10, 40, 30, 28 };
		int len = inorder.length;
		Node root = tree.buildTree(null, 0, len - 1, inorder);

		System.out.println("Inorder traversal of the constructed tree is ");
		tree.printInorder(root);
	}
}