package com.hs.linkedlist.madeeasy;

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

	private void printList(Node head) {
		Node temp = head;
		if (head == null) {
			System.out.println("List is empty");
		}
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.print("NULL");
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
		list.printList(reverseList);
	}
}
