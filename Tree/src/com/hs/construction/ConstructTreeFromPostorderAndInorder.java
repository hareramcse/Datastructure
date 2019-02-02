package com.hs.construction;

public class ConstructTreeFromPostorderAndInorder {
	Node root;
	int index;

	/*
	 * Function to find index of value in arr[start...end] The function assumes that
	 * value is postsent in in[]
	 */
	int search(int in[], int strt, int end, int value) {
		int i;
		for (i = strt; i <= end; i++) {
			if (in[i] == value)
				break;
		}
		return i;
	}

	/*
	 * Recursive function to construct binary of size n from Inorder traversal in[]
	 * and Postorder traversal post[]. Initial values of inStrt and inEnd should be
	 * 0 and n -1. The function doesn't do any error checking for cases where
	 * inorder and postorder do not form a tree
	 */
	Node buildTree(int in[], int post[], int start, int end, int pIndex) {
		// Base case
		if (start > end)
			return null;

		/*
		 * Pick current node from Post order traversal using postIndex and decrement
		 * postIndex
		 */
		Node root = new Node(post[index--]);

		/* If this node has no children then return */
		if (start == end)
			return root;

		/*
		 * Else find the index of this node in Inorder traversal
		 */
		int index = search(in, start, end, root.data);

		/*
		 * Using index in Inorder traversal, construct left and right subtress
		 */
		root.right = buildTree(in, post, index + 1, end, pIndex);
		root.left = buildTree(in, post, start, index - 1, pIndex);

		return root;
	}

	/* This funtcion is here just to test */
	void preOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void main(String[] args) {
		ConstructTreeFromPostorderAndInorder tree = new ConstructTreeFromPostorderAndInorder();
		int in[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 };
		int post[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 };
		int n = in.length;
		tree.index = n - 1;
		tree.root = tree.buildTree(in, post, 0, n - 1, tree.index);
		System.out.println("Preorder of the constructed tree : ");
		tree.preOrder(tree.root);
	}
}