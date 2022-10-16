package com.hs.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hs.tree.Node;

class LevelOrderTraversalInSpiralForm2 {
	public List<List<Integer>> zigZagTraversal(Node root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		boolean ltr = false;
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> subList = new ArrayList<>();
			for (int i = 0; i < levelSize; i++) {
				Node tempNode = queue.poll();
				subList.add(tempNode.data);

				// Enqueue left child
				if (tempNode.left != null) {
					queue.add(tempNode.left);
				}

				// Enqueue right child
				if (tempNode.right != null) {
					queue.add(tempNode.right);
				}
			}
			if (ltr) {
				Collections.reverse(subList);
			}
			list.add(subList);
			ltr = !ltr;
		}
		return list;
	}

	public static void main(String[] args) {
		LevelOrderTraversalInSpiralForm2 tree = new LevelOrderTraversalInSpiralForm2();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(4);
		System.out.println("Spiral order traversal of Binary Tree is ");
		List<List<Integer>> list = tree.zigZagTraversal(root);
		System.out.println(list);
	}
}