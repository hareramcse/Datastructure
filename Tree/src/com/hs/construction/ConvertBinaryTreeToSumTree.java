package com.hs.construction;

import com.hs.tree.Node;

// O(n) 
class ConvertBinaryTreeToSumTree {

	private int convertTree(Node root) {
		if (root == null) {
			return 0;
		}

		// convert the left and right subtree before processing the root node
		int left = convertTree(root.left);
		int right = convertTree(root.right);

		// stores the current value of the root node
		int old = root.data;

		// update root to the sum of left and right subtree
		root.data = left + right;

		// return the updated value + the old value (sum of the tree rooted at
		// the root node)
		return root.data + old;
	}

	private void printPreorder(Node root) {
		if (root == null)
			return;
		
		System.out.print(root.data + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}

	public static void main(String args[]) {
		ConvertBinaryTreeToSumTree tree = new ConvertBinaryTreeToSumTree();

		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

		tree.convertTree(root);

		System.out.println("Inorder Traversal of the resultant tree is:");
		tree.printPreorder(root);
	}
}