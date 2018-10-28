package com.hs.avltree;

public class AVLTree {

	private static Node root;

	// A utility function to get height of the tree
	private int height(Node root) {
		if (root == null) {
			return -1;
		} else {
			int leftHeight = height(root.left);
			int rightHeighht = height(root.right);
			if (leftHeight > rightHeighht) {
				return leftHeight + 1;
			}
			return rightHeighht + 1;
		}
	}

	// A utility function to right rotate subtree
	private Node rightRotate(Node root) {
		Node newRoot = root.left;
		root.left = newRoot.right;

		// Perform rotation
		newRoot.right = root;

		// Update heights
		root.height = height(root);
		newRoot.height = height(newRoot);

		// Return new root
		return newRoot;
	}

	// A utility function to left rotate subtree
	private Node leftRotate(Node root) {

		Node newRoot = root.right;
		root.right = newRoot.left;

		// Perform rotation
		newRoot.left = root;

		// Update heights
		root.height = height(root);
		newRoot.height = height(newRoot);

		// Return new root
		return newRoot;
	}

	// Get Balance factor of node N
	private int getBalance(Node root) {
		if (root == null) {
			return 0;
		}
		return height(root.left) - height(root.right);
	}

	private void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node root, int data) {

		// Perform the normal BST insertion
		if (root == null) {
			return new Node(data);
		}
		if (data < root.data) {
			root.left = insert(root.left, data);
		} else {
			root.right = insert(root.right, data);
		}

		// Get the balance factor of this ancestor node to check whether this
		// node became unbalanced
		int balance = getBalance(root);

		// Left Left Case and left right case
		if (balance > 1) {
			if (data < root.left.data) {
				return rightRotate(root);
			} else {
				root.left = leftRotate(root.left);
				return rightRotate(root);
			}
		}

		// Right Right Case and right left case
		if (balance < -1) {
			if (data > root.right.data) {
				return leftRotate(root);
			} else {
				root.right = rightRotate(root.right);
				return leftRotate(root);
			}
		}

		// Update height of this ancestor node
		root.height = height(root);

		// return the new node pointer
		return root;
	}

	Node minValueNode(Node root) {
		Node temp = root;

		// loop down to find the left most leaf
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp;
	}

	private void delete(int data) {
		root = deleteNode(root, data);
	}

	private Node deleteNode(Node root, int data) {

		// perform standard bst delete
		if (root == null) {
			return root;
		}

		// If the key to be deleted is smaller than the root's key,then it lies
		// in left subtree
		if (data < root.data) {
			root.left = deleteNode(root.left, data);
		}

		// If the key to be deleted is greater than the root's key,then it lies
		// in right subtree
		else if (data > root.data) {
			root.right = deleteNode(root.right, data);
		}

		// if data is equal to node data, means this node we need to delete
		else {
			// case 1, node with no child
			if (root.left == null && root.right == null) {
				root = null;
			}
			// case 2, node with only one child
			else if (root.left == null) {
				root = root.right;
			} else if (root.right == null) {
				root = root.left;
			}
			// case 3, node with 2 child
			else {
				Node temp = minValueNode(root.right);
				root.data = temp.data;
				root.right = deleteNode(root.right, temp.data);
			}
		}

		// If the tree had only one node then return null
		if (root == null) {
			return root;
		}

		// Get the balance factor of this node to check whether this node became
		// unbalanced
		int balance = getBalance(root);

		// Left Left Case and left right case
		if (balance > 1) {
			if (getBalance(root.left) >= 0) {
				return rightRotate(root);
			} else {
				root.left = leftRotate(root.left);
				return rightRotate(root);
			}
		}

		// Right Right Case and right left case
		if (balance < -1) {
			if (getBalance(root.right) <= 0) {
				return leftRotate(root);
			} else {
				root.right = rightRotate(root.right);
				return leftRotate(root);
			}
		}

		// UPDATE HEIGHT OF THE CURRENT NODE
		root.height = height(root);

		return root;
	}

	private void levelOrderTraversal(Node root) {
		int height = height(root);
		for (int i = 0; i <= height; i++)
			levelOrder(root, i);
	}

	private void levelOrder(Node root, int level) {
		if (root == null) {
			return;
		} else if (level == 0) {
			System.out.println(root.data);
		} else {
			levelOrder(root.left, level - 1);
			levelOrder(root.right, level - 1);
		}
	}

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();

		tree.insert(50);
		tree.insert(40);
		tree.insert(45);
		tree.insert(20);
		System.out.println("height of the tree before deletion is " + tree.height(root));
		tree.delete(20);

		System.out.println("The level order traversal of constructed tree is : ");
		tree.levelOrderTraversal(root);
		System.out.println("Height of the tree is " + root.height);
	}
}