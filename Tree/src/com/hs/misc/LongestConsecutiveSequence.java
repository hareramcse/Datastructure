package com.hs.misc;

public class LongestConsecutiveSequence {

	// Utility method to return length of longest consecutive sequence of tree
	void longestConsecutiveUtil(Node root, int curLength, int expected, int res) {
		if (root == null)
			return;

		// if root data has one more than its parent then increase current length
		if (root.data == expected)
			curLength++;
		else
			curLength = 1;

		// update the maximum by current length
		res = Math.max(res, curLength);

		// recursively call left and right subtree with
		// expected value 1 more than root data
		longestConsecutiveUtil(root.left, curLength, root.data + 1, res);
		longestConsecutiveUtil(root.right, curLength, root.data + 1, res);
	}

	// method returns length of longest consecutive
	// sequence rooted at node root
	int longestConsecutive(Node root) {
		if (root == null)
			return 0;

		int res = 0;

		// call utility method with current length 0
		longestConsecutiveUtil(root, 0, root.data, res);

		return res;
	}

	public static void main(String[] args) {
		LongestConsecutiveSequence tree = new LongestConsecutiveSequence();
		Node root = new Node(6);
		root.right = new Node(9);
		root.right.left = new Node(7);
		root.right.right = new Node(10);
		root.right.right.right = new Node(11);

		System.out.println(tree.longestConsecutive(root));
	}
}
