package com.hs.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int val) {
			this.val = val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int val, ArrayList<Node> neighbors) {
			this.val = val;
			this.neighbors = neighbors;
		}
	}

	public Node cloneGraph(Node node) {
		Map<Node, Node> map = new HashMap<>();
		return dfs(node, map);
	}

	private Node dfs(Node node, Map<Node, Node> map) {
		if (node == null) {
			return null;
		}

		if (map.containsKey(node)) {
			return map.get(node);
		}

		Node copy = new Node(node.val);
		map.put(node, copy);

		for (Node adjNode : node.neighbors) {
			copy.neighbors.add(dfs(adjNode, map));
		}

		return copy;
	}
}
