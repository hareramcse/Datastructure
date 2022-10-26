package com.hs.misc;

import java.util.LinkedList;
import java.util.Queue;

import com.hs.tree.Node;

public class SerializeAndDeserialize {
	public String serialize(Node root) {
		if (root == null)
			return "";

		StringBuilder res = new StringBuilder();
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node == null) {
				res.append("n ");
				continue;
			}
			res.append(node.data + " ");
			queue.add(node.left);
			queue.add(node.right);
		}
		return res.toString();
	}

	public Node deserialize(String data) {
		if (data == "")
			return null;

		Queue<Node> queue = new LinkedList<>();
		String[] values = data.split(" ");
		Node root = new Node(Integer.parseInt(values[0]));
		queue.add(root);
		
		for (int i = 1; i < values.length; i++) {
			Node parent = queue.poll();
			if (!values[i].equals("n")) {
				Node left = new Node(Integer.parseInt(values[i]));
				parent.left = left;
				queue.add(left);
			}
			if (!values[++i].equals("n")) {
				Node right = new Node(Integer.parseInt(values[i]));
				parent.right = right;
				queue.add(right);
			}
		}
		return root;
	}
}