package com.hs.summation;

/* Approach : Do post order traversal of the binary tree(we can do any traversal approach). At every node, find left subtree value and right 
 * subtree value recursively. The value of subtree rooted at current node is equal to sum of current 
 * node value, left node subtree sum and right node subtree sum. Compare current subtree sum with overall 
 * maximum subtree sum so far.*/
public class LargestSubTreeSum {

	class Result {
		int maxSum = Integer.MIN_VALUE;
	}

	// Helper function to find largest subtree sum recursively.
	private int findLargestSubtreeSumUtil(Node root, Result result) {
		// If current node is null then return 0 to parent node.
		if (root == null)
			return 0;

		// Subtree sum rooted at current node.
		int currSum = root.data + findLargestSubtreeSumUtil(root.left, result)
				+ findLargestSubtreeSumUtil(root.right, result);

		// Update answer if current subtree sum is greater than answer so far.
		result.maxSum = Math.max(result.maxSum, currSum);

		// Return current subtree sum to its parent node.
		return currSum;
	}

	// Function to find largest subtree sum.
	private int findLargestSubtreeSum(Node root) {
		// If tree does not exist, then answer is 0.
		if (root == null)
			return 0;

		// Variable to store maximum subtree sum.
		Result result = new Result();

		// Call to recursive function to find maximum subtree sum.
		findLargestSubtreeSumUtil(root, result);

		return result.maxSum;
	}

	// Driver Code
	public static void main(String args[]) {
		LargestSubTreeSum tree = new LargestSubTreeSum();

		Node root = new Node(1);
		root.left = new Node(-2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(-6);
		root.right.right = new Node(2);

		System.out.println(tree.findLargestSubtreeSum(root));
	}
}