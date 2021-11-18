package com.hs.bst;

public class FindNextHighestElement {
	public Node root = null;

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node root, int data) {
		if (root == null) {
			root = new Node(data);
		} else {
			if (data < root.data) {
				root.left = insert(root.left, data);
			} else {
				root.right = insert(root.right, data);
			}
		}
		return root;
	}

	private void printDataInOrder(Node root) {
		if (root == null) {
			return;
		} else {
			printDataInOrder(root.left);
			System.out.println(root.data);
			printDataInOrder(root.right);
		}
	}

	private Node searchNextHighestElement(int data) {
		return search(root, data);
	}

	private Node findNode(Node root, int data) {
		if (root == null) {
			return root;
		} else if (root.data == data) {
			return root;
		} else if (data < root.data) {
			return findNode(root.left, data);
		} else {
			return findNode(root.right, data);
		}
	}

	private Node findMinInBST(Node root) {
		Node temp = root;
		if (temp == null) {
			return temp;
		}
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp;
	}

	private Node search(Node root, int data) {
		Node current = findNode(root, data);
		if (current == null) {
			return null;
		}
		if (current.right != null) {
			return findMinInBST(current.right);
		} else {
			Node successor = null;
			Node ancestor = root;
			while (ancestor != current) {
				if (current.data < ancestor.data) {
					successor = ancestor;
					ancestor = ancestor.left;
				} else {
					ancestor = ancestor.right;
				}
			}
			return successor;
		}
	}

	public static void main(String[] args) {
		FindNextHighestElement tree = new FindNextHighestElement();
		tree.insert(6);
		tree.insert(11);
		tree.insert(9);
		tree.insert(3);
		tree.insert(14);
		tree.insert(1);
		tree.insert(15);

		tree.printDataInOrder(tree.root);

		System.out.print("Next highest element of 9 is ");
		System.out.println(tree.searchNextHighestElement(9).data);

		System.out.println();
	}
}
