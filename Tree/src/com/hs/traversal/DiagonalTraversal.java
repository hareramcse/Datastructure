package com.hs.traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hs.tree.Node;

public class DiagonalTraversal {
	public List<List<Integer>> diagonalPrint(Node root) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		printDiagonal(root, map, 0);

		List<List<Integer>> list = new ArrayList<>();
		for (Integer key : map.keySet()) {
			list.add(map.get(key));
		}
		return list;
	}

	// root - root of the binary tree
	// d - distance of current line from rightmost topmost slope.
	// diagonalPrint - Map to store Diagonal elements
	private void printDiagonal(Node root, Map<Integer, List<Integer>> map, int d) {

		// Base case
		if (root == null)
			return;

		// get the list at the particular d value
		List<Integer> list = map.get(d);

		// if list is null then create a list and add data into it
		// else add the data into existing list
		if (list == null) {
			list = new ArrayList<>();
		}
		list.add(root.data);

		// Store all nodes of same line together as a list
		map.put(d, list);

		// Increase the vertical distance if left child
		printDiagonal(root.left, map, d + 1);

		// Vertical distance remains same for right child
		printDiagonal(root.right, map, d);
	}

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

		System.out.println("Diagonal Traversal of Binnary Tree");
		List<List<Integer>> list = tree.diagonalPrint(root);
		System.out.println(list);
	}
}