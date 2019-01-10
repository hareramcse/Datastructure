package com.hs.random;

public class ConvertTreeToChildrenSumTree {

	static Node root;

	/*
	 * This function changes a tree to to hold children sum property
	 */

	void convertTree(Node root) {
		int leftData = 0, rightData = 0, diff;

		/*
		 * If tree is empty or it's a leaf node then return true
		 */
		if (root == null || (root.left == null && root.right == null)) {
			return;
		} else {

			/* convert left and right subtrees */
			convertTree(root.left);
			convertTree(root.right);

			/*
			 * If left child is not present then 0 is used as data of left child
			 */
			if (root.left != null) {
				leftData = root.left.data;
			}

			/*
			 * If right child is not present then 0 is used as data of right
			 * child
			 */
			if (root.right != null) {
				rightData = root.right.data;
			}

			/* get the diff of node's data and children sum */
			diff = leftData + rightData - root.data;

			/* If node's children sum is greater than the node's data */
			if (diff > 0) {
				root.data = root.data + diff;
			}

			/*
			 * THIS IS TRICKY --> If node's data is greater than children sum,
			 * then increment subtree by diff
			 */
			if (diff < 0) {
				increment(root, -diff); // -diff is used to make diff positive
			}
		}
	}

	/* This function is used to increment subtree by diff */
	void increment(Node node, int diff) {

		/* IF left child is not NULL then increment it */
		if (node.left != null) {
			node.left.data = node.left.data + diff;

			// Recursively call to fix the descendants of node->left
			increment(node.left, diff);
		} else if (node.right != null)// Else increment right child
		{
			node.right.data = node.right.data + diff;

			// Recursively call to fix the descendants of node->right
			increment(node.right, diff);
		}
	}

	/*
	 * Given a binary tree, printInorder() prints out its inorder traversal
	 */
	void printInorder(Node node) {
		if (node == null) {
			return;
		}

		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		System.out.print(node.data + " ");

		/* now recur on right child */
		printInorder(node.right);
	}

	// Driver program to test above functions
	public static void main(String args[]) {
		ConvertTreeToChildrenSumTree tree = new ConvertTreeToChildrenSumTree();
		tree.root = new Node(50);
		tree.root.left = new Node(7);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(1);
		tree.root.right.right = new Node(30);

		System.out.println("Inorder traversal before conversion is :");
		tree.printInorder(root);

		tree.convertTree(root);
		System.out.println("");

		System.out.println("Inorder traversal after conversion is :");
		tree.printInorder(root);

	}
}
