package com.hs.misc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.hs.tree.Node;

public class TimeToBurnTree {
	public int timeToBurnTree(Node root, int start) {
		Map<Node, Node> mpp = new HashMap<>();
		Node target = bfsToMapParents(root, mpp, start);
		int maxi = findMaxDistance(mpp, target);
		return maxi;
	}

	private Node bfsToMapParents(Node root, Map<Node, Node> mpp, int start) {
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		Node res = new Node(-1);
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.data == start)
				res = node;
			if (node.left != null) {
				mpp.put(node.left, node);
				q.offer(node.left);
			}
			if (node.right != null) {
				mpp.put(node.right, node);
				q.offer(node.right);
			}
		}
		return res;
	}

	private static int findMaxDistance(Map<Node, Node> mpp, Node target) {
		Queue<Node> q = new LinkedList<>();
		q.offer(target);
		Map<Node, Integer> vis = new HashMap<>();
		vis.put(target, 1);
		int maxi = 0;

		while (!q.isEmpty()) {
			int sz = q.size();
			int fl = 0;

			for (int i = 0; i < sz; i++) {
				Node node = q.poll();
				if (node.left != null && vis.get(node.left) == null) {
					fl = 1;
					vis.put(node.left, 1);
					q.offer(node.left);
				}
				if (node.right != null && vis.get(node.right) == null) {
					fl = 1;
					vis.put(node.right, 1);
					q.offer(node.right);
				}

				if (mpp.get(node) != null && vis.get(mpp.get(node)) == null) {
					fl = 1;
					vis.put(mpp.get(node), 1);
					q.offer(mpp.get(node));
				}
			}
			if (fl == 1)
				maxi++;
		}
		return maxi;
	}

}
