package com.hs.random;

class FindSizeOfBinaryTree {
	Node root;

	/*
	 * Given a binary tree. Print its nodes in level order using array for
	 * implementing queue
	 */
	int size() {
		return size(root);
	}

	/* computes number of nodes in tree */
	int size(Node root) {
		if (root == null)
			return 0;
		else
			return (size(root.left) + 1 + size(root.right));
	}

	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		FindSizeOfBinaryTree tree = new FindSizeOfBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("The size of binary tree is : " + tree.size());
	}
}
