package com.hs.construction;

/*
 * If we observe carefully we can see that if parent node is at index i in the array 
 * then the left child of that node is at index (2*i + 1) and right child is at 
 * index (2*i + 2) in the array. using this concept, we can easily insert the left and 
 * right nodes by choosing its parent node. We will insert the first element present in 
 * the array as the root node at level 0 in the tree and start traversing the array and 
 * for every node i we will insert its both childs left and right in the tree. */
// O(n)
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
