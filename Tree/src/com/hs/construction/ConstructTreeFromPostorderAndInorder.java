package com.hs.construction;

import java.util.HashMap;

public class ConstructTreeFromPostorderAndInorder {
	private static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	private static int index;

	private static Node buildUtil(int in[], int post[], int inStrt, int inEnd) {

		// Base case
		if (inStrt > inEnd)
			return null;

		// Pick current node from Postorder traversal using postIndex and decrement
		// postIndex
		int curr = post[index];
		Node node = new Node(curr);
		index--;

		// If this node has no children then return
		if (inStrt == inEnd)
			return node;

		// Else find the index of this node in Inorder traversal
		int iIndex = map.get(curr);

		// Using index in Inorder traversal, con left and right subtrees
		node.right = buildUtil(in, post, iIndex + 1, inEnd);
		node.left = buildUtil(in, post, inStrt, iIndex - 1);
		return node;
	}

	private static Node buildTree(int in[], int post[], int len) {

		// Store indexes of all items so that we can quickly find later
		for (int i = 0; i < len; i++)
			map.put(in[i], i);

		index = len - 1; // Index in postorder
		return buildUtil(in, post, 0, len - 1);
	}

	/* This function is here just to test */
	private static void preOrder(Node node) {
		if (node == null)
			return;
		System.out.printf("%d ", node.data);
		preOrder(node.left);
		preOrder(node.right);
	}

	// Driver code
	public static void main(String[] args) {
		int in[] = { 4, 8, 2, 5, 1, 6, 3, 7 };
		int post[] = { 8, 4, 5, 2, 6, 7, 3, 1 };
		int n = in.length;
		Node root = buildTree(in, post, n);
		System.out.print("Preorder of the constructed tree : \n");
		preOrder(root);
	}

}