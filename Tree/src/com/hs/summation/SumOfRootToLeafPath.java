package com.hs.summation;

public class SumOfRootToLeafPath {

	private boolean hasPathSum(Node root, int sum) {
		if (root == null) {
			return (sum == 0);
		} else {
			boolean ans = false;

			/* otherwise check both subtrees */
			int subSum = sum - root.data;
			if (subSum == 0 && root.left == null && root.right == null) {
				return true;
			}
			if (root.left != null) {
				ans = ans || hasPathSum(root.left, subSum);
			}
			if (root.right != null) {
				ans = ans || hasPathSum(root.right, subSum);
			}
			return ans;
		}
	}

	public static void main(String args[]) {
		int sum = 14;
		SumOfRootToLeafPath tree = new SumOfRootToLeafPath();
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(2);

		if (tree.hasPathSum(root, sum)) {
			System.out.println("There is a root to leaf path with sum " + sum);
		} else {
			System.out.println("There is no root to leaf path with sum " + sum);
		}
	}
}
