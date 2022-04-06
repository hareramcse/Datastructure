package com.hs.dp.bt;

class MaximumPathSumFromLeafNodeTOLeafNode {
	class A {
		int val = Integer.MIN_VALUE;
	}

	private int pathSum(Node root) {
		A res = new A();
		solve(root, res);
		return res.val;
	}

	private int solve(Node root, A res) {
		if (root == null) {
			return 0;
		}
		int left = solve(root.left, res);
		int right = solve(root.right, res);

		int temp = Math.max(left, right) + root.data;
		int ans = Math.max(temp, left + right + root.data);
		res.val = Math.max(res.val, ans);
		return temp;
	}

	public static void main(String[] args) {
		MaximumPathSumFromLeafNodeTOLeafNode tree = new MaximumPathSumFromLeafNodeTOLeafNode();
		Node root = new Node(-15);
		root.left = new Node(5);
		root.right = new Node(6);
		root.left.left = new Node(-8);
		root.left.right = new Node(1);
		root.left.left.left = new Node(2);
		root.left.left.right = new Node(6);
		root.right.left = new Node(3);
		root.right.right = new Node(9);
		root.right.right.right = new Node(0);
		root.right.right.right.left = new Node(4);
		root.right.right.right.right = new Node(-1);
		root.right.right.right.right.left = new Node(10);
		System.out.println("Max pathSum of the given binary tree is " + tree.pathSum(root));
	}
}