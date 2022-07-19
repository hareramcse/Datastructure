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

		Node head = LinkedListUtil.addLast(null, 20);
		head = LinkedListUtil.addLast(head, 13);
		head = LinkedListUtil.addLast(head, 13);
		head = LinkedListUtil.addLast(head, 11);
		head = LinkedListUtil.addLast(head, 11);
		head = LinkedListUtil.addLast(head, 11);

		System.out.println("List before removal of duplicates");
		LinkedListUtil.printLinkedList(head);

		list.removeElements(head, 13);

		System.out.println("List after removal of elements");
		LinkedListUtil.printLinkedList(head);
	}
}