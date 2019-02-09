package com.hs.random;

public class ConnectNodeAtSameLevel1 {

	/*
	 * Set next right of all descendents of p. This function makes sure that
	 * nextRight of nodes ar level i is set before level i+1 nodes.
	 */
	void connectRecur(Node p) {

		// Base case
		if (p == null) {
			return;
		}

		/*
		 * Before setting nextRight of left and right children, set nextRight of
		 * children of other nodes at same level (because we can access children of
		 * other nodes using p's nextRight only)
		 */
		if (p.nextRight != null) {
			connectRecur(p.nextRight);
		}

		/* Set the nextRight pointer for p's left child */
		if (p.left != null) {
			if (p.right != null) {
				p.left.nextRight = p.right;
				p.right.nextRight = getNextRight(p);
			} else {
				p.left.nextRight = getNextRight(p);
			}

			/*
			 * Recursively call for next level nodes. Note that we call only for left child.
			 * The call for left child will call for right child
			 */
			connectRecur(p.left);
		}

		/*
		 * If left child is NULL then first node of next level will either be p->right
		 * or getNextRight(p)
		 */
		else if (p.right != null) {
			p.right.nextRight = getNextRight(p);
			connectRecur(p.right);
		} else {
			connectRecur(getNextRight(p));
		}
	}

	/*
	 * This function returns the leftmost child of nodes at the same level as p.
	 * This function is used to getNExt right of p's right child If right child of p
	 * is NULL then this can also be used for the left child
	 */
	Node getNextRight(Node p) {
		Node temp = p.nextRight;

		/*
		 * Traverse nodes at p's level and find and return the first node's first child
		 */
		while (temp != null) {
			if (temp.left != null) {
				return temp.left;
			}
			if (temp.right != null) {
				return temp.right;
			}
			temp = temp.nextRight;
		}

		// If all the nodes at p's level are leaf nodes then return NULL
		return null;
	}

	public static void main(String args[]) {
		ConnectNodeAtSameLevel1 tree = new ConnectNodeAtSameLevel1();
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.right.right = new Node(90);

		// Populates nextRight pointer in all nodes
		tree.connectRecur(root);

		// Let us check the values of nextRight pointers
		int a = root.nextRight != null ? root.nextRight.data : -1;
		int b = root.left.nextRight != null ? root.left.nextRight.data : -1;
		int c = root.right.nextRight != null ? root.right.nextRight.data : -1;
		int d = root.left.left.nextRight != null ? root.left.left.nextRight.data : -1;
		int e = root.right.right.nextRight != null ? root.right.right.nextRight.data : -1;

		// Now lets print the values
		System.out.println(
				"Following are populated nextRight pointers in " + " the tree(-1 is printed if there is no nextRight)");
		System.out.println("nextRight of " + root.data + " is " + a);
		System.out.println("nextRight of " + root.left.data + " is " + b);
		System.out.println("nextRight of " + root.right.data + " is " + c);
		System.out.println("nextRight of " + root.left.left.data + " is " + d);
		System.out.println("nextRight of " + root.right.right.data + " is " + e);
	}
}
