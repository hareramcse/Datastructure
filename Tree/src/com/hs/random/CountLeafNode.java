package com.hs.random;

public class CountLeafNode {

	// Root of the Binary Tree
	Node root;

	/* Function to get the count of leaf nodes in a binary tree */
	int getLeafCount() {
		return getLeafCount(root);
	}

	int getLeafCount(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1;
		} else {
			return getLeafCount(node.left) + getLeafCount(node.right);
		}
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		CountLeafNode tree = new CountLeafNode();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		/* get leaf count of the abve tree */
		System.out.println("The leaf count of binary tree is : " + tree.getLeafCount());
	}
}
