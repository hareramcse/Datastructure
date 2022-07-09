package com.hs.traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraversal {

	// root - root of the binary tree
	// d - distance of current line from rightmost topmost slope.
	// diagonalPrint - Map to store Diagonal elements
	public void printDiagonal(Node root, Map<Integer, List<Integer>> map, int d) {

		// Base case
		if (root == null)
			return;

		// get the list at the particular d value
		List<Integer> list = map.get(d);

		// if list is null then create a list and add data into it
		// else add the data into existing list
		if (list == null) {
			list = new ArrayList<>();
			list.add(root.data);
		} else {
			list.add(root.data);
		}

		// Store all nodes of same line together as a list
		map.put(d, list);

		// Increase the vertical distance if left child
		printDiagonal(root.left, map, d + 1);

		// Vertical distance remains same for right child
		printDiagonal(root.right, map, d);
	}

	// Print diagonal traversal of given binary tree
	private void diagonalPrint(Node root) {
		// create a map of list to store Diagonal elements
		Map<Integer, List<Integer>> map = new HashMap<>();
		printDiagonal(root, map, 0);

		System.out.println("Diagonal Traversal of Binnary Tree");
		System.out.println(map.values());
	}

	// Driver program
	public static void main(String[] args) {
		DiagonalTraversal tree = new DiagonalTraversal();
		Node root = new Node(8);
		root.left = new Node(3);
		root.right = new Node(10);
		root.left.left = new Node(1);
		root.left.right = new Node(6);
		root.right.right = new Node(14);
		root.right.right.left = new Node(13);
		root.left.right.left = new Node(4);
		root.left.right.right = new Node(7);

		tree.diagonalPrint(root);
	}
}