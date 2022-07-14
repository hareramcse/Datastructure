package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class RearrangeEvenAndOdd {

	// Function to rearrange the odd and even nodes
	private static Node rearrange(Node head) {
		// Step 1: Segregate even and odd nodes
		// Step 2: Split odd and even lists
		// Step 3: Merge even list into odd list
		Node even;
		Node temp, prev_temp;
		Node i, j, k, l, ptr = null;

		// Step 1: Segregate Odd and Even Nodes
		temp = head.next;
		prev_temp = head;

		while (temp != null) {

			// Backup next pointer of temp
			Node x = temp.next;

			// If temp is odd move the node to beginning of list
			if (temp.data % 2 != 0) {
				prev_temp.next = x;
				temp.next = head;
				head = temp;
			} else {
				prev_temp = temp;
			}

			// Advance Temp Pointer
			temp = x;
		}

		// Step 2
		// Split the List into Odd and even
		temp = head.next;
		prev_temp = head;

		while (temp != null && temp.data % 2 != 0) {
			prev_temp = temp;
			temp = temp.next;
		}

		even = temp;

		// End the odd List (Make last node null)
		prev_temp.next = null;

		// Step 3:
		// Merge Even List into odd
		i = head;
		j = even;

		while (j != null && i != null) {

			// While both lists are not exhausted Backup next pointers of i and j
			k = i.next;
			l = j.next;

			i.next = j;
			j.next = k;

			// ptr points to the latest node added
			ptr = j;

			// Advance i and j pointers
			i = k;
			j = l;
		}

		if (i == null) {

			// Odd list exhausts before even,
			// append remainder of even list to odd.
			ptr.next = j;
		}

		// The case where even list exhausts before
		// odd list is automatically handled since we
		// merge the even list into the odd list
		return head;
	}

	public static void main(String args[]) {
		Node head = LinkedListUtil.addLast(null, 8);
		head = LinkedListUtil.addLast(head, 7);
		head = LinkedListUtil.addLast(head, 6);
		head = LinkedListUtil.addLast(head, 3);
		head = LinkedListUtil.addLast(head, 5);
		head = LinkedListUtil.addLast(head, 1);
		head = LinkedListUtil.addLast(head, 2);
		head = LinkedListUtil.addLast(head, 10);

		System.out.println("Linked List:");
		LinkedListUtil.printLinkedList(head);
		System.out.println("Rearranged List");
		head = rearrange(head);
		LinkedListUtil.printLinkedList(head);
	}
}