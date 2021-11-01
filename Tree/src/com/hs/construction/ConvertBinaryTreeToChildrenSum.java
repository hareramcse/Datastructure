package com.hs.construction;

/*Algorithm: 
Traverse the given tree in post order to convert it, i.e., first change left and right 
children to hold the children sum property then change the parent node. 
Let difference between node’s data and children sum be diff. 

If diff is 0 then nothing needs to be done. 
If diff > 0 ( node’s data is smaller than node’s children sum) increment the node’s
data by diff.
If diff < 0 (node’s data is greater than the node’s children sum) then increment one 
child’s data. We can choose to increment either left or right child if they both are 
not NULL. Let us always first increment the left child. Incrementing a child changes 
the subtree’s children sum property so we need to change left subtree also. So we 
recursively increment the left child. If left child is empty then we recursively call 
increment() for right child.
*/

// O(n^2), Worst case complexity is for a skewed tree such that nodes are in decreasing order from root to leaf.
public class ConvertBinaryTreeToChildrenSum {

	// This function changes a tree to hold children sum property
	private void convertTree(Node root) {
		int left_data = 0, right_data = 0, diff;

		// If tree is empty or it's a leaf node then return true
		if (root == null || (root.left == null && root.right == null))
			return;
		else {
			/* convert left and right subtrees */
			convertTree(root.left);
			convertTree(root.right);

			// If left child is not present then 0 is used as data of left child
			if (root.left != null)
				left_data = root.left.data;

			// If right child is not present then 0 is used as data of right child
			if (root.right != null)
				right_data = root.right.data;

			/* get the diff of node's data and children sum */
			diff = left_data + right_data - root.data;

			/* If node's children sum is greater than the node's data */
			if (diff > 0)
				root.data = root.data + diff;

			/*
			 * THIS IS TRICKY --> If node's data is greater than children sum, then
			 * increment subtree by diff
			 */
			if (diff < 0)
				// -diff is used to make diff positive
				increment(root, -diff);
		}
	}

	// This function is used to increment subtree by diff
	private void increment(Node root, int diff) {
		/* If left child is not NULL then increment it */
		if (root.left != null) {
			root.left.data = root.left.data + diff;

			// Recursively call to fix the descendants of node->left
			increment(root.left, diff);
		} else if (root.right != null) { // Else increment right child
			root.right.data = root.right.data + diff;

			// Recursively call to fix the descendants of node->right
			increment(root.right, diff);
		}
	}

	// Given a binary tree, printInorder() prints out its inorder traversal
	private void printInorder(Node node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	// Driver program to test above functions
	public static void main(String args[]) {
		ConvertBinaryTreeToChildrenSum tree = new ConvertBinaryTreeToChildrenSum();
		Node root = new Node(50);
		root.left = new Node(7);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(1);
		root.right.right = new Node(30);

		System.out.println("Inorder traversal before conversion is :");
		tree.printInorder(root);

		tree.convertTree(root);
		System.out.println("");

		System.out.println("Inorder traversal after conversion is :");
		tree.printInorder(root);

	}
}
