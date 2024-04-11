package com.hs.bt;

import com.hs.tree.Node;

public class DistanceBetweenTwoNodes {
	public int findDistance(Node root, Node a, Node b) {
		Node lca = lowestCommonAncestor(root, a, b);

		int d1 = findLevel(lca, a, 0);
		int d2 = findLevel(lca, b, 0);

		return d1 + d2;
	}

	private Node lowestCommonAncestor(Node root, Node a, Node b) {
		if (root == null)
			return null;

		if (root == a || root == b)
			return root;

		Node left = lowestCommonAncestor(root.left, a, b);
		Node right = lowestCommonAncestor(root.right, a, b);

		if (left == null) {
			return right;
		} else if (right == null) {
			return left;
		} else { // both left and right are not null, we found our result
			return root;
		}
	}

	// Returns level of key k if it is present in tree, otherwise returns -1
	private int findLevel(Node root, Node a, int level) {
		if (root == null)
			return -1;
		
		if (root.data == a.data)
			return level;
		
		int left = findLevel(root.left, a, level + 1);
		if (left != -1) {
			return left;
		}
		return findLevel(root.right, a, level + 1);
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		DistanceBetweenTwoNodes tree = new DistanceBetweenTwoNodes();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		System.out.println("Dist(4, 5) = " + tree.findDistance(root, root.left.left, root.left.right));

		System.out.println("Dist(4, 6) = " + tree.findDistance(root, root.left.left, root.right.left));

		System.out.println("Dist(3, 4) = " + tree.findDistance(root, root.right, root.left.left));

		System.out.println("Dist(2, 4) = " + tree.findDistance(root, root.left, root.left.left));

		System.out.println("Dist(8, 5) = " + tree.findDistance(root, root.right.left.right, root.left.right));

	}
}