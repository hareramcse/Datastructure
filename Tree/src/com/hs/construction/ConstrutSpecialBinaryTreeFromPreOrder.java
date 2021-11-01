package com.hs.construction;

/* Given an array ‘pre[]’ that represents Preorder traversal of a special binary tree where every 
 * node has either 0 or 2 children. One more array ‘preLN[]’ is given which has only two possible 
 * values ‘L’ and ‘N’. The value ‘L’ in ‘preLN[]’ indicates that the corresponding node in Binary 
 * Tree is a leaf node and value ‘N’ indicates that the corresponding node is a non-leaf node. 
 * Write a function to construct the tree from the given two arrays.
 * */
class Index {

	int index = 0;
}

class ConstrutSpecialBinaryTreeFromPreOrder {

	private Index myindex = new Index();

	private Node constructTreeUtil(int pre[], char preLN[], Index index_ptr, int n, Node temp) {
		// store the current value of index in pre[]
		int index = index_ptr.index; 

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
	private Node constructTree(int pre[], char preLN[], int n, Node node) {
		return constructTreeUtil(pre, preLN, myindex, n, node);
	}

	/* This function is used only for testing */
	private void printInorder(Node node) {
		if (node == null) {
			return;
		}

		printInorder(node.left);
		System.out.print(node.data + " ");
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
