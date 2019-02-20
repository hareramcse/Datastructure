package com.hs.introduction;

public class ContinuousTree {

	// Function to check tree is continuous or not

	static boolean treeContinuous(Node ptr) {
		// if next node is empty then return true
		if (ptr == null)
			return true;

		// if current node is leaf node then return true
		// because it is end of root to leaf path
		if (ptr.left == null && ptr.right == null)
			return true;

		// If left subtree is empty, then only check right
		if (ptr.left == null)
			return (Math.abs(ptr.data - ptr.right.data) == 1) && treeContinuous(ptr.right);

		// If right subtree is empty, then only check left
		if (ptr.right == null)
			return (Math.abs(ptr.data - ptr.left.data) == 1) && treeContinuous(ptr.left);

		// If both left and right subtrees are not empty, check
		// everything
		return Math.abs(ptr.data - ptr.left.data) == 1 && Math.abs(ptr.data - ptr.right.data) == 1
				&& treeContinuous(ptr.left) && treeContinuous(ptr.right);
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