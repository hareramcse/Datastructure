package com.hs.construction;

import java.util.HashMap;
import java.util.Map;

class ConstrcutTreeFromInorderAndPreOrder {
	int preIndex = 0;

	/*
	 * Recursive function to construct binary of size len from Inorder traversal
	 * in[] and Preorder traversal pre[]. Initial values of inStrt and inEnd should
	 * be 0 and len -1. The function doesn't do any error checking for cases where
	 * inorder and preorder do not form a tree
	 */
	public Node buildTree(char in[], char pre[], int inStrt, int inEnd, Map<Character, Integer> map) {

		if (inStrt > inEnd)
			return null;

		/*
		 * Pick current node from Preorder traversal using preIndex and increment
		 * preIndex
		 */
		char curr = (char) pre[preIndex++];
		Node tNode = new Node(curr);

		/* If this node has no children then return */
		if (inStrt == inEnd)
			return tNode;

		/* Else find the index of this node in Inorder traversal */
		int inIndex = map.get(curr);

		/*
		 * Using index in Inorder traversal, construct left and right subtrees
		 */
		tNode.left = buildTree(in, pre, inStrt, inIndex - 1, map);
		tNode.right = buildTree(in, pre, inIndex + 1, inEnd, map);

		return tNode;
	}

	// This function mainly creates an unordered_map, then calls buildTree()
	Node buldTreeWrap(char in[], char pre[], int len) {
		// Store indexes of all items so that we we can quickly find later
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++)
			map.put(in[i], i);

		return buildTree(in, pre, 0, len - 1, map);
	}

	void printInorder(Node root) {
		if (root == null)
			return;

		/* first recur on left child */
		printInorder(root.left);

		/* then print the data of node */
		System.out.print(root.ch + " ");

		/* now recur on right child */
		printInorder(root.right);
	}

	public static void main(String args[]) {
		ConstrcutTreeFromInorderAndPreOrder tree = new ConstrcutTreeFromInorderAndPreOrder();
		char in[] = { 'D', 'B', 'E', 'A', 'F', 'C' };
		char pre[] = { 'A', 'B', 'D', 'E', 'C', 'F' };
		int len = in.length;
		Node root = tree.buldTreeWrap(in, pre, len);

		// building the tree by printing inorder traversal
		System.out.println("Inorder traversal of constructed tree is : ");
		tree.printInorder(root);
	}
}