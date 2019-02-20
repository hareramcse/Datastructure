package com.hs.summation;

public class CountSubTreeWithGivenSum {

	static class INT {
		int v;

		INT(int a) {
			v = a;
		}
	}

	// function to count subtrees that sum up to a given value x
	static int countSubtreesWithSumX(Node root, INT count, int x) {
		// if tree is empty
		if (root == null)
			return 0;

		// sum of nodes in the left subtree
		int ls = countSubtreesWithSumX(root.left, count, x);

		// sum of nodes in the right subtree
		int rs = countSubtreesWithSumX(root.right, count, x);

		// sum of nodes in the subtree
		// rooted with 'root.data'
		int sum = ls + rs + root.data;

		// if true
		if (sum == x)
			count.v++;

		// return subtree's nodes sum
		return sum;
	}

	// utility function to count subtrees that sum up to a given value x
	static int countSubtreesWithSumXUtil(Node root, int x) {
		// if tree is empty
		if (root == null)
			return 0;

		INT count = new INT(0);

		// sum of nodes in the left subtree
		int ls = countSubtreesWithSumX(root.left, count, x);

		// sum of nodes in the right subtree
		int rs = countSubtreesWithSumX(root.right, count, x);

		// if tree's nodes sum == x
		if ((ls + rs + root.data) == x)
			count.v++;

		// required count of subtrees
		return count.v;
	}

	public static void main(String args[]) {
		Node root = new Node(5);
		root.left = new Node(-10);
		root.right = new Node(3);
		root.left.left = new Node(9);
		root.left.right = new Node(8);
		root.right.left = new Node(-4);
		root.right.right = new Node(7);

		int x = 7;

		System.out.println("Count = " + countSubtreesWithSumXUtil(root, x));
	}
}