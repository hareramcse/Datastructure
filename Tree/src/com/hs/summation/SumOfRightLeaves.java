package com.hs.summation;

class SumOfRightLeaves {

	// sum
	static int sum = 0;

	// return new node
	static Node addNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = temp.right = null;
		return temp;
	}

	// utility function to calculate
	// sum of right leaf nodes
	static void rightLeafSum(Node root) {
		if (root == null)
			return;

		// check if the right child
		// of root is leaf node
		if (root.right != null)
			if (root.right.left == null && root.right.right == null)
				sum += root.right.data;

		rightLeafSum(root.left);
		rightLeafSum(root.right);
	}

	// Driver Code
	public static void main(String args[]) {

		// contruct binary tree
		Node root = addNode(1);
		root.left = addNode(2);
		root.left.left = addNode(4);
		root.left.right = addNode(5);
		root.left.left.right = addNode(2);
		root.right = addNode(3);
		root.right.right = addNode(8);
		root.right.right.left = addNode(6);
		root.right.right.right = addNode(7);

		// variable to store sum
		// of right leaves
		sum = 0;
		rightLeafSum(root);
		System.out.println(sum);
	}
}