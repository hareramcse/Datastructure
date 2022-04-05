package com.hs.dp.bt;

class MaximumPathSum {
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

		int temp = Math.max(Math.max(left, right) + root.data, root.data);
		int ans = Math.max(temp,  left + right + root.data);
		res.val = Math.max(res.val, ans);
		return temp;
	}

	public static void main(String[] args) {
		MaximumPathSum tree = new MaximumPathSum();
		Node root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(10);
		root.left.left = new Node(20);
		root.left.right = new Node(1);
		root.right.right = new Node(-25);
		root.right.right.left = new Node(3);
		root.right.right.right = new Node(4);
		System.out.println("Maximum path sum is : " + tree.pathSum(root));
	}
}