package com.hs.construction;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPostorderAndInorder {
	private Node buildUtil(int in[], int post[], int inStrt, int inEnd, int pIndex, Map<Integer, Integer> map) {
		// Base case
		if (inStrt > inEnd)
			return null;

		 // Pick current node from Postorder using postIndex and decrement postIndex
		int curr = post[pIndex];
		Node node = new Node(curr);
		pIndex--;

		// If this node has no children then return
		if (inStrt == inEnd)
			return node;

		//Else find the index of this node in Inorder traversal
		int iIndex = map.get(curr);

        // Using index in Inorder traversal, construct left and right subtress
		node.right = buildUtil(in, post, iIndex + 1, inEnd, pIndex, map);
		node.left = buildUtil(in, post, inStrt, iIndex - 1, pIndex, map);

		return node;
	}

	private Node buildTree(int in[], int post[], int len) {
		// Store indexes of all items so that we can quickly find later
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++)
			map.put(in[i], i);

		int index = len - 1; // Index in postorder
		return buildUtil(in, post, 0, len - 1, index, map);
	}

	/* This funtcion is here just to test */
	private void preOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void main(String[] args) {
		ConstructTreeFromPostorderAndInorder tree = new ConstructTreeFromPostorderAndInorder();
		int in[] = { 4, 8, 2, 5, 1, 6, 3, 7 };
		int post[] = { 8, 4, 5, 2, 6, 7, 3, 1 };
		int n = in.length;
		Node root = tree.buildTree(in, post, n);
		System.out.println("Preorder of the constructed tree : ");
		tree.preOrder(root);
	}
}