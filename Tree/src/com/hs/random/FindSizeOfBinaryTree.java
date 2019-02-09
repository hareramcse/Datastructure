package com.hs.random;

class FindSizeOfBinaryTree {

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
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("The size of binary tree is : " + tree.size(root));
	}
}
