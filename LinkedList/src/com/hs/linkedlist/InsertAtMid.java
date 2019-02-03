package com.hs.linkedlist;

class InsertAtMid {
	Node head; // head of list

	// function to insert node at the
	// middle of the linked list
	void insertAtMid(int data) {
		// if list is empty
		if (head == null)
			head = new Node(data);

		else {
			// get a new node
			Node newNode = new Node(data);

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
	void display() {
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
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(4);
		list.head.next.next.next = new Node(5);

		System.out.println("Linked list before" + " insertion: ");
		list.display();

		int data = 3;
		list.insertAtMid(data);

		System.out.println("\nLinked list after" + " insertion: ");
		list.display();
	}
}