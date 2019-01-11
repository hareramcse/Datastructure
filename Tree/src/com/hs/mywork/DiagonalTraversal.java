package com.hs.mywork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraversal {
	Node root;

	void diagonalPrintUtil(Node root, Map<Integer, List<Integer>> map, int dno) {
		if (root == null) {
			return;
		}

		List<Integer> list = map.get(dno);
		if (list == null) {
			list = new ArrayList<Integer>();
			list.add(root.data);
		} else {
			list.add(root.data);
		}

		map.put(dno, list);

		diagonalPrintUtil(root.left, map, dno + 1);
		diagonalPrintUtil(root.right, map, dno);
	}

	void diagonalPrint(Node root) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		diagonalPrintUtil(root, map, 0);

		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	public static void main(String[] args) {
		DiagonalTraversal tree = new DiagonalTraversal();
		tree.root = new Node(8);
		tree.root.left = new Node(3);
		tree.root.right = new Node(10);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(6);
		tree.root.right.right = new Node(14);
		tree.root.right.right.left = new Node(13);
		tree.root.left.right.left = new Node(4);
		tree.root.left.right.right = new Node(7);

		tree.diagonalPrint(tree.root);
	}
}
