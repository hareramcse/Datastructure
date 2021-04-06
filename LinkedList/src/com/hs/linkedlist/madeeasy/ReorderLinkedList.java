package com.hs.linkedlist.madeeasy;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class ReorderLinkedList {

	// find the mid element
	// reverse the second half of the element
	// add alternatively from the 1st list and 2nd list into dummy node
	private Node reorderList(Node head) {
		Node mid = LinkedListUtil.findMiddle(head);
		Node nextOfMid = mid.next;
		mid.next = null;

		Node head1 = head;
		Node head2 = LinkedListUtil.reverseByRecursion(nextOfMid);
		Node result = new Node(); // result node

		while (head1 != null || head2 != null) {

			// First add the element from first list
			if (head1 != null) {
				result.next = head1;
				result = result.next;
				head1 = head1.next;
			}

			// Then add the element from second list
			if (head2 != null) {
				result.next = head2;
				result = result.next;
				head2 = head2.next;
			}
		}

		// Assign the head of the new list to head pointer
		return head;
	}

	public static void main(String[] args) {
		ReorderLinkedList list = new ReorderLinkedList();
		Node head = new Node(10);
		head.next = new Node(4);
		head.next.next = new Node(15);
		head.next.next.next = new Node(20);
		head.next.next.next.next = new Node(45);
		head.next.next.next.next.next = new Node(50);
		head.next.next.next.next.next.next = new Node(25);
		head.next.next.next.next.next.next.next = new Node(30);
		head.next.next.next.next.next.next.next.next = new Node(60);

		Node reverseList = list.reorderList(head);
		LinkedListUtil.printLinkedList(reverseList);
	}
}
