package com.hs.introduction;

public class TreeIsFoldable {

	/* Returns true if the given tree can be folded */
	private boolean IsFoldable(Node root) {
		if (root == null)
			return true;

		return IsFoldableUtil(root.left, root.right);
	}

	/*
	 * A utility function that checks if trees with roots as root1 and root2 are mirror of
	 * each other
	 */
	private boolean IsFoldableUtil(Node root1, Node root2) {

		/* If both left and right subtrees are NULL, then return true */
		if (root1 == null && root2 == null)
			return true;

		/*  If one of the trees is NULL and other is not, then return false */
		if (root1 == null || root2 == null)
			return false;

		/* Otherwise check if left and right subtrees are mirrors of their counterparts */
		return IsFoldableUtil(root1.left, root2.right) && IsFoldableUtil(root1.right, root2.left);
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		TreeIsFoldable tree = new TreeIsFoldable();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.left.right = new Node(5);

		if (tree.IsFoldable(root))
			System.out.println("tree is foldable");
		else
			System.out.println("Tree is not foldable");

	}
}