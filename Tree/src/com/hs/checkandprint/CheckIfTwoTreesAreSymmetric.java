package com.hs.checkandprint;

import com.hs.tree.Node;

/*For two trees �a� and �b� to be mirror images, the following three conditions must be 
 * true: 

Their root node�s key must be same
Left subtree of root of �a� and right subtree root of �b� are mirror.
Right subtree of �a� and left subtree of �b� are mirror.*/
class CheckIfTwoTreesAreSymmetric {

	public boolean isSymmetric(Node root) {
		return isSymmetricUtil(root.left, root.right);
    }
    
    private boolean isSymmetricUtil(Node a, Node b) {
		if (a == null || b == null)
			return a == b;

		return (a.data == b.data) && isSymmetricUtil(a.left, b.right) && isSymmetricUtil(a.right, b.left);
	}

	public static void main(String[] args) {
		CheckIfTwoTreesAreSymmetric tree = new CheckIfTwoTreesAreSymmetric();
		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		if (tree.isSymmetric(root))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}