package com.hs.construction;

public class MirrorImage {

	Node mirror(Node root) {
		if (root == null)
			return root;

		/* do the subtrees */
		Node left = mirror(root.left);
		Node right = mirror(root.right);

		/* swap the left and right pointers */
		root.left = right;
		root.right = left;

		return root;
	}

	/*
	 * Helper function to test mirror(). Given a binary search tree, print out its
	 * data elements in increasing sorted order.
	 */
	void inOrder(Node node) {
		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.data + " ");

		inOrder(node.right);
	}

	/* testing for example nodes */
	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		MirrorImage tree = new MirrorImage();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		/* print inorder traversal of the input tree */
		System.out.println("Inorder traversal of input tree is :");
		tree.inOrder(root);
		System.out.println("");

		/* convert tree to its mirror */
		tree.mirror(root);

		/* print inorder traversal of the minor tree */
		System.out.println("Inorder traversal of binary tree is : ");
		tree.inOrder(root);

	}
}
