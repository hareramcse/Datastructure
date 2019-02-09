package com.hs.checkandprint;

class PrintMaxValue {

	// Returns the max value in a binary tree
	int findMax(Node node) {
		if (node == null)
			return Integer.MIN_VALUE;

		int res = node.data;
		int lres = findMax(node.left);
		int rres = findMax(node.right);

		if (lres > res)
			res = lres;
		if (rres > res)
			res = rres;
		return res;
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		PrintMaxValue tree = new PrintMaxValue();
		Node root = new Node(2);
		root.left = new Node(7);
		root.right = new Node(5);
		root.left.right = new Node(6);
		root.left.right.left = new Node(1);
		root.left.right.right = new Node(11);
		root.right.right = new Node(9);
		root.right.right.left = new Node(4);

		System.out.println("Maximum element is " + tree.findMax(root));
	}
}