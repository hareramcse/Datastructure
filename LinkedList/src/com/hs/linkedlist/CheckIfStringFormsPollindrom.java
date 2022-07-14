package com.hs.linkedlist;

import com.hs.basic.Node;

class CheckIfStringFormsPollindrom {

	// A utility function to check if str is palindrome or not
	private boolean isPollindromeUtil(String str) {
		int length = str.length();

		// Match characters from beginning and end.
		for (int i = 0; i < length / 2; i++) {
			if (str.charAt(i) != str.charAt(length - i - 1)) {
				return false;
			}
		}

		return true;
	}

	// Returns true if string formed by linked list is palindrome
	private boolean isPalindrome(Node head) {
		Node node = head;

		// Append all nodes to form a string
		String str = "";
		while (node != null) {
			str = str.concat("" + node.data);
			node = node.next;
		}

		// Check if the formed string is palindrome
		return isPollindromeUtil(str);
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		CheckIfStringFormsPollindrom list = new CheckIfStringFormsPollindrom();
		Node head = new Node("a");
		head.next = new Node("bc");
		head.next.next = new Node("d");
		head.next.next.next = new Node("dcb");
		head.next.next.next.next = new Node("a");

		System.out.println(list.isPalindrome(head));

	}
}
