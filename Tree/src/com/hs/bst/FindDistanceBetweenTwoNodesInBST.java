package com.hs.bst;

public class FindDistanceBetweenTwoNodesInBST {
	private int findDistanceBetweenTwoNodes(Node root, int a, int b) {
		int temp = 0;
		if (a > b) {
			temp = a;
			a = b;
			b = temp;
		}
		return distanceBetweenTwoNodes(root, a, b);
	}

	private int distanceBetweenTwoNodes(Node root, int a, int b) {
		if (root == null)
			return 0;

		// Both keys lies in left
		if (root.data > a && root.data > b)
			return distanceBetweenTwoNodes(root.left, a, b);

		// Both keys lies in right
		if (root.data < a && root.data < b)
			return distanceBetweenTwoNodes(root.right, a, b);

		// Lies in opposite directions (Root is LCA of two nodes)
		if (root.data >= a && root.data <= b)
			return distanceFromRoot(root, a) + distanceFromRoot(root, b);

		return 0;
	}

	private int distanceFromRoot(Node root, int x) {
		if (root.data == x)
			return 0;
		else if (root.data > x)
			return 1 + distanceFromRoot(root.left, x);
		return 1 + distanceFromRoot(root.right, x);
	}

	public static void main(String[] args) {
		FindDistanceBetweenTwoNodesInBST tree = new FindDistanceBetweenTwoNodesInBST();
		Node root = new Node(50);
		root.left = new Node(30);
		root.left.left = new Node(20);
		root.left.right = new Node(40);
		root.right = new Node(70);
		root.right.left = new Node(60);
		root.right.right = new Node(80);
		System.out.println(tree.findDistanceBetweenTwoNodes(root, 30, 80));
	}
}