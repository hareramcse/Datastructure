package com.hs.introduction;

public class SymmetricTree {

	// returns true if trees with roots as root1 and root2 are mirror
	boolean isMirror(Node root1, Node root2) {
		// if both trees are empty, then they are mirror image
		if (root1 == null && root2 == null)
			return true;

		// For two trees to be mirror images, the following three
		// conditions must be true
		// 1 - Their root node's key must be same
		// 2 - left subtree of left tree and right subtree
		// of right tree have to be mirror images
		// 3 - right subtree of left tree and left subtree
		// of right tree have to be mirror images
		if (root1 != null && root2 != null && root1.data == root2.data)
			return (isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left));

		// if neither of the above conditions is true then
		// root1 and root2 are mirror images
		return false;
	}

	public static void main(String args[]) {
		SymmetricTree tree = new SymmetricTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(4);
		root.right.right = new Node(3);
		boolean output = tree.isMirror(root, root);
		if (output == true)
			System.out.println("true");
		else
			System.out.println("false");
	}
}