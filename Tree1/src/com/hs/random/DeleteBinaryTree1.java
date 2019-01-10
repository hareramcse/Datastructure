package com.hs.random;

class DeleteBinaryTree1 {

	static Node root;

	/* Wrapper function that deletes the tree and sets root node as null */
	void deleteTreeRef(Node nodeRef) {
		deleteTree(nodeRef);
		nodeRef = null;
	}

	/* This function is same as deleteTree() in the previous program */
	void deleteTree(Node node) {
		if (node == null) {
			return;
		}

		/* first delete both subtrees */
		deleteTree(node.left);
		deleteTree(node.right);

		/* then delete the node */
		System.out.println("The deleted node is " + node.data);
		node = null;
	}

	/* Driver program to test deleteTree function */
	public static void main(String[] args) {

		DeleteBinaryTree1 tree = new DeleteBinaryTree1();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		/* Note that we pass root node here */
		tree.deleteTreeRef(root);
		System.out.println("Tree deleted");

	}
}
