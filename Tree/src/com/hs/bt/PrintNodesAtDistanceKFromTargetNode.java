package com.hs.bt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.hs.tree.Node;

public class PrintNodesAtDistanceKFromTargetNode {
	public List<Integer> distanceK(Node root, Node target, int k) {
		Map<Node, Node> map = new HashMap<>();
		makeParents(root, map);

		Map<Node, Boolean> visited = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(target);
		visited.put(target, true);

		int current_level = 0;
		while (!queue.isEmpty()) {
			if (current_level == k)
				break;

			current_level++;
			int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				Node node = queue.poll();
				if (node.left != null && visited.get(node.left) == null) {
					visited.put(node.left, true);
					queue.add(node.left);
				}

				if (node.right != null && visited.get(node.right) == null) {
					visited.put(node.right, true);
					queue.add(node.right);
				}

				if (map.get(node) != null && visited.get(map.get(node)) == null) {
					visited.put(map.get(node), true);
					queue.add(map.get(node));
				}
			}
		}

		List<Integer> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			result.add(queue.poll().data);
		}
		return result;
	}

	private void makeParents(Node root, Map<Node, Node> map) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.left != null) {
				map.put(node.left, node);
				queue.add(node.left);
			}

			if (node.right != null) {
				map.put(node.right, node);
				queue.add(node.right);
			}
		}
	}
}