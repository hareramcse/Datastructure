package com.hs.summation;

class SumOfAllNode {

	/*
	 * Function to find sum of all the elements
	 */
	private int sum(Node root) {
		if (root == null)
			return 0;
		return (root.data + sum(root.left) + sum(root.right));
	}

	// Driver Code
	public static void main(String args[]) {
		SumOfAllNode tree = new SumOfAllNode();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);

		int sum = tree.sum(root);
		System.out.println("Sum of all the elements is: " + sum);
	}
}