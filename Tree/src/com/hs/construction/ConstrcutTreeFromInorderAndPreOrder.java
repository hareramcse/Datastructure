package com.hs.construction;

import java.util.HashMap;
import java.util.Map;
// O(n)
class ConstructTreeFromInorderAndPreOrder {

	private static Node root;

	// Store indexes of all items so that we can quickly find later
	private static Map<Character, Integer> map = new HashMap<>();
	private static int preIndex = 0;

	private static Node buildTree(char[] in, char[] pre, int inStrt, int inEnd) {

		if (inStrt > inEnd) {
			return null;
		}

		// Pick current node from Preorder using preIndex and increment preIndex
		char curr = pre[preIndex++];
		Node tNode = new Node(curr);

		// If this node has no children then return
		if (inStrt == inEnd) {
			return tNode;
		}

		// Else find the index of this node in Inorder traversal
		int inIndex = map.get(curr);

		// Using index in Inorder traversal, construct left and right subtress
		tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
		tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
		return tNode;
	}

	// This function mainly creates an unordered_map, then calls buildTree()
	private static Node buldTreeWrap(char[] in, char[] pre, int len) {
		for (int i = 0; i < len; i++) {
			map.put(in[i], i);
		}
		return buildTree(in, pre, 0, len - 1);
	}

	// This function is here just to test buildTree()
	private static void printInorder(Node node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	public static void main(String[] args) {
		char[] in = { 'D', 'B', 'E', 'A', 'F', 'C' };
		char[] pre = { 'A', 'B', 'D', 'E', 'C', 'F' };
		int len = in.length;

		root = buldTreeWrap(in, pre, len);

		System.out.println("Inorder traversal of the constructed tree is");
		printInorder(root);
	}

}