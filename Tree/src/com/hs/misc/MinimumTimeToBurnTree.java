package com.hs.misc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.hs.tree.Node;

public class MinimumTimeToBurnTree {
	public int minTime(Node root, int start) {
		Map<Node, Node> map = new HashMap<>();
		Node target = bfsToMapParents(root, start, map);
		int maxi = findMaxDistance(map, target);
		return maxi;
	}

	private Node bfsToMapParents(Node root, int start, Map<Node, Node> map) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		Node res = new Node(-1);

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.data == start)
				res = node;

			if (node.left != null) {
				map.put(node.left, node);
				queue.add(node.left);
			}
			if (node.right != null) {
				map.put(node.right, node);
				queue.add(node.right);
			}
		}
		return res;
	}

	private int findMaxDistance(Map<Node, Node> map, Node target) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(target);
		Map<Node, Boolean> visited = new HashMap<>();
		visited.put(target, true);
		int minTime = 0;

		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			int flag = 0;

			for (int i = 0; i < levelSize; i++) {
				Node node = queue.poll();

				// this node can burn its left, right and parent node, check one by one
				if (node.left != null && visited.get(node.left) == null) {
					flag = 1;
					visited.put(node.left, true);
					queue.add(node.left);
				}
				if (node.right != null && visited.get(node.right) == null) {
					flag = 1;
					visited.put(node.right, true);
					queue.add(node.right);
				}
				if (map.get(node) != null && visited.get(map.get(node)) == null) {
					flag = 1;
					visited.put(map.get(node), true);
					queue.add(map.get(node));
				}
			}
			// if any of the node is burnt then increase the time
			if (flag == 1)
				minTime++;
		}
		return minTime;
	}
}