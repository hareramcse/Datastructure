package com.hs.bt;

import com.hs.tree.Node;

/*1) If the node is a leaf node then the sum of the subtree rooted with this node is 
 * equal to the value of this node. 
2) If the node is not a leaf node then the sum of the subtree rooted with this node is 
twice the value of this node (Assuming that the tree rooted with this node is SumTree).*/
// O(n)
class CheckBinaryTreeIsSumTree {
	public boolean isSumTree(Node root) {
		int result = isSumTreeUtil(root);
		if (result != Integer.MIN_VALUE)
			return true;
		return false;
	}

	private int isSumTreeUtil(Node root) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null) {
			return root.data;
		}

		int left = isSumTreeUtil(root.left);
		int right = isSumTreeUtil(root.right);

		if (left != Integer.MIN_VALUE && right != Integer.MIN_VALUE & root.data == left + right) {
			return 2 * root.data;
		}

		return Integer.MIN_VALUE;
	}

	public static void main(String args[]) {
		CheckBinaryTreeIsSumTree tree = new CheckBinaryTreeIsSumTree();
		Node root = new Node(26);
		root.left = new Node(10);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(6);
		root.right.right = new Node(3);

		boolean result = tree.isSumTree(root);
		System.out.println(result);
	}
}