package com.hs.linkedlist.madeeasy;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class ReverseLinkedListInPairsWithRecurson {

	private Node reverseListInPairs(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node temp = head.next;
		head.next = temp.next;
		temp.next = head;
		head = temp;
		head.next.next = reverseListInPairs(head.next.next);
		return head;
	}

	public static void main(String[] args) {
		ReverseLinkedListInPairsWithRecurson list = new ReverseLinkedListInPairsWithRecurson();
		Node head = new Node(10);
		head.next = new Node(4);
		head.next.next = new Node(15);
		head.next.next.next = new Node(20);
		head.next.next.next.next = new Node(40);
		head.next.next.next.next.next = new Node(50);
		head.next.next.next.next.next.next = new Node(25);
		head.next.next.next.next.next.next.next = new Node(30);
		head.next.next.next.next.next.next.next.next = new Node(60);

		Node reverseList = list.reverseListInPairs(head);
		LinkedListUtil.printLinkedList(reverseList);
	}
}
