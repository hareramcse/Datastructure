package com.hs.random;

public class VerticalSumDLL {

	// Doubly Linked List Node
	static class LLNode {
		int data;
		LLNode prev, next;

		public LLNode(int d) {
			data = d;
		}
	}

	// Binary Tree Node
	static class TNode {
		int data;
		TNode left, right;

		public TNode(int d) {
			data = d;
		}
	}

	// Prints vertical sum of different vertical
	// lines in tree. This method mainly uses
	// verticalSumDLLUtil().
	static void verticalSumDLL(TNode root) {
		// Create a doubly linked list node to
		// store sum of lines going through root.
		// Vertical sum is initialized as 0.
		LLNode llnode = new LLNode(0);

		// Compute vertical sum of different lines
		verticalSumDLLUtil(root, llnode);

		// llnode refers to sum of vertical line
		// going through root. Move llnode to the
		// leftmost line.
		while (llnode.prev != null)
			llnode = llnode.prev;

		// Prints vertical sum of all lines starting
		// from leftmost vertical line
		while (llnode != null) {
			System.out.print(llnode.data + " ");
			llnode = llnode.next;
		}
	}

	// Constructs linked list
	static void verticalSumDLLUtil(TNode tnode, LLNode llnode) {
		// Add current node's data to its vertical line
		llnode.data = llnode.data + tnode.data;

		// Recursively process left subtree
		if (tnode.left != null) {
			if (llnode.prev == null) {
				llnode.prev = new LLNode(0);
				llnode.prev.next = llnode;
			}
			verticalSumDLLUtil(tnode.left, llnode.prev);
		}

		// Process right subtree
		if (tnode.right != null) {
			if (llnode.next == null) {
				llnode.next = new LLNode(0);
				llnode.next.prev = llnode;
			}
			verticalSumDLLUtil(tnode.right, llnode.next);
		}
	}

	// Driver code
	public static void main(String[] args) {
		// Let us construct the tree shown above
		TNode root = new TNode(1);
		root.left = new TNode(2);
		root.right = new TNode(3);
		root.left.left = new TNode(4);
		root.left.right = new TNode(5);
		root.right.left = new TNode(6);
		root.right.right = new TNode(7);

		System.out.println("Vertical Sums are");
		verticalSumDLL(root);
	}

}
