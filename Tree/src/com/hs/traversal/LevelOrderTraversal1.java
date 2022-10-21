package com.hs.traversal;

import com.hs.tree.Node;

class LevelOrderTraversal1 {

	// function to print level order traversal of tree
	public void levelOrderTraversal(Node root) {
		int h = height(root);
		for (int i = 1; i <= h; i++) {
			printGivenLevel(root, i);

			// add bellow line to print the data line by line
			System.out.println();
		}
	}

	private int height(Node root) {
		if (root == null)
			return 0;
		
		// compute height of each subtree
		int lHeight = height(root.left);
		int rHeight = height(root.right);

		return 1 + Math.max(lHeight, rHeight);
	}

	// Print nodes at the given level
	private void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	// Driver program to test above functions
	public static void main(String args[]) {
		LevelOrderTraversal1 tree = new LevelOrderTraversal1();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("Level order traversal of binary tree is ");
		tree.levelOrderTraversal(root);
	}
}