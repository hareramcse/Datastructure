package com.hs.misc;

public class FindLevelOfNode {

	private int getLevelUtil(Node node, int data, int level) {
		if (node == null)
			return 0;

		if (node.data == data)
			return level;

		int downlevel = getLevelUtil(node.left, data, level + 1);
		if (downlevel != 0)
			return downlevel;

		downlevel = getLevelUtil(node.right, data, level + 1);
		return downlevel;
	}

	private int getLevel(Node node, int data) {
		return getLevelUtil(node, data, 1);
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