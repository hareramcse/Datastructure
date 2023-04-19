package com.hs.checkandprint;

import java.util.ArrayList;
import java.util.List;

import com.hs.tree.Node;

class PrintAllNodeAtDistanceK {
	public List<Integer> Kdistance(Node root, int k) {
		List<Integer> result = new ArrayList<>();
		Kdistance(root, k, result);
		return result;
	}

	private void Kdistance(Node root, int k, List<Integer> result) {
		if (root == null)
			return;

		if (k == 0) {
			result.add(root.data);
		}

		Kdistance(root.left, k - 1, result);
		Kdistance(root.right, k - 1, result);
	}

	public static void main(String args[]) {
		PrintAllNodeAtDistanceK tree = new PrintAllNodeAtDistanceK();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(8);

		List<Integer> result = tree.Kdistance(root, 2);
		System.out.println(result);
	}
}