package com.hs.checkandprint;

class CheckBinaryTreeIsSumTree {
	/*
	 * A utility function to get the sum of values in tree with root as root
	 */
	int sum(Node root) {
		if (root == null) {
			return 0;
		}
		return sum(root.left) + root.data + sum(root.right);
	}

	/*
	 * returns 1 if sum property holds for the given node and both of its children
	 */
	int isSumTree(Node node) {
		int ls, rs;

		/*
		 * If node is NULL or it's a leaf node then return true
		 */
		if ((node == null) || (node.left == null && node.right == null))
			return 1;

		/* Get sum of nodes in left and right subtrees */
		ls = sum(node.left);
		rs = sum(node.right);

		/*
		 * if the node and both of its children satisfy the property return 1 else 0
		 */
		if ((node.data == ls + rs) && (isSumTree(node.left) != 0) && (isSumTree(node.right)) != 0)
			return 1;

		return 0;
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		CheckBinaryTreeIsSumTree tree = new CheckBinaryTreeIsSumTree();
		Node root = new Node(26);
		root.left = new Node(10);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(6);
		root.right.right = new Node(3);

		if (tree.isSumTree(root) != 0)
			System.out.println("The given tree is a sum tree");
		else
			System.out.println("The given tree is not a sum tree");
	}
}