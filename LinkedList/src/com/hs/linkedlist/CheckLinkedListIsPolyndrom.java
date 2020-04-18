package com.hs.linkedlist;

class CheckLinkedListIsPolyndrom {
	Node head;
	Node left;

	private boolean isPalindrome(Node right) {
		left = head;

		/* stop recursion when right becomes NULL */
		if (right == null)
			return true;

		// If sub-list is not palindrome then no need to check for current left and
		// right, return false
		boolean isp = isPalindrome(right.next);
		if (isp == false)
			return false;

		/* Check values at current left and right */
		boolean isp1 = (right.data == left.data);

		/* Move left to next node */
		left = left.next;

		return isp1;
	}

	private  void push(char new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	private void printList(Node ptr) {
		while (ptr != null) {
			System.out.print(ptr.data + "->");
			ptr = ptr.next;
		}
		System.out.println("NULL");
	}

	/* Driver program to test the above functions */
	public static void main(String[] args) {
		/* Start with the empty list */
		CheckLinkedListIsPolyndrom llist = new CheckLinkedListIsPolyndrom();

		char str[] = { 'a', 'b', 'a', 'c', 'a', 'b', 'a' };
		for (int i = 0; i < 7; i++) {
			llist.push(str[i]);
			llist.printList(llist.head);
			if (llist.isPalindrome(llist.head) != false) {
				System.out.println("Is Palindrome");
				System.out.println("");
			} else {
				System.out.println("Not Palindrome");
				System.out.println("");
			}
		}
	}
}