package com.hs.linkedlist;

class FindLengthOfLoop {

	// Returns count of nodes present in loop.
	private static int countNodes(Node head) {
		int count = 1;
		Node temp = head;
		while (temp.next != head) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	// count number of nodes in the loop
	private static int countNodesInLoop(Node head) {
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

		System.out.println(countNodesInLoop(head));
	}
}