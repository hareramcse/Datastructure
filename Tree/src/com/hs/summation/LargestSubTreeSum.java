package com.hs.summation;

/* Approach : Do post order traversal of the binary tree. At every node, find left subtree value and right 
 * subtree value recursively. The value of subtree rooted at current node is equal to sum of current 
 * node value, left node subtree sum and right node subtree sum. Compare current subtree sum with overall 
 * maximum subtree sum so far.*/
public class LargestSubTreeSum {

	static class INT {
		int v;

		INT(int a) {
			v = a;
		}
	}

	// Helper function to find largest subtree sum recursively.
	private static int findLargestSubtreeSumUtil(Node root, INT ans) {
		// If current node is null then return 0 to parent node.
		if (root == null)
			return 0;

		// Subtree sum rooted at current node.
		int currSum = root.data + findLargestSubtreeSumUtil(root.left, ans)
				+ findLargestSubtreeSumUtil(root.right, ans);

		// Update answer if current subtree sum is greater than answer so far.
		ans.v = Math.max(ans.v, currSum);

		// Return current subtree sum to its parent node.
		return currSum;
	}

	// Function to find largest subtree sum.
	private static int findLargestSubtreeSum(Node root) {
		// If tree does not exist, then answer is 0.
		if (root == null)
			return 0;

		// Variable to store maximum subtree sum.
		INT ans = new INT(-9999999);

		// Call to recursive function to find maximum subtree sum.
		findLargestSubtreeSumUtil(root, ans);

		return ans.v;
	}

	// Driver Code
	public static void main(String args[]) {

		Node root = new Node(1);
		root.left = new Node(-2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(-6);
		root.right.right = new Node(2);

		System.out.println(findLargestSubtreeSum(root));
	}
}