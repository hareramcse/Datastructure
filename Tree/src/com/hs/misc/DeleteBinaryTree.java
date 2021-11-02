package com.hs.misc;

class DeleteBinaryTree {

	private void deleteTree(Node root) {
		if (root == null) {
			return;
		}

		/* first delete both subtrees */
		deleteTree(root.left);
		deleteTree(root.right);

		/* then delete the node */
		System.out.println("The deleted node is " + root.data);
		root = null;
	}

	/* Driver program to test mirror() */
	public static void main(String[] args) {

		DeleteBinaryTree tree = new DeleteBinaryTree();

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		/* Print all root-to-leaf paths of the input tree */
		tree.deleteTree(root);
		root = null;
		System.out.println("Tree deleted");

	}
}
