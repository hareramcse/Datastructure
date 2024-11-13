package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
	class Node {
		public int val;
		public List<Node> adjNodes;

		public Node(int val) {
			this.val = val;
			adjNodes = new ArrayList<>();
		}
	}

	public Node cloneGraph(Node node) {
		Map<Node, Node> map = new HashMap<>();
		return DFS(node, map);
	}

	private Node DFS(Node node, Map<Node, Node> map) {
		if (node == null) {
			return null;
		}

		if (map.containsKey(node)) {
			return map.get(node);
		}

		Node copy = new Node(node.val);
		map.put(node, copy);

		for (Node adjNode : node.adjNodes) {
			copy.adjNodes.add(DFS(adjNode, map));
		}

		return copy;
	}
}
