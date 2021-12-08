package com.hs.heap;

import java.util.LinkedList;
import java.util.Queue;

public class IsBinaryTreeAHeap {

	// Tree node structure
	private static class Node {
		int data;
		Node left;
		Node right;
	};

	// To add a new node
	private static Node newNode(int k) {
		Node node = new Node();
		node.data = k;
		node.right = node.left = null;
		return node;
	}

	private boolean isHeap(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		boolean nullish = false;
		while (!q.isEmpty()) {
			Node temp = q.peek();
			q.remove();
			if (temp.left != null) {
				if (nullish || temp.left.data >= temp.data) {
					return false;
				}
				q.add(temp.left);
			} else {
				nullish = true;
			}
			if (temp.right != null) {
				if (nullish || temp.right.data >= temp.data) {
					return false;
				}
				q.add(temp.right);
			} else {
				nullish = true;
			}
		}
		return true;
	}

	// Driver code
	public static void main(String[] args) {
		IsBinaryTreeAHeap array = new IsBinaryTreeAHeap();
		Node root = null;
		root = newNode(10);
		root.left = newNode(9);
		root.right = newNode(8);
		root.left.left = newNode(7);
		root.left.right = newNode(6);
		root.right.left = newNode(5);
		root.right.right = newNode(4);
		root.left.left.left = newNode(3);
		root.left.left.right = newNode(2);
		root.left.right.left = newNode(1);

		// Function call
		if (array.isHeap(root))
			System.out.print("Given binary tree is a Heap\n");
		else
			System.out.print("Given binary tree is not a Heap\n");
	}

}