package com.hs.traversal;

class MorrisTraversalForPreOrder {

	// Preorder traversal without recursion and without stack
	private void morrisTraversalPreorder(Node root) {
		while (root != null) {

			// If left child is null, print the current node data. Move to
			// right child.
			if (root.left == null) {
				System.out.print(root.data + " ");
				root = root.right;
			} else {

				// Find inorder predecessor
				Node current = root.left;
				while (current.right != null && current.right != root) {
					current = current.right;
				}

				// If the right child of inorder predecessor already points to
				// this node
				if (current.right == root) {
					current.right = null;
					root = root.right;
				}

				// If right child doesn't point to this node, then print this
				// node and make right child point to this node
				else {
					System.out.print(root.data + " ");
					current.right = root;
					root = root.left;
				}
			}
		}
	}

	// Function for Standard preorder traversal
	private void preorder(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}

	// Driver programs to test above functions
	public static void main(String args[]) {
		MorrisTraversalForPreOrder tree = new MorrisTraversalForPreOrder();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		tree.morrisTraversalPreorder(root);
		System.out.println("");
		tree.preorder(root);

	}
}