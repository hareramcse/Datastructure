package com.hs.misc;

/*
 * To check if a tree is height-balanced, get the height of left and right subtrees. 
 * Return true if difference between heights is not more than 1 and left and right subtrees 
 * are balanced, otherwise return false. 
 * */
class Height {
	int height = 0;
}

class BinaryTreeHightBalancedOrNot {
	boolean isBalanced = true;

	public boolean isBalanced(Node root) {
		if (root == null)
			return true;

		int lHeight = height(root.left);
		int rHeight = height(root.right);
		if (Math.abs(lHeight - rHeight) > 1) {
			isBalanced = false;
		}
		return isBalanced && isBalanced(root.left) && isBalanced(root.right);
	}

	private int height(Node root) {
		if (root == null)
			return 0;

		int lHeight = height(root.left);
		int rHeight = height(root.right);

		if (lHeight > rHeight)
			return lHeight + 1;
		else
			return rHeight + 1;
	}

	public static void main(String args[]) {
		BinaryTreeHightBalancedOrNot tree = new BinaryTreeHightBalancedOrNot();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);
		root.left.left.left = new Node(7);

		if (tree.isBalanced(root))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
	}
}