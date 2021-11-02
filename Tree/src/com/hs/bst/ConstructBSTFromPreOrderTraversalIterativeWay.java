package com.hs.bst;

import java.util.Stack;

public class ConstructBSTFromPreOrderTraversalIterativeWay {

	private Node constructTree(int pre[], int size) {

		// The first element of pre[] is always root
		Node root = new Node(pre[0]);

		Stack<Node> s = new Stack<Node>();

		// Push root
		s.push(root);

		// Iterate through rest of the size-1 items of given preorder array
		for (int i = 1; i < size; ++i) {
			Node temp = null;

			// Keep on popping while the next value is greater than stack's top value.
			while (!s.isEmpty() && pre[i] > s.peek().data) {
				temp = s.pop();
			}

			// Make this greater value as the right child and push it to the stack
			if (temp != null) {
				temp.right = new Node(pre[i]);
				s.push(temp.right);
			}

			// If the next value is less than the stack's top value, make this value
			// as the left child of the stack's top node. Push the new node to stack
			else {
				temp = s.peek();
				temp.left = new Node(pre[i]);
				s.push(temp.left);
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

	public static void main(String[] args) {
		ConstructBSTFromPreOrderTraversalIterativeWay tree = new ConstructBSTFromPreOrderTraversalIterativeWay();
		int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
		int size = pre.length;
		Node root = tree.constructTree(pre, size);
		System.out.println("Inorder traversal of the constructed tree is ");
		tree.printInorder(root);
	}
}