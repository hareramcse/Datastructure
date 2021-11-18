package com.hs.lca;

public class FindKthAncestor {

	// temporary node to keep track of Node returned
	// from previous recursive call during backtrack
	private Node temp = null;
	private int k;

	// recursive function to calculate Kth ancestor
	private Node kthAncestorDFS(Node root, int node) {
		// Base case
		if (root == null)
			return null;

		if (root.data == node || (temp = kthAncestorDFS(root.left, node)) != null
				|| (temp = kthAncestorDFS(root.right, node)) != null) {
			if (k > 0)
				k--;

			else if (k == 0) {
				// print the kth ancestor
				System.out.print("Kth ancestor is: " + root.data);

				// return null to stop further backtracking
				return null;
			}

			// return current node to previous call
			return root;
		}
		return null;
	}

	// Driver code
	public static void main(String args[]) {
		FindKthAncestor tree = new FindKthAncestor();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		tree.k = 2;
		int node = 5;

		// print kth ancestor of given node
		Node parent = tree.kthAncestorDFS(root, node);

		// check if parent is not null, it means
		// there is no Kth ancestor of the node
		if (parent != null)
			System.out.println("-1");
	}

}
