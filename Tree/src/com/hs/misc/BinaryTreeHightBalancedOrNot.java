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

	/* Returns true if binary tree with root as root is height-balanced */
	private boolean isBalanced(Node root, Height height) {
		/* If tree is empty then return true */
		if (root == null) {
			height.height = 0;
			return true;
		}

		/* Get heights of left and right sub trees */
		Height lheight = new Height(), rheight = new Height();
		boolean l = isBalanced(root.left, lheight);
		boolean r = isBalanced(root.right, rheight);

		int lh = lheight.height, rh = rheight.height;

		// Height of current node is max of heights of left and right subtrees plus 1
		height.height = (lh > rh ? lh : rh) + 1;

		/*
		 * If difference between heights of left and right subtrees is more than 2 then
		 * this node is not balanced so return 0
		 */
		if ((lh - rh >= 2) || (rh - lh >= 2))
			return false;

		// If this node is balanced and left and right subtrees are balanced then return
		// true
		else
			return l && r;
	}

	public static void main(String args[]) {
		Height height = new Height();

		BinaryTreeHightBalancedOrNot tree = new BinaryTreeHightBalancedOrNot();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);
		root.left.left.left = new Node(7);

		if (tree.isBalanced(root, height))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
	}
}