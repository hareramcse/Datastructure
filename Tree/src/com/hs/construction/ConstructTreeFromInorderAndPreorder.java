package com.hs.construction;

public class ConstructTreeFromInorderAndPreorder {
	int index;

	int search(int[] in, int start, int end, int data) {
		int i;
		for (i = start; i <= end; i++) {
			if (in[i] == data)
				break;
		}
		return i;
	}

	Node constructTree(int[] in, int[] pre, int start, int end) {
		if (start > end)
			return null;

		Node root = new Node(pre[index++]);

		// if node has no child
		if (start == end)
			return root;

		int index = search(in, start, end, root.data);

		root.left = constructTree(in, pre, start, index - 1);
		root.right = constructTree(in, pre, index + 1, end);

		return root;

	}

	void printInorder(Node root) {
		if (root == null)
			return;
		printInorder(root.left);
		System.out.println(root.data);
		printInorder(root.right);
	}

	public static void main(String[] args) {
		int in[] = { 4, 2, 5, 1, 3, 6 };
		int pre[] = { 1, 2, 4, 5, 3, 6 };

		ConstructTreeFromInorderAndPreorder ctfiap = new ConstructTreeFromInorderAndPreorder();
		Node root = ctfiap.constructTree(in, pre, 0, in.length - 1);
		ctfiap.printInorder(root);
	}
}