package com.hs.traversal;

public class FindNthNodeOfInorderTraversal {
	int count = 0;

	/* Given a binary tree, print its nth nodes of inorder */
	void NthInorder(Node node, int n) {
		if (node == null)
			return;

		if (count <= n) {
			/* first recur on left child */
			NthInorder(node.left, n);
			count++;

			// when count = n then print element
			if (count == n)
				System.out.printf("%d ", node.data);

			/* now recur on right child */
			NthInorder(node.right, n);
		}
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		FindNthNodeOfInorderTraversal tree = new FindNthNodeOfInorderTraversal();
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);

		int n = 4;

		tree.NthInorder(root, n);
	}
}