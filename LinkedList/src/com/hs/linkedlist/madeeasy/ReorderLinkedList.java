package com.hs.linkedlist.madeeasy;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class ReorderLinkedList {

	// find the mid element
	// reverse the second half of the element
	// add alternatively from the 1st list and 2nd list into dummy node
	private Node reorderList(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node start = head;
		Node mid = slow.next;
		slow.next = null;

		mid = LinkedListUtil.reverseByRecursion(mid);
		head = new Node(); // Assign dummy Node

		// curr is the pointer to this dummy Node, which will be used to form the new list
		Node curr = head;
		while (start != null || mid != null) {

			// First add the element from first list
			if (start != null) {
				curr.next = start;
				curr = curr.next;
				start = start.next;
			}

			// Then add the element from second list
			if (mid != null) {
				curr.next = mid;
				curr = curr.next;
				mid = mid.next;
			}
		}

		// Assign the head of the new list to head pointer
		return head.next;
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
