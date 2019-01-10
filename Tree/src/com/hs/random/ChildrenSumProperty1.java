package com.hs.random;

class ChildrenSumProperty1 {
	static Node root;

	/*
	 * returns 1 if children sum property holds for the given node and both of its
	 * children
	 */
	int isSumProperty(Node root) {

		/* left_data is left child data and right_data is for right child data */
		int leftData = 0, rightData = 0;

		/* If node is NULL or it's a leaf node then return true */
		if (root == null || (root.left == null && root.right == null))
			return 1;
		else {

			/* If left child is not present then 0 is used as data of left child */
			if (root.left != null)
				leftData = root.left.data;

			/*
			 * If right child is not present then 0 is used as data of right child
			 */
			if (root.right != null)
				rightData = root.right.data;

			/*
			 * if the node and both of its children satisfy the property return 1 else 0
			 */
			if ((root.data == leftData + rightData) && (isSumProperty(root.left) != 0)
					&& isSumProperty(root.right) != 0)
				return 1;
			else
				return 0;
		}
	}

	/* driver program to test the above functions */
	public static void main(String[] args) {
		ChildrenSumProperty1 tree = new ChildrenSumProperty1();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(2);
		if (tree.isSumProperty(root) != 0)
			System.out.println("The given tree satisfies children" + " sum property");
		else
			System.out.println("The given tree does not satisfy children" + " sum property");
	}
}
