package com.hs.bst;

import com.hs.tree.Node;

public class ConvertSortedArrayToBST {

	public Node arrayToBST(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		return convertTOBST(arr, low, high);
	}

	private Node convertTOBST(int[] arr, int low, int high) {
		// Base case
		if (low > high)
			return null;

		// Get the middle element and make it root
		int mid = low + (high - low) / 2;
		Node node = new Node(arr[mid]);
		node.left = convertTOBST(arr, low, mid - 1);
		node.right = convertTOBST(arr, mid + 1, high);
		return node;
	}

	private void inorder(Node root) {
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static void main(String[] args) {
		ConvertSortedArrayToBST tree = new ConvertSortedArrayToBST();
		int[] arr = { 20, 40, 50, 70, 80, 100, 120, 300 };

		Node root = tree.arrayToBST(arr);
		System.out.println("The Inorder traversal of the merged BST is: ");
		tree.inorder(root);
	}
}