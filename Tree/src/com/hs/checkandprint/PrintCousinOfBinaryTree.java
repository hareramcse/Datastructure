package com.hs.checkandprint;

/*The idea to first find level of given node using the approach discussed here. Once we 
 * have found level, we can print all nodes at a given level using the approach discussed 
 * here. The only thing to take care of is, sibling should not be printed. To handle this, 
 * we change the printing function to first check for sibling and print node only if it 
 * is not sibling.
 * */
class PrintCousinOfBinaryTree {

	/*
	 * It returns level of the node if it is present in tree, otherwise returns 0.
	 */
	private int getLevel(Node root, Node node, int level) {
		// base cases
		if (root == null)
			return 0;
		if (root == node)
			return level;

		// If node is present in left subtree
		int downLevel = getLevel(root.left, node, level + 1);
		if (downLevel != 0)
			return downLevel;

		// If node is not present in left subtree
		return getLevel(root.right, node, level + 1);
	}

	/*
	 * Print nodes at a given level such that sibling of node is not printed if it
	 * exists
	 */
	private void printGivenLevel(Node root, Node node, int level) {
		// Base cases
		if (root == null || level < 2)
			return;

		// If current node is parent of a node with given level
		if (level == 2) {
			if (root.left == node || root.right == node)
				return;
			if (root.left != null)
				System.out.print(root.left.data + " ");
			if (root.right != null)
				System.out.print(root.right.data + " ");
		}

		// Recur for left and right subtrees
		else if (level > 2) {
			printGivenLevel(root.left, node, level - 1);
			printGivenLevel(root.right, node, level - 1);
		}
	}

	// This function prints cousins of a given node
	private void printCousins(Node root, Node node) {
		// Get level of given node
		int level = getLevel(root, node, 1);

		// Print nodes of given level.
		printGivenLevel(root, node, level);
	}

	// Driver Program to test above functions
	public static void main(String[] args) {
		PrintCousinOfBinaryTree tree = new PrintCousinOfBinaryTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.right = new Node(15);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);

		tree.printCousins(root, root.left.right);
	}
}