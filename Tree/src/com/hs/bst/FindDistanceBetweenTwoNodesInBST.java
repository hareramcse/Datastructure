package com.hs.bst;

public class FindDistanceBetweenTwoNodesInBST {

	// This function returns distance of x from
	// root. This function assumes that x exists
	// in BST and BST is not NULL.
	static int distanceFromRoot(Node root, int x) {
		if (root.data == x)
			return 0;
		else if (root.data > x)
			return 1 + distanceFromRoot(root.left, x);
		return 1 + distanceFromRoot(root.right, x);
	}

	// Returns minimum distance beween a and b.
	// This function assumes that a and b exist
	// in BST.
	static int distanceBetween2(Node root, int a, int b) {
		if (root == null)
			return 0;

		// Both keys lie in left
		if (root.data > a && root.data > b)
			return distanceBetween2(root.left, a, b);

		// Both keys lie in right
		if (root.data < a && root.data < b) // same path
			return distanceBetween2(root.right, a, b);

		// Lie in opposite directions (Root is
		// LCA of two nodes)
		if (root.data >= a && root.data <= b)
			return distanceFromRoot(root, a) + distanceFromRoot(root, b);

		return 0;
	}

	// This function make sure that a is smaller
	// than b before making a call to findDistWrapper()
	static int findDistWrapper(Node root, int a, int b) {
		int temp = 0;
		if (a > b) {
			temp = a;
			a = b;
			b = temp;
		}
		return distanceBetween2(root, a, b);
	}

	public static void main(String[] args) {
		Node root = new Node(50);
		root.left = new Node(30);
		root.left.left = new Node(20);
		root.left.right = new Node(40);
		root.right = new Node(70);
		root.right.left = new Node(60);
		root.right.right = new Node(80);
		System.out.println(findDistWrapper(root, 30, 80));
	}
}
