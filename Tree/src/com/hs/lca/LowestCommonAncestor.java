package com.hs.lca;

import com.hs.tree.Node;

public class LowestCommonAncestor {

	public Node lowestCommonAncestor(Node root, Node a, Node b) {
		if (root == null)
			return null;

		if (root == a || root == b)
			return root;

		Node left = lowestCommonAncestor(root.left, a, b);
		Node right = lowestCommonAncestor(root.right, a, b);

		if (left == null) {
			return right;
		} else if (right == null) {
			return left;
		} else { // both left and right are not null, we found our result
			return root;
		}
	}

	public static void main(String args[]) {
		LowestCommonAncestor tree = new LowestCommonAncestor();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		Node lca = tree.lowestCommonAncestor(root, root.left.left, root.left.right);
		if (lca != null)
			System.out.println("LCA(4, 5) = " + lca.data);
		else
			System.out.println("Keys are not present");

		lca = tree.lowestCommonAncestor(root, root.left.left, new Node(10));
		if (lca != null)
			System.out.println("LCA(4, 10) = " + lca.data);
		else
			System.out.println("Keys are not present");
	}
}