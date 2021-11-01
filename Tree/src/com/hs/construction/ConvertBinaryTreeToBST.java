package com.hs.construction;

import java.util.Arrays;

public class ConvertBinaryTreeToBST {

	private static int index;

	// A helper function that stores inorder traversal of a tree rooted with node
	private static void storeInorder(Node node, int inorder[]) {
		// Base Case
		if (node == null)
			return;

		// first store the left subtree
		storeInorder(node.left, inorder);

		// Copy the root's data
		inorder[index] = node.data;
		index++; // increase index for next entry

		// finally store the right subtree
		storeInorder(node.right, inorder);
	}

	// A helper function to count nodes in a Binary Tree
	private static int countNodes(Node root) {
		if (root == null)
			return 0;
		return countNodes(root.left) + countNodes(root.right) + 1;
	}

	/*
	 * A helper function that copies contents of arr[] to Binary Tree. This function
	 * basically does Inorder traversal of Binary Tree and one by one copy arr[]
	 * elements to Binary Tree nodes
	 */
	private static void arrayToBST(int[] arr, Node root) {
		// Base Case
		if (root == null)
			return;

		/* first update the left subtree */
		arrayToBST(arr, root.left);

		/* Now update root's data and increment index */
		root.data = arr[index];
		index++;

		/* finally update the right subtree */
		arrayToBST(arr, root.right);
	}

	// This function converts a given Binary Tree to BST
	private static void binaryTreeToBST(Node root) {
		// base case: tree is empty
		if (root == null)
			return;

		/*
		 * Count the number of nodes in Binary Tree so that we know the size of
		 * temporary array to be created
		 */
		int n = countNodes(root);

		// Create a temp array arr[] and store inorder traversal of tree in arr[]
		int arr[] = new int[n];

		storeInorder(root, arr);

		// Sort the array using library function for quick sort
		Arrays.sort(arr);

		// Copy array elements back to Binary Tree
		index = 0;
		arrayToBST(arr, root);
	}

	/* Utility function to print inorder traversal of Binary Tree */
	private static void printInorder(Node node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	/* Driver function to test above functions */
	public static void main(String args[]) {
		Node root = new Node(10);
		root.left = new Node(30);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.right.right = new Node(5);

		// convert Binary Tree to BST
		binaryTreeToBST(root);

		System.out.println("Following is Inorder Traversal of the converted BST: ");
		printInorder(root);

	}

}