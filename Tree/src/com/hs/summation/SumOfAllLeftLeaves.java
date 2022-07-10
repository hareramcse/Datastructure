package com.hs.summation;

// 404. Sum of Left Leaves Leetcode
class SumOfAllLeftLeaves {
	int sum = 0;

	public int sumOfLeftLeaves(Node root) {
		if (root == null)
			return sum;

		boolean isLeft = false;
		sumOfLeftLeavesUtil(root, isLeft);
		return sum;
	}

	private void sumOfLeftLeavesUtil(Node root, boolean isLeft) {
		if (root.left == null && root.right == null && isLeft)
			sum = sum + root.data;

		// Pass true for left and false for right
		if (root.left != null)
			sumOfLeftLeavesUtil(root.left, true);

		if (root.right != null)
			sumOfLeftLeavesUtil(root.right, false);
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

		tree.sumOfLeftLeaves(root);
		System.out.println("The sum of leaves is " + tree.sum);
	}
}