package com.hs.misc;

import java.util.LinkedList;
import java.util.Queue;

import com.hs.tree.Node;

public class MaximumWidthOfBinaryTree {
	public int widthOfBinaryTree(Node root) {
		if (root == null)
			return 0;

		int ans = 0;
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(root, 0));

		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			int mmin = queue.peek().hd;

			int first = 0, last = 0;
			for (int i = 0; i < levelSize; i++) {
				Pair curr = queue.poll();
				int cur_id = curr.hd - mmin; // to make the starting id from 0
				Node node = curr.node;

				if (i == 0)
					first = cur_id;

				if (i == levelSize - 1)
					last = cur_id;

				if (node.left != null)
					queue.offer(new Pair(node.left, cur_id * 2 + 1));

				if (node.right != null)
					queue.offer(new Pair(node.right, cur_id * 2 + 2));
			}
			ans = Math.max(ans, last - first + 1);
		}
		return ans;
	}

	public static void main(String[] args) {
		MaximumWidthOfBinaryTree obj = new MaximumWidthOfBinaryTree();
		Node root = new Node(1);
		root.left = new Node(3);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.right = new Node(2);
		root.right.right = new Node(9);

		int result = obj.widthOfBinaryTree(root);
		System.out.println(result);
	}
}