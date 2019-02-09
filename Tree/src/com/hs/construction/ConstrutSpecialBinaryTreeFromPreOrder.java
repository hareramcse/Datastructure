package com.hs.construction;

class Index {

	int index = 0;
}

class ConstrutSpecialBinaryTreeFromPreOrder {

	Index myindex = new Index();

	/*
	 * A recursive function to create a Binary Tree from given pre[] preLN[] arrays.
	 * The function returns root of tree. index_ptr is used to update index values
	 * in recursive calls. index must be initially passed as 0
	 */
	Node constructTreeUtil(int pre[], char preLN[], Index index_ptr, int n, Node temp) {
		int index = index_ptr.index; // store the current value of index in
										// pre[]

		// Base Case: All nodes are constructed
		if (index == n) {
			return null;
		}

		// Allocate memory for this node and increment index for
		// subsequent recursive calls
		temp = new Node(pre[index]);
		(index_ptr.index)++;

		// If this is an internal node, construct left and right subtrees and
		// link the subtrees
		if (preLN[index] == 'N') {
			temp.left = constructTreeUtil(pre, preLN, index_ptr, n, temp.left);
			temp.right = constructTreeUtil(pre, preLN, index_ptr, n, temp.right);
		}

		return temp;
	}

	// A wrapper over constructTreeUtil()
	Node constructTree(int pre[], char preLN[], int n, Node node) {
		return constructTreeUtil(pre, preLN, myindex, n, node);
	}

	/* This function is used only for testing */
	void printInorder(Node node) {
		if (node == null) {
			return;
		}

		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		System.out.print(node.data + " ");

		/* now recur on right child */
		printInorder(node.right);
	}

	// driver function to test the above functions
	public static void main(String args[]) {
		ConstrutSpecialBinaryTreeFromPreOrder tree = new ConstrutSpecialBinaryTreeFromPreOrder();
		int pre[] = new int[] { 10, 30, 20, 5, 15 };
		char preLN[] = new char[] { 'N', 'N', 'L', 'L', 'L' };
		int n = pre.length;

		// construct the above tree
		Node root = tree.constructTree(pre, preLN, n, null);

		// Test the constructed tree
		System.out.println("Following is Inorder Traversal of the Constructed Binary Tree: ");
		tree.printInorder(root);
	}
}
