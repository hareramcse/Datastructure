package com.hs.linkedlist.madeeasy;

import com.hs.basic.Node;

public class RemoveDuplicate {

	private Node removeDuplicate(Node head) {
		Node current = head;
		Node next_next = null;
		while (current != null && current.next != null) {
			if (current.data == current.next.data) {
				next_next = current.next.next;
				current.next = null;
				current = next_next;
			} else {
				current = current.next;
			}
		}

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
		RemoveDuplicate list = new RemoveDuplicate();
		Node head = new Node(90);
		head.next = new Node(50);
		head.next.next = new Node(60);
		head.next.next.next = new Node(60);
		head.next.next.next.next = new Node(60);
		head.next.next.next.next.next = new Node(40);

		Node reverseList = list.removeDuplicate(head);
		list.printList(reverseList);
	}
}
