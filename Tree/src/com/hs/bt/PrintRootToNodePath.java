package com.hs.bt;

import java.util.ArrayList;
import java.util.List;

import com.hs.tree.Node;

public class PrintRootToNodePath {
	public List<Integer> printRootToNode(Node root, int target) {
		if (root == null) {
			return null;
		}
		
		List<Integer> result = new ArrayList<>();
		printRootToNodeUtil(root, target, result);
		return result;
	}

	private boolean printRootToNodeUtil(Node root, int target, List<Integer> result) {
		if (root == null)
			return false;

		result.add(root.data);
		if (root.data == target) {
			return true;
		}

		boolean left = printRootToNodeUtil(root.left, target, result);
		boolean right = printRootToNodeUtil(root.right, target, result);
		if (left || right) {
			return true;
		}
		result.remove(result.size() - 1);
		return false;
	}

	public static void main(String[] args) {
		PrintRootToNodePath tree = new PrintRootToNodePath();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		int x = 5;
		List<Integer> result = tree.printRootToNode(root, x);
		System.out.println(result);
	}
}
