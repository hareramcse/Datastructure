package com.hs.dp.bt;

class DiameterOfBinaryTree {
	class A {
		int val = Integer.MIN_VALUE;
	}

	private int diameter(Node root) {
		A res = new A();
		solve(root, res);
		return res.val;
	}

	private int solve(Node root, A res) {
		if (root == null) {
			return 0;
		}
		int l = solve(root.left, res);
		int r = solve(root.right, res);

		int temp = 1 + Math.max(l, r);
		int ans = Math.max(temp, 1 + r + l);
		res.val = Math.max(res.val, ans);
		return temp;
	}

	public static void main(String[] args) {
		DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("Diameter is " + tree.diameter(root));
	}
}