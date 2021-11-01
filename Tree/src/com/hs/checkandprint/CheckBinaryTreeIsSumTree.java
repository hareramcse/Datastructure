package com.hs.checkandprint;

/*1) If the node is a leaf node then the sum of the subtree rooted with this node is 
 * equal to the value of this node. 
2) If the node is not a leaf node then the sum of the subtree rooted with this node is 
twice the value of this node (Assuming that the tree rooted with this node is SumTree).*/
// O(n)
class CheckBinaryTreeIsSumTree {

	/* Utility function to check if the given node is leaf or not */
	private int isLeaf(Node root) {
		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			return 1;
		} else {
			return 0;
		}
	}

	/* returns 1 if SumTree property holds for the given tree */
	private int isSumTree(Node root) {
		int ls; // for sum of nodes in left subtree
		int rs; // for sum of nodes in right subtree

		/*
		 * If node is NULL or it's a leaf node then return true
		 */
		if (root == null || isLeaf(root) == 1)
			return 1;

		if (isSumTree(root.left) != 0 && isSumTree(root.right) != 0) {

			// Get the sum of nodes in left subtree
			if (root.left == null) {
				ls = 0;
			} else if (isLeaf(root.left) != 0) {
				ls = root.left.data;
			} else {
				ls = 2 * (root.left.data);
			}

			// Get the sum of nodes in right subtree
			if (root.right == null) {
				rs = 0;
			} else if (isLeaf(root.right) != 0) {
				rs = root.right.data;
			} else {
				rs = 2 * (root.right.data);
			}

			/*
			 * If root's data is equal to sum of nodes in left and right subtrees then
			 * return 1 else return 0
			 */
			if (root.data == rs + ls)
				return 1;
			else
				return 0;
		}

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