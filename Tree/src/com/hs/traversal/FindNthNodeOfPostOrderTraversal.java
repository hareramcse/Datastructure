package com.hs.traversal;

public class FindNthNodeOfPostOrderTraversal {

	int count = 0;

	// function to find the N-th node in the postorder
	// traversal of a given binary tree
	public void NthPostordernode(Node root, int n) {

		if (root == null)
			return;

		if (count <= n) {
			// left recursion
			NthPostordernode(root.left, n);
			// right recursion
			NthPostordernode(root.right, n);
			count++;
			// prints the n-th node of preorder traversal
			if (count == n)
				System.out.print(root.data);
		}
	}

	public static void main(String args[]) {
		FindNthNodeOfPostOrderTraversal tree = new FindNthNodeOfPostOrderTraversal();
		Node root = new Node(25);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(18);
		root.left.right = new Node(22);
		root.right.left = new Node(24);
		root.right.right = new Node(32);

		int n = 6;

		// prints n-th node found
		tree.NthPostordernode(root, n);
	}
}