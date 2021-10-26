package com.hs.introduction;

public class ContinuousTree {

	// Function to check tree is continuous or not
	private static boolean treeContinuous(Node root) {
		// if next node is empty then return true
		if (root == null)
			return true;

		// if current node is leaf node then return true
		// because it is end of root to leaf path
		if (root.left == null && root.right == null)
			return true;

		// If left subtree is empty, then only check right
		if (root.left == null)
			return (Math.abs(root.data - root.right.data) == 1) && treeContinuous(root.right);

		// If right subtree is empty, then only check left
		if (root.right == null)
			return (Math.abs(root.data - root.left.data) == 1) && treeContinuous(root.left);

		// If both left and right subtrees are not empty, check everything
		return Math.abs(root.data - root.left.data) == 1 && Math.abs(root.data - root.right.data) == 1
				&& treeContinuous(root.left) && treeContinuous(root.right);
	}

	/* Driver program to test mirror() */
	public static void main(String args[]) {
		Node root = new Node(3);
		root.left = new Node(2);
		root.right = new Node(4);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.right = new Node(5);
		if (treeContinuous(root))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}