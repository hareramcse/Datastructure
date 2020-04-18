package com.hs.linkedlist;

class DetectCycle {

	private boolean detectLoop(Node head) {
		Node slow = head;
		Node fast = head.next;

		// Search for loop using slow and fast pointers
		while (fast != null && fast.next != null) {
			if (slow == fast) {
				System.out.println("found");
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}

	/* Drier program to test above functions */
	public static void main(String args[]) {
		DetectCycle llist = new DetectCycle();
		Node head = new Node(20);
		head.next = new Node(10);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);

		/* Create loop for testing */
		head.next.next.next.next = head.next;

		llist.detectLoop(head);
	}
}