package com.hs.construction;

/*
 * Algorithm: 
Recursively convert the tree to double tree in postorder fashion. For each node, first 
convert the left subtree of the node, then right subtree, finally create a duplicate 
node of the node and fix the left child of the node and left child of left child.*/
class ConvertBinaryTreeToDoubleTree {

	// Function to convert a tree to double tree
	private void doubleTree(Node root) {
		Node oldLeft;

		if (root == null) {
			return;
		}

		// do the subtrees
		doubleTree(root.left);
		doubleTree(root.right);

		// duplicate this node to its left
		oldLeft = root.left;
		root.left = new Node(root.data);
		root.left.left = oldLeft;
	}

	// Given a binary tree, print its nodes in inorder
	private void printInorder(Node root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

	public static void main(String args[]) {
		ConvertBinaryTreeToDoubleTree tree = new ConvertBinaryTreeToDoubleTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("Original tree is : ");
		tree.printInorder(root);
		tree.doubleTree(root);
		System.out.println("");
		System.out.println("Inorder traversal of double tree is : ");
		tree.printInorder(root);

	}
}