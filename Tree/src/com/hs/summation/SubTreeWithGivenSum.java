package com.hs.summation;

/* The idea is to traverse tree in Postorder fashion because here we have to think bottom-up . 
 * First calculate the sum of left subtree then right subtree and check if 
 * sum_left + sum_right + cur_node = sum is satisfying the condition that means any subtree with given 
 * sum exist*/

class Result {
	int sum = Integer.MIN_VALUE;
}

public class SubTreeWithGivenSum {
	// Wrapper over sumSubtreeUtil()
	private static boolean sumSubtree(Node root, int sum) {
		// Initialize sum of subtree with root
		Result cur_sum = new Result();

		return sumSubtreeUtil(root, cur_sum, sum);
	}

	private static boolean sumSubtreeUtil(Node root, Result cur_sum, int sum) {
		// base condition
		if (root == null) {
			cur_sum.sum = 0;
			return false;
		}

		Result sumLeft = new Result(), sumRight = new Result();
		return (sumSubtreeUtil(root.left, sumLeft, sum) || sumSubtreeUtil(root.right, sumRight, sum)
				|| ((cur_sum.sum = sumLeft.sum + sumRight.sum + root.data) == sum));
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