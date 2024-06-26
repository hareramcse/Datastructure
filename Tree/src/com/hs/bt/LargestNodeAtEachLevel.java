package com.hs.bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hs.tree.Node;

public class LargestNodeAtEachLevel {
	public List<Integer> largestValueInEachLevel(Node root) {
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < levelSize; i++) {
				Node temp = queue.poll();
				max = Math.max(max, temp.data);

				// Enqueue left child
				if (temp.left != null) {
					queue.add(temp.left);
				}

				// Enqueue right child
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
			list.add(max);
		}
		return list;
	}

	public static void main(String[] args) {
		LargestNodeAtEachLevel tree = new LargestNodeAtEachLevel();
		Node root = new Node(4);
		root.left = new Node(9);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.right = new Node(7);

		List<Integer> list = tree.largestValueInEachLevel(root);
		System.out.println(list);
	}
}