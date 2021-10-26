package com.hs.checkandprint;

/* A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes 
 * present in its left subtree and right subtree. An empty tree is SumTree and the sum of 
 * an empty tree can be considered as 0. A leaf node is also considered as SumTree. 
			/*	26
		        /   \
		      10     3
		    /    \     \
		  4      6      3 */
class CheckBinaryTreeIsSumTree {

	/* Utility function to check if the given node is leaf or not */
	private int isLeaf(Node root) {
		if (root == null) {
			return 0;
		}else if (root.left == null && root.right == null) {
			return 1;
		}else {
			return 0;
		}
	}

	/* returns 1 if SumTree property holds for the given tree */
	private int isSumTree(Node node) {
		int ls; // for sum of nodes in left subtree
		int rs; // for sum of nodes in right subtree

		/*
		 * If node is NULL or it's a leaf node then return true
		 */
		if (node == null || isLeaf(node) == 1)
			return 1;

		if (isSumTree(node.left) != 0 && isSumTree(node.right) != 0) {

			// Get the sum of nodes in left subtree
			if (node.left == null) {
				ls = 0;
			} else if (isLeaf(node.left) != 0) {
				ls = node.left.data;
			} else {
				ls = 2 * (node.left.data);
			}

			// Get the sum of nodes in right subtree
			if (node.right == null) {
				rs = 0;
			} else if (isLeaf(node.right) != 0) {
				rs = node.right.data;
			} else {
				rs = 2 * (node.right.data);
			}

			/*
			 * If root's data is equal to sum of nodes in left and right subtrees then
			 * return 1 else return 0
			 */
			if (node.data == rs + ls)
				return 1;
			else
				return 0;
		}

		return 0;
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		CheckBinaryTreeIsSumTree tree = new CheckBinaryTreeIsSumTree();
		Node root = new Node(26);
		root.left = new Node(10);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(6);
		root.right.right = new Node(3);

		if (tree.isSumTree(root) != 0)
			System.out.println("The given tree is a sum tree");
		else
			System.out.println("The given tree is not a sum tree");
	}
}