package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

// 203. Remove Linked List Elements
public class RemoveElements {
	public Node removeElements(Node head, int val) {
		while (head != null && head.data == val) {
			head = head.next;
		}

		Node current = head;
		while (current != null && current.next != null) {
			if (current.next.data == val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}
	
	public static void main(String args[]) {
		RemoveElements list = new RemoveElements();

		Node head = new Node(20);
		head.next = new Node(13);
		head.next.next = new Node(13);
		head.next.next.next = new Node(11);
		head.next.next.next.next = new Node(11);
		head.next.next.next.next.next = new Node(11);

		System.out.println("List before removal of duplicates");
		LinkedListUtil.printLinkedList(head);

		list.removeElements(head, 13);

		System.out.println("List after removal of elements");
		LinkedListUtil.printLinkedList(head);
	}
}