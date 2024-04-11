package com.hs.bt;

import com.hs.tree.Node;

class ConvertBinaryTreeToSumTree {
	public void sumTree(Node root){
		sumTreeHelper(root);
   }
   
   private int sumTreeHelper(Node root){
       if(root == null)
           return 0;
       
       int left = sumTreeHelper(root.left);
       int right = sumTreeHelper(root.right);
       
       int rootData = root.data;
       root.data = left + right;
       return left + right + rootData;
   }

	private void printPreorder(Node root) {
		if (root == null)
			return;
		
		System.out.print(root.data + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}

	public static void main(String args[]) {
		ConvertBinaryTreeToSumTree tree = new ConvertBinaryTreeToSumTree();

		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

		tree.sumTree(root);

		System.out.println("Inorder Traversal of the resultant tree is:");
		tree.printPreorder(root);
	}
}