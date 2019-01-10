package com.hs.lca;

public class FindDistanceBetweenTwoNodes {
	Node LCA(Node root, int n1, int n2) {
		// Your code here
		if (root == null)
			return root;
		if (root.data == n1 || root.data == n2)
			return root;

		Node left = LCA(root.left, n1, n2);
		Node right = LCA(root.right, n1, n2);

		if (left != null && right != null)
			return root;
		if (left != null)
			return LCA(root.left, n1, n2);

		return LCA(root.right, n1, n2);
	}

	// Returns level of key k if it is present in
	// tree, otherwise returns -1
	int findLevel(Node root, int k, int level) {
		if (root == null)
			return -1;
		if (root.data == k)
			return level;

		int left = findLevel(root.left, k, level + 1);
		if (left == -1)
			return findLevel(root.right, k, level + 1);
		return left;
	}

	int findDistance(Node root, int a, int b) {
		// Your code here
		Node lca = LCA(root, a, b);

		int d1 = findLevel(lca, a, 0);
		int d2 = findLevel(lca, b, 0);

		return d1 + d2;
	}

	// Driver program to test above functions
	public static void main(String args[]) {
		FindDistanceBetweenTwoNodes fdbtn = new FindDistanceBetweenTwoNodes();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		System.out.println("Dist (4,5) : " + fdbtn.findDistance(root, 4, 5));
		System.out.println("Dist (4,6) : " + fdbtn.findDistance(root, 4, 6));
		System.out.println("Dist (3,4) : " + fdbtn.findDistance(root, 3, 4));
		System.out.println("Dist (2,4) : " + fdbtn.findDistance(root, 2, 4));
		System.out.println("Dist (8,5) : " + fdbtn.findDistance(root, 8, 5));
	}
}
