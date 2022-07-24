package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

// 143. Reorder List Leetcode
public class ReorderLinkedList {

	// find the mid element
	// reverse the second half of the element
	// add alternatively from the 1st list and 2nd list into dummy node
	public Node reorderList(Node head) {
		Node mid = LinkedListUtil.findMiddle(head);
		Node nextOfMid = mid.next;
		mid.next = null;

		Node head1 = head;
		Node head2 = LinkedListUtil.reverseByRecursion(nextOfMid);

		// iterate till last node of the list
		while (head2 != null) {
			Node temp1 = head1.next;
			Node temp2 = head2.next;
			head1.next = head2;
			head2.next = temp1;
			head1 = temp1;
			head2 = temp2;
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