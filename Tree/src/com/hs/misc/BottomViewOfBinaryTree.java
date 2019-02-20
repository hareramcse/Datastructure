package com.hs.misc;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {

	class Pair {
		int value;
		int level;

		public Pair(int value, int level) {
			this.value = value;
			this.level = level;
		}
	}

	private void printBottomViewUtil(Node currentNode, int currLevel, int hd, Map<Integer, Pair> map) {
		if (currentNode == null)
			return;

		Pair entry = map.get(hd);

		if (entry != null) {

			if (currLevel >= entry.level) {
				Pair nodeEntry = new Pair(currentNode.data, currLevel);
				map.put(hd, nodeEntry);
			}
		} else {
			Pair nodeEntry = new Pair(currentNode.data, currLevel);
			map.put(hd, nodeEntry);
		}

		printBottomViewUtil(currentNode.left, currLevel + 1, hd - 1, map);

		printBottomViewUtil(currentNode.right, currLevel + 1, hd + 1, map);
	}

	private void printBottomView(Node root) {
		Map<Integer, Pair> map = new TreeMap<>();

		printBottomViewUtil(root, 0, 0, map);

		Iterator<Entry<Integer, Pair>> iterator = map.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry<Integer, Pair> entry = iterator.next();
			System.out.print(entry.getValue().value + " ");
		}
	}

	public static void main(String[] args) {
		BottomViewOfBinaryTree tree = new BottomViewOfBinaryTree();
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(25);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		tree.printBottomView(root);
	}
}