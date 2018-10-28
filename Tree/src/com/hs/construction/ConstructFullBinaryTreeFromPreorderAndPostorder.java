package com.hs.construction;

public class ConstructFullBinaryTreeFromPreorderAndPostorder {
	// variable to hold index in pre[] array
	static int preindex;

	// A recursive function to construct Full from pre[] and post[]. preIndex is
	// used to keep track of index in pre[]. low is low index and high is high index
	// for the current subarray in post[]
	static Node constructTreeUtil(int pre[], int post[], int low, int high, int size) {

		// Base case
		if (preindex >= size || low > high)
			return null;

		// The first node in preorder traversal is root. So take the node at preIndex
		// from preorder and make it root, and increment preIndex
		Node root = new Node(pre[preindex++]);

		// If the current sub array has only one element, no need to recur or
		// preIndex > size after incrementing
		if (low == high || preindex >= size)
			return root;
		
		int i;

		// Search the next element of pre[] in post[]
		for (i = low; i <= high; i++) {
			if (post[i] == pre[preindex])
				break;
		}
		// Use the index of element found in postorder to divide postorder array
		// in two parts. Left subtree and right subtree
		if (i <= high) {
			root.left = constructTreeUtil(pre, post, low, i, size);
			root.right = constructTreeUtil(pre, post, i + 1, high, size);
		}
		return root;
	}

	// The main function to construct Full Binary Tree from given preorder and
	// postorder traversals. This function mainly uses constructTreeUtil()
	static Node constructTree(int pre[], int post[], int size) {
		preindex = 0;
		return constructTreeUtil(pre, post, 0, size - 1, size);
	}

	static void printInorder(Node root) {
		if (root == null)
			return;
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

	public static void main(String[] args) {

		int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
		int post[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };

		int size = pre.length;
		Node root = constructTree(pre, post, size);

		System.out.println("Inorder traversal of the constructed tree:");
		printInorder(root);
	}
}
