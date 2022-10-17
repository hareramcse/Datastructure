package com.hs.bst;

import java.util.Stack;

import com.hs.tree.Node;

public class BSTIterator {
	private Stack<Node> stack = new Stack<>();

	public BSTIterator(Node root) {
		pushAll(root);
	}

	// return whether we have a next smallest number
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	// @return the next smallest number
	public int next() {
		Node tmpNode = stack.pop();
		pushAll(tmpNode.right);
		return tmpNode.data;
	}

	private void pushAll(Node node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}
}
