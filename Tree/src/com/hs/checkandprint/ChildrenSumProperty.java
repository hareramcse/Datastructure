package com.hs.checkandprint;

import com.hs.tree.Node;

/*Algorithm: 
For each node check (recursively) if the node and both its children satisfy the Children Sum Property, 
if so then return true else return false.*/

// 2236. Root Equals Sum of Children Leetcode
class ChildrenSumProperty {

	public boolean checkTree(Node root) {
		int sum = hasChildrenSumProperty(root);
		if (sum != Integer.MIN_VALUE)
			return true;
		return false;
	}

	public int hasChildrenSumProperty(Node root) {
		// base case: empty tree
		if (root == null) {
			return 0;
		}

		// base case: leaf node
		if (root.left == null && root.right == null) {
			return root.data;
		}

		int left = hasChildrenSumProperty(root.left);
		int right = hasChildrenSumProperty(root.right);

		// if the root's value is equal to the sum of values at its left and
		// right subtree
		if (left != Integer.MIN_VALUE && right != Integer.MIN_VALUE && root.data == left + right) {
			return root.data;
		}

		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		ChildrenSumProperty tree = new ChildrenSumProperty();
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.right = new Node(2);
		if (tree.checkTree(root))
			System.out.println("The given tree satisfies children sum property");
		else
			System.out.println("The given tree does not satisfy children sum property");
	}
}