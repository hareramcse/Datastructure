package com.hs.linkedlist;

class FindLengthOfLoop {

	// Returns count of nodes present in loop.
	static int countNodes(Node node) {
		int res = 1;
		Node temp = node;
		while (temp.next != node) {
			res++;
			temp = temp.next;
		}
		return res;
	}

	/*
	 * This function detects and counts loop nodes in the list. If loop is not there
	 * in then returns 0
	 */
	static int countNodesinLoop(Node head) {
		Node slow = head, fast = head.next;

		while (fast != null && fast.next != null) {
			if (slow == fast)
				return countNodes(slow);
			slow = slow.next;
			fast = fast.next.next;
		}

		/* Return 0 to indicate that there is no loop */
		return 0;
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		/* Create a loop for testing */
		head.next.next.next.next.next = head.next;

		System.out.println(countNodesinLoop(head));
	}
}