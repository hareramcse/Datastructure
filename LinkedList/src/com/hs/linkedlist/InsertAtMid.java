package com.hs.linkedlist;

class InsertAtMid {
	static Node head; // head of list

	/* Node Class */
	static class Node {
		int data;
		Node next;

		// Constructor to create a new node
		Node(int d) {
			data = d;
			next = null;
		}
	}

	// function to insert node at the
	// middle of the linked list
	static void insertAtMid(int x) {
		// if list is empty
		if (head == null)
			head = new Node(x);

		else {
			// get a new node
			Node newNode = new Node(x);

			// assign values to the slow
			// and fast pointers
			Node slow = head;
			Node fast = head.next;

			while (fast != null && fast.next != null) {
				// move slow pointer to next node
				slow = slow.next;

				// move fast pointer two nodes
				// at a time
				fast = fast.next.next;
			}

			// insert the 'newNode' and adjust
			// the required links
			newNode.next = slow.next;
			slow.next = newNode;
		}
	}

	// function to display the linked list
	static void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	// Driver program to test above
	public static void main(String[] args) {
		// Creating the list 1.2.4.5
		head = null;
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(4);
		head.next.next.next = new Node(5);

		System.out.println("Linked list before" + " insertion: ");
		display();

		int x = 3;
		insertAtMid(x);

		System.out.println("\nLinked list after" + " insertion: ");
		display();
	}
}