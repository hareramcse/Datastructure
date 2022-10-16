package com.hs.checkandprint;

import com.hs.tree.Node;

/* To identify if two trees are identical, we need to traverse both trees simultaneously, 
 * and while traversing we need to compare data and children of the trees. */
class CheckIfTwoTreesAreSame {

	private boolean identicalTrees(Node a, Node b) {
		if (a == null || b == null)
			return a == b;

		return (a.data == b.data) && identicalTrees(a.left, b.left) && identicalTrees(a.right, b.right);
	}

	public static void main(String[] args) {
		CheckIfTwoTreesAreSame tree = new CheckIfTwoTreesAreSame();

		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);

		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.left = new Node(4);
		root2.left.right = new Node(5);

		if (tree.identicalTrees(root1, root2))
			System.out.println("Both trees are identical");
		else
			System.out.println("Trees are not identical");

	}
}