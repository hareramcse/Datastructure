package com.hs.bt;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import com.hs.tree.Node;

public class SerializeAndDeserialize {
	private String spliter = ",";
	private String NN = "X";

	// Encodes a tree to a single string.
	public String serialize(Node root) {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}

	private void buildString(Node node, StringBuilder sb) {
		if (node == null) {
			sb.append(NN).append(spliter);
		} else {
			sb.append(node.data).append(spliter);
			buildString(node.left, sb);
			buildString(node.right, sb);
		}
	}

	// Decodes your encoded data to tree.
	public Node deserialize(String data) {
		Deque<String> nodes = new LinkedList<>();
		nodes.addAll(Arrays.asList(data.split(spliter)));
		return buildTree(nodes);
	}

	private Node buildTree(Deque<String> nodes) {
		String val = nodes.remove();
		if (val.equals(NN))
			return null;

		Node root = new Node(Integer.valueOf(val));
		root.left = buildTree(nodes);
		root.right = buildTree(nodes);
		return root;
	}
}