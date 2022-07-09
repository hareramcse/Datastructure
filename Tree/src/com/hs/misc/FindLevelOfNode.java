package com.hs.misc;

public class FindLevelOfNode {
	private int getLevel(Node root, int data) {
		return getLevelUtil(root, data, 1);
	}

	private int getLevelUtil(Node root, int data, int level) {
		if (root == null)
			return 0;

		if (root.data == data)
			return level;

		int leftLevel = getLevelUtil(root.left, data, level + 1);
		if (leftLevel != 0)
			return leftLevel;

		return getLevelUtil(root.right, data, level + 1);
	}

	public static void main(String[] args) {
		FindLevelOfNode tree = new FindLevelOfNode();

		Node root = new Node(3);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		for (int x = 1; x <= 5; x++) {
			int level = tree.getLevel(root, x);
			if (level != 0)
				System.out.println("Level of " + x + " is " + tree.getLevel(root, x));
			else
				System.out.println(x + " is not present in tree");
		}
	}
}