package com.hs.linkedlist;

public class DeleteAlternateNode {
	Node head;

	private void deleteAlt() {
		if (head == null)
			return;

		Node current = head;
		Node nextNode = head.next;

		while (current != null && nextNode != null) {
			/* Change next link of previous node */
			current.next = nextNode.next;

			/* Free node */
			nextNode = null;

			/* Update prev and now */
			current = current.next;
			if (current != null) {
				nextNode = current.next;
			}
		}
	}

	private  void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	private void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		DeleteAlternateNode llist = new DeleteAlternateNode();

		/* Constructed Linked List is 1->2->3->4->5->null */
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);

		System.out.println("Linked List before calling deleteAlt() ");
		llist.printList();

		llist.deleteAlt();

		System.out.println("Linked List after calling deleteAlt() ");
		llist.printList();
	}

}