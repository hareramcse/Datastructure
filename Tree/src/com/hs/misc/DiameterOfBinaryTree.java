package com.hs.misc;
/* diameter of a tree is nothing but maximum value of (left_height + right_height + 1) for each 
 * node.*/

// O(n)
class DiameterOfBinaryTree {

	static class A {
		int ans = Integer.MIN_VALUE;
	}

	/* Function to find height of a tree */
	private int height(Node root, A a) {
		if (root == null)
			return 0;

		int left_height = height(root.left, a);

		int right_height = height(root.right, a);

		// update the answer, because diameter of a
		// tree is nothing but maximum value of
		// (left_height + right_height + 1) for each node
		a.ans = Math.max(a.ans, 1 + left_height + right_height);

		return 1 + Math.max(left_height, right_height);
	}

	/*
	 * Computes the diameter of binary tree with given root.
	 */
	private int diameter(Node root) {
		if (root == null)
			return 0;

		// This will store the final answer
		A a = new A();
		height(root, a);
		return a.ans;
	}

	public static void main(String[] args) {
		DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("Diameter is " + tree.diameter(root));
	}
}