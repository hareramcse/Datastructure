package com.hs.checkandprint;

import com.hs.tree.Node;

/*1) If the node is a leaf node then the sum of the subtree rooted with this node is 
 * equal to the value of this node. 
2) If the node is not a leaf node then the sum of the subtree rooted with this node is 
twice the value of this node (Assuming that the tree rooted with this node is SumTree).*/
// O(n)
class CheckBinaryTreeIsSumTree {

	public int isSumTree(Node root) {
		if (root == null) {
			return 0;
		}

		// special case: leaf node
		if (root.left == null && root.right == null) {
			return root.data;
		}

		int left = isSumTree(root.left);
		int right = isSumTree(root.right);

		// if the root's value is equal to the sum of all elements present in its
		// left and right subtree
		if (left != Integer.MIN_VALUE && right != Integer.MIN_VALUE && root.data == left + right) {
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

		if (tree.isSumTree(root) != Integer.MIN_VALUE)
			System.out.println("The given tree is a sum tree");
		else
			System.out.println("The given tree is not a sum tree");
	}
}