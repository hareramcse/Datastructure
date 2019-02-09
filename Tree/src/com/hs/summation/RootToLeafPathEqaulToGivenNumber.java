package com.hs.summation;

class RootToLeafPathEqaulToGivenNumber {

	/*
	 * Given a tree and a sum, return true if there is a path from the root down to
	 * a leaf, such that adding up all the values along the path equals the given
	 * sum.
	 * 
	 * Strategy: subtract the node value from the sum when recurring down, and check
	 * to see if the sum is 0 when you run out of tree.
	 */

	boolean haspathSum(Node root, int sum) {
		if (root == null)
			return (sum == 0);
		else {
			boolean ans = false;

			/* otherwise check both subtrees */
			int subsum = sum - root.data;
			if (subsum == 0 && root.left == null && root.right == null)
				return true;
			if (root.left != null)
				ans = ans || haspathSum(root.left, subsum);
			if (root.right != null)
				ans = ans || haspathSum(root.right, subsum);
			return ans;
		}
	}

	/* Driver program to test the above functions */
	public static void main(String args[]) {
		int sum = 21;

		/*
		 * Constructed binary tree is 10 / \ 8 2 / \ / 3 5 2
		 */
		RootToLeafPathEqaulToGivenNumber tree = new RootToLeafPathEqaulToGivenNumber();
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(2);

		if (tree.haspathSum(root, sum))
			System.out.println("There is a root to leaf path with sum " + sum);
		else
			System.out.println("There is no root to leaf path with sum " + sum);
	}
}