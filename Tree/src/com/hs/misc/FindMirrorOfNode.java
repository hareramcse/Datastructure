package com.hs.misc;

public class FindMirrorOfNode {
	private static int findMirror(Node root, int target) {
		if (root == null)
			return 0;
		if (root.data == target)
			return target;
		return findMirrorRec(target, root.left, root.right);
	}

	private static int findMirrorRec(int target, Node left, Node right) {

		if (left == null || right == null)
			return 0;

		/*
		 * if left Node is target Node, then return right's key (that is mirror) and
		 * vice versa
		 */
		if (left.data == target)
			return right.data;

		if (right.data == target)
			return left.data;

		// first recur external Nodes
		int mirror_val = findMirrorRec(target, left.left, right.right);
		if (mirror_val != 0)
			return mirror_val;

		// if no mirror found, recur internal Nodes
		return findMirrorRec(target, left.right, right.left);
	}

	// Driver
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.left.right = new Node(7);
		root.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(8);
		root.right.left.right = new Node(9);

		// target Node whose mirror have to be searched
		int target = root.left.left.data;

		int mirror = findMirror(root, target);

		if (mirror != 0)
			System.out.println("Mirror of Node " + target + " is Node " + mirror);
		else
			System.out.println("Mirror of Node " + target + " is null ");
	}
}