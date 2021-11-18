package com.hs.checkandprint;

/* 
The idea is to first find the level of the leftmost leaf and store it in a variable 
leafLevel. Then compare level of all other leaves with leafLevel, if same, return true, 
else return false. We traverse the given Binary Tree in a Preorder fashion. An argument 
leaflevel is passed to all calls. The value of leafLevel is initialized as 0 to indicate
 that the first leaf is not yet seen yet. The value is updated when we find first leaf. 
 Level of subsequent leaves (in preorder) is compared with leafLevel. */

// O(n)
class Leaf {
	int firstTimeLeafLevel = 0;
}

class CheckIfAllLeavesAreAtSameLevel {

	private Leaf leaf = new Leaf();

	/* The main function to check if all leafs are at same level. */
	private boolean check(Node root) {
		int level = 0;
		return checkUtil(root, level, leaf);
	}

	// Recursive function which checks whether all leaves are at same level
	private boolean checkUtil(Node root, int level, Leaf leaf) {
		// Base case
		if (root == null)
			return true;

		// If a leaf node is encountered
		if (root.left == null && root.right == null) {
			// When a leaf node is found first time
			if (leaf.firstTimeLeafLevel == 0) {
				// Set first found leaf's level
				leaf.firstTimeLeafLevel = level;
				return true;
			}

			// If this is not first leaf node, compare its level with first leaf's level
			return (leaf.firstTimeLeafLevel == level);
		}

		// If this node is not leaf, recursively check left and right subtrees
		return checkUtil(root.left, level + 1, leaf) && checkUtil(root.right, level + 1, leaf);
	}

	public static void main(String args[]) {
		// Let us create the tree as shown in the example
		CheckIfAllLeavesAreAtSameLevel tree = new CheckIfAllLeavesAreAtSameLevel();
		Node root = new Node(12);
		root.left = new Node(5);
		root.left.left = new Node(3);
		root.left.right = new Node(9);
		root.left.left.left = new Node(1);
		root.left.right.left = new Node(1);
		if (tree.check(root))
			System.out.println("Leaves are at same level");
		else
			System.out.println("Leaves are not at same level");
	}
}