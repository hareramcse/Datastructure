package com.hs.mywork;

class Values {
	int min, max;

}

public class PrintInVerticalOrder {

	Node root;
	Values values = new Values();

	void findMinMax(Node root, Values min, Values max, int hd) {
		if (root == null)
			return;

		if (hd < min.min)
			min.min = hd;
		if (hd > max.max)
			max.max = hd;

		findMinMax(root.left, min, max, hd - 1);
		findMinMax(root.right, min, max, hd + 1);
	}

	void printVerticalUtil(Node root, int lineNo, int hd) {
		if (root == null)
			return;
		if (lineNo == hd)
			System.out.print(root.data);

		printVerticalUtil(root.left, lineNo, hd - 1);
		printVerticalUtil(root.right, lineNo, hd + 1);

	}

	void printVertical(Node root) {
		findMinMax(root, values, values, 0);
		for (int lineNo = values.min; lineNo < values.max; lineNo++) {
			printVerticalUtil(root, lineNo, 0);
			System.out.println(" ");
		}
	}

	public static void main(String[] args) {
		PrintInVerticalOrder tree = new PrintInVerticalOrder();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);

		tree.printVertical(tree.root);
	}
}
