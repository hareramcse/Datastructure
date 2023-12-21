package com.hs.bst.seelater;

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

	// the next smallest number
	public int next() {
		Node temp = stack.pop();
		pushAll(temp.right);
		return temp.data;
	}

	private void pushAll(Node node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}
}