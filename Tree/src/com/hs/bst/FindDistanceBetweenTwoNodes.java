package com.hs.bst;

import com.hs.tree.Node;

public class FindDistanceBetweenTwoNodes {
	public int findDistanceBetweenTwoNodes(Node root, int a, int b) {
		Node lca = lca(root, a, b);
		int d1 = distanceFromRoot(lca, a);
		int d2 = distanceFromRoot(lca, b);
		return d1 + d2;
	}

	private Node lca(Node root, int n1, int n2) {
		// If both n1 and n2 are smaller than root, then LCA lies in left
		if (n1 < root.data && n2 < root.data)
			return lca(root.left, n1, n2);

		// If both n1 and n2 are greater than root, then LCA lies in right
		else if (n1 > root.data && n2 > root.data)
			return lca(root.right, n1, n2);

		// n1 is less than root and n2 is greater than root or vice-versa
		// then root is the LCA
		else
			return root;
	}

	private int distanceFromRoot(Node root, int x) {
		if (root.data == x)
			return 0;
		
		if (x < root.data)
			return 1 + distanceFromRoot(root.left, x);
		return 1 + distanceFromRoot(root.right, x);
	}

	public static void main(String[] args) {
		FindDistanceBetweenTwoNodes tree = new FindDistanceBetweenTwoNodes();
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