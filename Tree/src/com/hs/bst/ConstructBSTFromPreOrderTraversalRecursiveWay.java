package com.hs.bst;

class Index {
	int index = 0;
}

public class ConstructBSTFromPreOrderTraversalRecursiveWay {

	Index index = new Index();

	private Node constructTree(int pre[], int size) {
		return constructTreeUtil(pre, index, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
	}

	// A recursive function to construct BST from pre[]. preIndex is used
	// to keep track of index in pre[].
	private Node constructTreeUtil(int pre[], Index preIndex, int key, int min, int max, int size) {

		// Base case
		if (preIndex.index >= size) {
			return null;
		}

		Node root = null;

		// If current element of pre[] is in range, then
		// only it is part of current subtree
		if (key > min && key < max) {

			// Allocate memory for root of this subtree and increment *preIndex
			root = new Node(key);
			preIndex.index = preIndex.index + 1;

			if (preIndex.index < size) {

				// Contruct the subtree under root
				// All nodes which are in range {min .. key} will go in left
				// subtree, and first such node will be root of left subtree.
				root.left = constructTreeUtil(pre, preIndex, pre[preIndex.index], min, key, size);

				// All nodes which are in range {key..max} will go in right
				// subtree, and first such node will be root of right subtree.
				root.right = constructTreeUtil(pre, preIndex, pre[preIndex.index], key, max, size);
			}
		}

		return root;
	}

	// A utility function to print inorder traversal of a Binary Tree
	private void printInorder(Node node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		ConstructBSTFromPreOrderTraversalRecursiveWay tree = new ConstructBSTFromPreOrderTraversalRecursiveWay();
		int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
		int size = pre.length;
		Node root = tree.constructTree(pre, size);
		System.out.println("Inorder traversal of the constructed tree is ");
		tree.printInorder(root);
	}
}