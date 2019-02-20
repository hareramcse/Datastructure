package com.hs.summation;

public class SubTreeWithGivenSum {

	static class INT {
		int v;

		INT(int a) {
			v = a;
		}
	}

	// function to check if there exist
	// any subtree with given sum
	// cur_sum -. sum of current subtree
	// from ptr as root
	// sum_left -. sum of left subtree
	// from ptr as root
	// sum_right -. sum of right subtree
	// from ptr as root
	static boolean sumSubtreeUtil(Node ptr, INT cur_sum, int sum) {
		// base condition
		if (ptr == null) {
			cur_sum = new INT(0);
			return false;
		}

		// Here first we go to left
		// sub-tree, then right subtree
		// then first we calculate sum
		// of all nodes of subtree having
		// ptr as root and assign it as
		// cur_sum. (cur_sum = sum_left +
		// sum_right + ptr.data) after that
		// we check if cur_sum == sum
		INT sum_left = new INT(0), sum_right = new INT(0);
		return (sumSubtreeUtil(ptr.left, sum_left, sum) || sumSubtreeUtil(ptr.right, sum_right, sum)
				|| ((cur_sum.v = sum_left.v + sum_right.v + ptr.data) == sum));
	}

	// Wrapper over sumSubtreeUtil()
	static boolean sumSubtree(Node root, int sum) {
		// Initialize sum of
		// subtree with root
		INT cur_sum = new INT(0);

		return sumSubtreeUtil(root, cur_sum, sum);
	}

	// Driver Code
	public static void main(String args[]) {
		Node root = new Node(8);
		root.left = new Node(5);
		root.right = new Node(4);
		root.left.left = new Node(9);
		root.left.right = new Node(7);
		root.left.right.left = new Node(1);
		root.left.right.right = new Node(12);
		root.left.right.right.right = new Node(2);
		root.right.right = new Node(11);
		root.right.right.left = new Node(3);
		int sum = 22;

		if (sumSubtree(root, sum))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}