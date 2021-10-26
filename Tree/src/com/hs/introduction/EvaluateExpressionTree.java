package com.hs.introduction;

public class EvaluateExpressionTree {

	// Utility function to return the integer value of a given string
	private int toInt(String str) {
		int num = 0;
		for (int i = 0; i < str.length(); i++)
			num = num * 10 + (str.charAt(i) - 48);
		return num;
	}

	// This function receives a node of the syntax tree and recursively evaluates it
	private int eval(Node root) {
		// empty tree
		if (root == null)
			return 0;

		// leaf node i.e, an integer
		if (root.left == null && root.right == null)
			return toInt(root.info);

		// Evaluate left subtree
		int l_val = eval(root.left);

		// Evaluate right subtree
		int r_val = eval(root.right);

		// Check which operator to apply
		if (root.info == "+")
			return l_val + r_val;

		if (root.info == "-")
			return l_val - r_val;

		if (root.info == "*")
			return l_val * r_val;

		return l_val / r_val;
	}

	// driver function to check the above program
	public static void main(String[] args) {
		EvaluateExpressionTree tree = new EvaluateExpressionTree();
		// create a syntax tree
		Node root = new Node("+");
		root.left = new Node("*");
		root.left.left = new Node("5");
		root.left.right = new Node("4");
		root.right = new Node("-");
		root.right.left = new Node("100");
		root.right.right = new Node("20");
		System.out.println(tree.eval(root));
	}
}
