package com.hs.summation;

public class CountSubTreeWithGivenSum {

	private static int count = 0;
	private static Node ptr;

	private int countSubtreesWithSumXUtil(Node root, int x) {
		int l = 0, r = 0;
		if (root == null)
			return 0;
		l += countSubtreesWithSumXUtil(root.left, x);
		r += countSubtreesWithSumXUtil(root.right, x);
		if (l + r + root.data == x)
			count++;
		if (ptr != root)
			return l + root.data + r;
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
		ptr = root; // assigning global value of ptr
		System.out.println("Count = " + tree.countSubtreesWithSumXUtil(root, x));
	}
}