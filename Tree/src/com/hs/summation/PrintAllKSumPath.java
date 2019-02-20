package com.hs.summation;

import java.util.Stack;
import java.util.Vector;

public class PrintAllKSumPath {

	// This function prints all paths that have sum k
	void printKPathUtil(Node root, Stack<Integer> path, int k) {
		// empty node
		if (root == null)
			return;

		// add current node to the path
		path.push(root.data);

		// check if there's any k sum path
		// in the left sub-tree.
		printKPathUtil(root.left, path, k);

		// check if there's any k sum path
		// in the right sub-tree.
		printKPathUtil(root.right, path, k);

		// check if there's any k sum path that
		// terminates at this node
		// Traverse the entire path as
		// there can be negative elements too
		int f = 0;
		for (int j = path.size() - 1; j >= 0; j--) {
			f += path.get(j);

			// If path sum is k, print the path
			if (f == k)
				printVector(path, j);
		}

		// Remove the current element from the path
		path.pop();
	}

	// A wrapper over printKPathUtil()
	void printKPath(Node root, int k) {
		Stack<Integer> path = new Stack<>();
		printKPathUtil(root, path, k);
	}

	void printVector(Vector<Integer> v, int i) {
		for (int j = i; j < v.size(); j++)
			System.out.print(v.get(j) + " ");
		System.out.println();
	}

	// Driver code
	public static void main(String[] args) {

		PrintAllKSumPath tree = new PrintAllKSumPath();

		Node root = new Node(1);
		root.left = new Node(3);
		root.left.left = new Node(2);
		root.left.right = new Node(1);
		root.left.right.left = new Node(1);
		root.right = new Node(-1);
		root.right.left = new Node(4);
		root.right.left.left = new Node(1);
		root.right.left.right = new Node(2);
		root.right.right = new Node(5);
		root.right.right.right = new Node(2);

		int k = 5;
		tree.printKPath(root, k);

	}
}
