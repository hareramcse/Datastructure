package com.hs.linkedlist;

class RemoveDuplicate {
	Node head;

	private void removeDuplicates(Node head) {
		/* Another reference to head */
		Node current = head;

		/* Pointer to store the next pointer of a node to be deleted */
		Node next_next;

		/* do nothing if the list is empty */
		if (head == null)
			return;

		/* Traverse list till the last node */
		while (current.next != null) {

			/* Compare current node with the next node */
			if (current.data == current.next.data) {
				next_next = current.next.next;
				current.next = null;
				current.next = next_next;
			} else // advance if no deletion
				current = current.next;
		}
	}

	private void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	private void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Drier program to test above functions */
	public static void main(String args[]) {
		RemoveDuplicate llist = new RemoveDuplicate();
		llist.push(20);
		llist.push(13);
		llist.push(13);
		llist.push(11);
		llist.push(11);
		llist.push(11);

		System.out.println("List before removal of duplicates");
		llist.printList(llist.head);

		llist.removeDuplicates(llist.head);

		System.out.println("List after removal of elements");
		llist.printList(llist.head);
	}
}