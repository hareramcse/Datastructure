package com.hs.checkandprint;

/*Following are detailed steps.
1) Find inorder and preorder traversals of T, store them in two auxiliary arrays inT[] 
and preT[].
2) Find inorder and preorder traversals of S, store them in two auxiliary arrays inS[] 
and preS[].
3) If inS[] is a subarray of inT[] and preS[] is a subarray preT[], then S is a subtree 
of T. Else not*/

// O(n)
class Passing {
	int i;
	int m = 0;
	int n = 0;
}

public class CheckIfTreeIsSubTreeOfAnotherTree {

	Passing p = new Passing();
	
	/* This function returns true if S is a subtree of T, otherwise false */
	private boolean isSubtree(Node T, Node S) {
		/* base cases */
		if (S == null) {
			return true;
		}
		if (T == null) {
			return false;
		}

		// Store Inorder traversals of T and S in inT[0..m-1] and inS[0..n-1]
		// respectively
		int inT[] = new int[100];
		String op1 = String.valueOf(inT);
		int inS[] = new int[100];
		String op2 = String.valueOf(inS);
		storeInorder(T, inT, p);
		storeInorder(S, inS, p);
		inT[p.m] = '\0';
		inS[p.m] = '\0';

		// If inS[] is not a substring of preS[], return false
		if (chekSubString(op1, op2) != null) {
			return false;
		}

		// Store Preorder traversals of T and S in inT[0..m-1]
		// and inS[0..n-1] respectively
		p.m = 0;
		p.n = 0;
		int preT[] = new int[100];
		int preS[] = new int[100];
		String op3 = String.valueOf(preT);
		String op4 = String.valueOf(preS);
		storePreOrder(T, preT, p);
		storePreOrder(S, preS, p);
		preT[p.m] = '\0';
		preS[p.n] = '\0';

		// If inS[] is not a substring of preS[], return false
		// Else return true
		return (chekSubString(op3, op4) != null);
	}

	private String chekSubString(String haystack, String needle) {
		if (haystack == null || needle == null) {
			return null;
		}
		int hLength = haystack.length();
		int nLength = needle.length();
		if (hLength < nLength) {
			return null;
		}
		if (nLength == 0) {
			return haystack;
		}
		for (int i = 0; i <= hLength - nLength; i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				int j = 0;
				for (; j < nLength; j++) {
					if (haystack.charAt(i + j) != needle.charAt(j)) {
						break;
					}
				}
				if (j == nLength) {
					return haystack.substring(i);
				}
			}
		}
		return null;
	}

	// A utility function to store inorder traversal of tree rooted
	// with root in an array arr[]. Note that i is passed as reference
	private void storeInorder(Node node, int arr[], Passing i) {
		if (node == null) {
			arr[i.i++] = '$';
			return;
		}
		storeInorder(node.left, arr, i);
		arr[i.i++] = node.data;
		storeInorder(node.right, arr, i);
	}

	// A utility function to store preorder traversal of tree rooted
	// with root in an array arr[]. Note that i is passed as reference
	private void storePreOrder(Node node, int arr[], Passing i) {
		if (node == null) {
			arr[i.i++] = '$';
			return;
		}
		arr[i.i++] = node.data;
		storePreOrder(node.left, arr, i);
		storePreOrder(node.right, arr, i);
	}

	

	// Driver program to test above functions
	public static void main(String args[]) {
		CheckIfTreeIsSubTreeOfAnotherTree tree = new CheckIfTreeIsSubTreeOfAnotherTree();
		Node T = new Node('a');
		T.left = new Node('b');
		T.right = new Node('d');
		T.left.left = new Node('c');
		T.right.right = new Node('e');

		Node S = new Node('a');
		S.left = new Node('b');
		S.right = new Node('d');
		S.left.left = new Node('c');

		if (tree.isSubtree(T, S)) {
			System.out.println("Yes , S is a subtree of T");
		} else {
			System.out.println("No, S is not a subtree of T");
		}
	}
}