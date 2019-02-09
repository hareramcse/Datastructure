package com.hs.random;

class IsBinaryTreeFoldable {

	/* Returns true if the given tree is foldable */
	boolean isFoldable(Node node) {
		boolean res;

		/* base case */
		if (node == null) {
			return true;
		}

		/* convert left subtree to its mirror */
		mirror(node.left);

		/*
		 * Compare the structures of the right subtree and mirrored left subtree
		 */
		res = isStructSame(node.left, node.right);

		/* Get the originial tree back */
		mirror(node.left);

		return res;
	}

	boolean isStructSame(Node a, Node b) {
		if (a == null && b == null) {
			return true;
		}
		if (a != null && b != null && isStructSame(a.left, b.left) && isStructSame(a.right, b.right)) {
			return true;
		}

		return false;
	}

	/* UTILITY FUNCTIONS */
	/*
	 * Change a tree so that the roles of the left and right pointers are swapped at
	 * every node. See http://geeksforgeeks.org/?p=662 for details
	 */
	void mirror(Node node) {
		if (node == null) {
			return;
		} else {
			/* do the subtrees */
			mirror(node.left);
			mirror(node.right);

			/* swap the pointers in this node */
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
	}

	public static void main(String args[]) {
		IsBinaryTreeFoldable tree = new IsBinaryTreeFoldable();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.left.right = new Node(5);

		if (tree.isFoldable(root)) {
			System.out.println("tree is foldable");
		} else {
			System.out.println("Tree is not foldable");
		}

	}
}
