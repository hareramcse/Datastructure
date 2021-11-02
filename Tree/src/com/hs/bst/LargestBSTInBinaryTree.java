package com.hs.bst;

public class LargestBSTInBinaryTree {

	// Information to be returned by every node in bottom up traversal.
	class Info {
		int size; // Size of subtree
		int max; // Min value in subtree
		int min; // Max value in subtree
		int ans; // Size of largest BST which
		// is subtree of current node
		boolean isBST; // If subtree is BST

		public Info(int size, int max, int min, int ans, boolean isBST) {
			this.size = size;
			this.max = max;
			this.min = min;
			this.ans = ans;
			this.isBST = isBST;
		}

		public Info() {

		}

		public int getAns() {
			return ans;
		}
	}

	// Returns Information about subtree. The
	// Information also includes size of largest
	// subtree which is a BST.
	private Info largestBSTBT(Node root) {
		// Base cases : When tree is empty or it has
		// one child.
		if (root == null)
			return new Info(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
		if (root.left == null && root.right == null)
			return new Info(1, root.data, root.data, 1, true);

		// Recur for left subtree and right subtrees
		Info l = largestBSTBT(root.left);
		Info r = largestBSTBT(root.right);

		// Create a return variable and initialize its size.
		Info ret = new Info();
		ret.size = (1 + l.size + r.size);

		// If whole tree rooted under current root is BST.
		if (l.isBST && r.isBST && l.max < root.data && r.min > root.data) {
			ret.min = Math.min(l.min, Math.min(r.min, root.data));
			ret.max = Math.max(r.max, Math.max(l.max, root.data));

			// Update answer for tree rooted under
			// current 'root'
			ret.ans = ret.size;
			ret.isBST = true;

			return ret;
		}

		// If whole tree is not BST, return maximum of left and right subtrees
		ret.ans = Math.max(l.ans, r.ans);
		ret.isBST = false;

		return ret;
	}

	public static void main(String[] args) {
		LargestBSTInBinaryTree tree = new LargestBSTInBinaryTree();
		Node root = new Node(50);
		root.left = new Node(30);
		root.left.left = new Node(20);
		root.left.right = new Node(40);
		root.right = new Node(70);
		root.right.left = new Node(60);
		root.right.right = new Node(80);
		System.out.println(tree.largestBSTBT(root).getAns());
	}
}