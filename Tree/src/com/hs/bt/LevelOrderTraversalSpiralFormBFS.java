package com.hs.bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hs.tree.Node;

class LevelOrderTraversalSpiralFormBFS {
	public List<List<Integer>> zigZagTraversal(Node root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		boolean ltr = false;
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < levelSize; i++) {
				Node temp = queue.poll();
				if (ltr) {
					list.add(0, temp.data);
				} else {
					list.add(temp.data);
				}

				// Enqueue left child
				if (temp.left != null) {
					queue.add(temp.left);
				}

				// Enqueue right child
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
			result.add(list);
			ltr = !ltr;
		}
		return result;
	}

	public static void main(String[] args) {
		LevelOrderTraversalSpiralFormBFS tree = new LevelOrderTraversalSpiralFormBFS();
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