package com.hs.construction;

public class ConstructCompleteBinaryTreeFromGivenArrayInLevelOrder {

	private Node insertLevelOrder(int[] arr, Node root, int i) {
		// Base case for recursion
		if (i < arr.length) {
			Node temp = new Node(arr[i]);
			root = temp;

			// insert left child
			root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

			// insert right child
			root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
		}
		return root;
	}

	// Function to print tree nodes in InOrder fashion
	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	// Driver program to test above function
	public static void main(String args[]) {
		ConstructCompleteBinaryTreeFromGivenArrayInLevelOrder t2 = new ConstructCompleteBinaryTreeFromGivenArrayInLevelOrder();
		int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
		Node root = t2.insertLevelOrder(arr, null, 0);
		t2.inOrder(root);
	}
}
