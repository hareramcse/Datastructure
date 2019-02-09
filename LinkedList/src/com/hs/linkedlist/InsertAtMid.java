package com.hs.linkedlist;

class InsertAtMid {

	// function to insert node at the
	// middle of the linked list
	void insertAtMid(Node head, int data) {
		// if list is empty
		if (head == null) {
			head = new Node(data);
		} else {
			// get a new node
			Node newNode = new Node(data);

			// assign values to the slow
			// and fast pointers
			Node slow = head;
			Node fast = head.next;

			while (fast != null && fast.next != null) {
				// move slow pointer to next node
				slow = slow.next;
				fast = fast.next.next;
			}

			// insert the 'newNode' and adjust
			// the required links
			newNode.next = slow.next;
			slow.next = newNode;
		}
	}

	// function to display the linked list
	void display(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	// Driver program to test above
	public static void main(String[] args) {
		// Creating the list 1.2.4.5
		InsertAtMid list = new InsertAtMid();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(4);
		head.next.next.next = new Node(5);

		System.out.println("Linked list before" + " insertion: ");
		list.display(head);

		int data = 3;
		list.insertAtMid(head, data);

		System.out.println("\nLinked list after" + " insertion: ");
		list.display(head);
	}
}