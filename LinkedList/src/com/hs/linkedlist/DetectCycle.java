package com.hs.linkedlist;

class DetectCycle {
	Node head; // head of list

	/* Inserts a new Node at front of the list. */
	public void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	boolean detectLoop() {
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

		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(10);

		/* Create loop for testing */
		llist.head.next.next.next.next = llist.head;

		llist.detectLoop();
	}
}