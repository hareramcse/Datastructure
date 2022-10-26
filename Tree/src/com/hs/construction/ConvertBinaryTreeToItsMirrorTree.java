package com.hs.construction;

import com.hs.tree.Node;

class ConvertBinaryTreeToItsMirrorTree {
	public void mirror(Node root) {
		if (root == null)
			return;

		mirror(root.left);
		mirror(root.right);

		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	private void inOrder(Node node) {
		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	public static void main(String args[]) {
		ConvertBinaryTreeToItsMirrorTree tree = new ConvertBinaryTreeToItsMirrorTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		// print inorder traversal of the input tree
		System.out.println("Inorder traversal of input tree is :");
		tree.inOrder(root);
		System.out.println("");

		// convert tree to its mirror
		tree.mirror(root);

		// print inorder traversal of the minor tree
		System.out.println("Inorder traversal of binary tree is : ");
		tree.inOrder(root);
	}
}