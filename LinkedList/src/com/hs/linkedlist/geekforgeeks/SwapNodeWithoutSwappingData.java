package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.Node;

class SwapNodeWithoutSwappingData {
	Node head;

	// Function to swap Nodes x and y in linked list by changing links
	Node swapNodes(Node head_ref, int x, int y) {
		Node head = head_ref;
		// Nothing to do if x and y are same
		if (x == y)
			return null;

		Node a = null, b = null;

		// search for x and y in the linked list
		// and store their pointer in a and b
		while (head_ref.next != null) {

			if (head_ref.next.data == x) {
				a = head_ref;
			}

			else if (head_ref.next.data == y) {
				b = head_ref;
			}

			head_ref = head_ref.next;
		}

		// if we have found both a and b
		// in the linked list swap current
		// pointer and next pointer of these
		if (a != null && b != null) {
			Node temp = a.next;
			a.next = b.next;
			b.next = temp;
			temp = a.next.next;
			a.next.next = b.next.next;
			b.next.next = temp;
		}
		return head;
	}

	private void push(int new_data) {
		Node new_Node = new Node(new_data);
		new_Node.next = head;
		head = new_Node;
	}

	private void printList() {
		Node tNode = head;
		while (tNode != null) {
			System.out.print(tNode.data + " ");
			tNode = tNode.next;
		}
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		SwapNodeWithoutSwappingData llist = new SwapNodeWithoutSwappingData();

		/*
		 * The constructed linked list is: 1->2->3->4->5->6->7
		 */
		llist.push(7);
		llist.push(6);
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);

		System.out.print("\n Linked list before calling swapNodes() ");
		llist.printList();

		llist.swapNodes(llist.head, 3, 6);

		System.out.print("\n Linked list after calling swapNodes() ");
		llist.printList();
	}
}