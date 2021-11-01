package com.hs.construction.hard;

import java.util.HashMap;
import java.util.Map;

// O(n)
/*In a Preorder sequence, the leftmost element is the root of the tree. 
 * So we know ‘A’ is the root for given sequences. By searching ‘A’ in the Inorder sequence, 
 * we can find out all elements on the left side of ‘A’ is in the left subtree, and elements 
 * on right in the right subtree. */
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
		
		// make this node as root node
		Node root = new Node(curr);

		// If this node has no children then return
		if (inStrt == inEnd) {
			return root;
		}

		// Else find the index of this node in Inorder traversal
		int inIndex = map.get(curr);

		// Using index in Inorder traversal, construct left and right subtrees
		root.left = buildTree(in, pre, inStrt, inIndex - 1);
		root.right = buildTree(in, pre, inIndex + 1, inEnd);
		return root;
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