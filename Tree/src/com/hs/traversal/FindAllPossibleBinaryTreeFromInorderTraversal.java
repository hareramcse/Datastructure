package com.hs.traversal;

import java.util.Vector;

public class FindAllPossibleBinaryTreeFromInorderTraversal {

	// A utility function to do preorder traversal of BST
	void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	// Function for constructing all possible trees with
	// given inorder traversal stored in an array from
	// arr[start] to arr[end]. This function returns a
	// vector of trees.
	Vector<Node> getTrees(int arr[], int start, int end) {

		// List to store all possible trees
		Vector<Node> trees = new Vector<Node>();

		/*
		 * if start > end then subtree will be empty so returning NULL in the list
		 */
		if (start > end) {
			trees.add(null);
			return trees;
		}

		/*
		 * Iterating through all values from start to end for constructing left and
		 * right subtree recursively
		 */
		for (int i = start; i <= end; i++) {
			/* Constructing left subtree */
			Vector<Node> ltrees = getTrees(arr, start, i - 1);

			/* Constructing right subtree */
			Vector<Node> rtrees = getTrees(arr, i + 1, end);

			/*
			 * Now looping through all left and right subtrees and connecting them to ith
			 * root below
			 */
			for (int j = 0; j < ltrees.size(); j++) {
				for (int k = 0; k < rtrees.size(); k++) {

					// Making arr[i] as root
					Node node = new Node(arr[i]);

					// Connecting left subtree
					node.left = ltrees.get(j);

					// Connecting right subtree
					node.right = rtrees.get(k);

					// Adding this tree to list
					trees.add(node);
				}
			}
		}
		return trees;
	}

	public static void main(String args[]) {
		int in[] = { 4, 5, 7 };
		int n = in.length;
		FindAllPossibleBinaryTreeFromInorderTraversal tree = new FindAllPossibleBinaryTreeFromInorderTraversal();
		Vector<Node> trees = tree.getTrees(in, 0, n - 1);
		System.out.println("Preorder traversal of different " + " binary trees are:");
		for (int i = 0; i < trees.size(); i++) {
			tree.preOrder(trees.get(i));
			System.out.println("");
		}
	}
}
