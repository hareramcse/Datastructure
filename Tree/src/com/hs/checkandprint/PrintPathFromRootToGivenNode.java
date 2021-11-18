package com.hs.checkandprint;

import java.util.ArrayList;
import java.util.List;

public class PrintPathFromRootToGivenNode {
	// function to print the path from root to the
	// given node if the node lies in the binary tree
	private void printPath(Node root, int x) {
		// ArrayList to store the path
		List<Integer> list = new ArrayList<>();

		// if required node 'x' is present then print the path
		if (hasPath(root, list, x)) {
			for (int i = 0; i < list.size() - 1; i++)
				System.out.print(list.get(i) + "->");
			System.out.print(list.get(list.size() - 1));
		}

		// 'x' is not present in the binary tree
		else
			System.out.print("No Path");
	}

	// Returns true if there is a path from root to the given node.
	// It also populates 'arr' with the given path
	private boolean hasPath(Node root, List<Integer> list, int x) {
		// if root is NULL there is no path
		if (root == null)
			return false;

		// push the node's value in 'list'
		list.add(root.data);

		// if it is the required node return true
		if (root.data == x)
			return true;

		// else check whether the required node lies
		// in the left subtree or right subtree of the current node
		if (hasPath(root.left, list, x) || hasPath(root.right, list, x))
			return true;

		// required node does not lie either in the
		// left or right subtree of the current node
		// Thus, remove current node's value from
		// 'list then return false
		list.remove(list.size() - 1);
		return false;
	}

	public static void main(String args[]) {
		PrintPathFromRootToGivenNode tree = new PrintPathFromRootToGivenNode();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		int x = 5;
		tree.printPath(root, x);
	}
}