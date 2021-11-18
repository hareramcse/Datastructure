package com.hs.summation;

public class CountSubTreeWithGivenSum {

	private int count = 0;
	private Node ptr;

	private int countSubtrees(Node root, int x) {
		int leftSum = 0, rightSum = 0;
		if (root == null)
			return 0;

		leftSum += countSubtrees(root.left, x);
		rightSum += countSubtrees(root.right, x);

		if (leftSum + rightSum + root.data == x)
			count++;

		if (ptr != root)
			return leftSum + root.data + rightSum;

		return count;
	}

	public static void main(String args[]) {
		CountSubTreeWithGivenSum tree = new CountSubTreeWithGivenSum();
		Node root = new Node(5);
		root.left = new Node(-10);
		root.right = new Node(3);
		root.left.left = new Node(9);
		root.left.right = new Node(8);
		root.right.left = new Node(-4);
		root.right.right = new Node(7);
		int x = 7;
		tree.ptr = root; // assigning global value of ptr
		System.out.println("Count = " + tree.countSubtrees(root, x));
	}
}