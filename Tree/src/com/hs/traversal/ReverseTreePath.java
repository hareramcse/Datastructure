package com.hs.traversal;

import java.util.HashMap;
import java.util.Map;

class ReverseTreePath {

	// class for int values
	static class INT {
		int data;
	};

	// 'data' is input. We need to reverse path from
	// root to data.
	// 'level' is current level.
	// 'temp' that stores path nodes.
	// 'nextpos' used to pick next item for reversing.
	static Node reverseTreePathUtil(Node root, int data, Map<Integer, Integer> temp, int level, INT nextpos) {
		// return null if root null
		if (root == null)
			return null;

		// Final condition
		// if the node is found then
		if (data == root.data) {

			// store the value in it's level
			temp.put(level, root.data);

			// change the root value with the current
			// next element of the map
			root.data = temp.get(nextpos.data);

			// increment in k for the next element
			nextpos.data++;
			return root;
		}

		// store the data in perticular level
		temp.put(level, root.data);

		// We go to right only when left does not
		// contain given data. This way we make sure
		// that correct path node is stored in temp[]
		Node left, right = null;
		left = reverseTreePathUtil(root.left, data, temp, level + 1, nextpos);
		if (left == null)
			right = reverseTreePathUtil(root.right, data, temp, level + 1, nextpos);

		// If current node is part of the path,
		// then do reversing.
		if (left != null || right != null) {
			root.data = temp.get(nextpos.data);
			nextpos.data++;
			return (left != null ? left : right);
		}

		// return null if not element found
		return null;
	}

	// Reverse Tree path
	static void reverseTreePath(Node root, int data) {
		// store per level data
		Map<Integer, Integer> temp = new HashMap<Integer, Integer>();

		// it is for replacing the data
		INT nextpos = new INT();
		nextpos.data = 0;

		// reverse tree path
		reverseTreePathUtil(root, data, temp, 0, nextpos);
	}

	// INORDER
	static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
	
	// Driver program to test above functions
	public static void main(String args[]) {
		// Let us create binary tree shown in above diagram
		Node root = new Node(7);
		root.left = new Node(6);
		root.right = new Node(5);
		root.left.left = new Node(4);
		root.left.right = new Node(3);
		root.right.left = new Node(2);
		root.right.right = new Node(1);

		/*
		 * 7 / \ 6 5 / \ / \ 4 3 2 1
		 */

		int data = 4;

		// Reverse Tree Path
		reverseTreePath(root, data);

		// Traverse inorder
		inorder(root);
	}
}
