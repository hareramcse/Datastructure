package com.hs.construction;

class ConstructTreeFromInorderAndLevelOrder {
	Node root;

	Node buildTree(int in[], int level[]) {
		Node startnode = null;
		return constructTree(startnode, level, in, 0, in.length - 1);
	}

	Node constructTree(Node startNode, int[] levelOrder, int[] inOrder, int inStart, int inEnd) {

		// if start index is more than end index
		if (inStart > inEnd)
			return null;

		if (inStart == inEnd)
			return new Node(inOrder[inStart]);

		boolean found = false;
		int index = 0;

		// it represents the index in inOrder array of element that
		// appear first in levelOrder array.
		for (int i = 0; i < levelOrder.length - 1; i++) {
			int data = levelOrder[i];
			for (int j = inStart; j < inEnd; j++) {
				if (data == inOrder[j]) {
					startNode = new Node(data);
					index = j;
					found = true;
					break;
				}
			}
			if (found == true)
				break;
		}

		// elements present before index are part of left child of startNode.
		// elements present after index are part of right child of startNode.
		startNode.setLeft(constructTree(startNode, levelOrder, inOrder, inStart, index - 1));
		startNode.setRight(constructTree(startNode, levelOrder, inOrder, index + 1, inEnd));

		return startNode;
	}

	/* Utility function to print inorder traversal of binary tree */
	void printInorder(Node node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	// Driver program to test the above functions
	public static void main(String args[]) {
		ConstructTreeFromInorderAndLevelOrder tree = new ConstructTreeFromInorderAndLevelOrder();
		int in[] = new int[] { 4, 8, 10, 12, 14, 20, 22 };
		int level[] = new int[] { 20, 8, 22, 4, 12, 10, 14 };
		Node node = tree.buildTree(in, level);

		/* Let us test the built tree by printing Inorder traversal */
		System.out.print("Inorder traversal of the constructed tree is ");
		tree.printInorder(node);
	}
}