package com.hs.bt;

import com.hs.tree.Node;

class SumOfAllLeftLeaves {
	public int sumOfLeftLeaves(Node root) {
		boolean isLeft = false;
		int[] sum = new int[1];
		sumOfLeftLeavesUtil(root, isLeft, sum);
		return sum[0];
	}

	private void sumOfLeftLeavesUtil(Node root, boolean isLeft, int[] sum) {
		if (root == null)
			return;

		if (root.left == null && root.right == null && isLeft)
			sum[0] = sum[0] + root.data;

		// Pass true for left and false for right
		sumOfLeftLeavesUtil(root.left, true, sum);
		sumOfLeftLeavesUtil(root.right, false, sum);
	}

	public static void main(String args[]) {
		SumOfAllLeftLeaves tree = new SumOfAllLeftLeaves();
		Node root = new Node(20);
		root.left = new Node(9);
		root.right = new Node(49);
		root.left.right = new Node(12);
		root.left.left = new Node(5);
		root.right.left = new Node(23);
		root.right.right = new Node(52);
		root.left.right.right = new Node(12);
		root.right.right.left = new Node(50);

		int sum = tree.sumOfLeftLeaves(root);
		System.out.println("The sum of leaves is: " + sum);
	}
}