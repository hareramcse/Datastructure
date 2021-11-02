package com.hs.summation;

public class SumOfNodesOnLongestPathFromRootToLeaf {

	private int maxLen;
	private int maxSum;

	// utility function to find the sum of nodes on the longest path from root to
	// leaf node
	private int sumOfLongRootToLeafPathUtil(Node root) {
		// if tree is NULL, then sum is 0
		if (root == null)
			return 0;

		maxSum = Integer.MIN_VALUE;
		maxLen = 0;

		// finding the maximum sum 'maxSum' for the maximum length root to leaf path
		longestPathFromRootToLeafNode(root, 0, 0);
		return maxSum;
	}

	// function to find the sum of nodes on the longest path from root to leaf node
	private void longestPathFromRootToLeafNode(Node root, int sum, int len) {
		// if true, then we have traversed a root to leaf path
		if (root == null) {
			// update maximum length and maximum sum according to the given conditions
			if (maxLen < len) {
				maxLen = len;
				maxSum = sum;
			} else if (maxLen == len && maxSum < sum)
				maxSum = sum;
			return;
		}

		longestPathFromRootToLeafNode(root.left, sum + root.data, len + 1);
		longestPathFromRootToLeafNode(root.right, sum + root.data, len + 1);
	}

	// Driver program to test above
	public static void main(String args[]) {
		SumOfNodesOnLongestPathFromRootToLeaf tree = new SumOfNodesOnLongestPathFromRootToLeaf();
		// binary tree formation
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(7);
		root.left.right = new Node(1);
		root.right.left = new Node(2);
		root.right.right = new Node(3);
		root.left.right.left = new Node(6);

		System.out.println("Sum = " + tree.sumOfLongRootToLeafPathUtil(root));
	}
}