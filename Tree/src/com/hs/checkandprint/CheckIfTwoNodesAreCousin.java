package com.hs.checkandprint;

import com.hs.tree.Node;

/* The idea is to find level of one of the nodes. Using the found level, check if a 
 * and b are at this level. If a and b are at given level, then finally check if 
 * they are not children of same parent.*/

class CheckIfTwoNodesAreCousin {
	public boolean isCousins(Node root, int x, int y) {
		int levelA = findLevel(root, x, 1);
		int levelB = findLevel(root, y, 1);

		if ((levelA == levelB) && !isSibling(root, x, y)) {
			return true;
		} else {
			return false;
		}
	}

	private int findLevel(Node root, int data, int level) {
		if (root == null)
			return 0;
		
		if (root.data == data)
			return level;
		
		int left = findLevel(root.left, data, level + 1);
		if (left != 0) {
			return left;
		}
		return findLevel(root.right, data, level + 1);
	}

	private boolean isSibling(Node root, int x, int y) {
		if (root == null)
			return false;

		if (root.left != null && root.right != null)
			return ((root.left.data == x && root.right.data == y) || (root.left.data == y && root.right.data == x)
					|| isSibling(root.left, x, y) || isSibling(root.right, x, y));
		return false;
	}

	public static void main(String args[]) {
		CheckIfTwoNodesAreCousin tree = new CheckIfTwoNodesAreCousin();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.right = new Node(15);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);

		if (tree.isCousins(root, 4, 7))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}