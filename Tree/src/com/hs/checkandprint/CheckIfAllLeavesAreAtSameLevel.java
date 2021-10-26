package com.hs.checkandprint;

/* 
 *        12
        /    \
      5       7       
    /          \ 
   3            1
   
  Leaves are at same level
 * */
class Leaf {
	int leafLevel = 0;
}

class CheckIfAllLeavesAreAtSameLevel {

	private Leaf mylevel = new Leaf();
	
	/* The main function to check if all leafs are at same level. */
	private boolean check(Node root) {
		int level = 0;
		return checkUtil(root, level, mylevel);
	}

	/*
	 * Recursive function which checks whether all leaves are at same level
	 */
	private boolean checkUtil(Node root, int level, Leaf leafLevel) {
		// Base case
		if (root == null)
			return true;

		// If a leaf node is encountered
		if (root.left == null && root.right == null) {
			// When a leaf node is found first time
			if (leafLevel.leafLevel == 0) {
				// Set first found leaf's level
				leafLevel.leafLevel = level;
				return true;
			}

			// If this is not first leaf node, compare its level with first leaf's level
			return (level == leafLevel.leafLevel);
		}

		// If this node is not leaf, recursively check left and right subtrees
		return checkUtil(root.left, level + 1, leafLevel) && checkUtil(root.right, level + 1, leafLevel);
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