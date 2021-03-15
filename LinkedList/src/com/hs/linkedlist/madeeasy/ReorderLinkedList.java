package com.hs.linkedlist.madeeasy;

import com.hs.basic.Node;

public class ReorderLinkedList {

	private Node reorderList(Node head) {
		Node slow = head;
		Node fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node node1 = head;
		Node node2 = slow.next;
		slow.next = null;

		node2 = reverseList(node2);
		head = new Node(0); // Assign dummy Node

		// curr is the pointer to this dummy Node, which
		// will be used to form the new list
		Node curr = head;
		while (node1 != null || node2 != null) {

			// First add the element from first list
			if (node1 != null) {
				curr.next = node1;
				curr = curr.next;
				node1 = node1.next;
			}

			// Then add the element from second list
			if (node2 != null) {
				curr.next = node2;
				curr = curr.next;
				node2 = node2.next;
			}
		}

		// Assign the head of the new list to head pointer
		return head.next;
	}

	private Node reverseList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node reverseList = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return reverseList;
	}

	private void printList(Node head) {
		Node temp = head;
		if (head == null) {
			System.out.println("List is empty");
		}
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		ReorderLinkedList list = new ReorderLinkedList();
		Node head = new Node(10);
		head.next = new Node(4);
		head.next.next = new Node(15);
		head.next.next.next = new Node(20);
		head.next.next.next.next = new Node(20);
		head.next.next.next.next.next = new Node(50);
		head.next.next.next.next.next.next = new Node(25);
		head.next.next.next.next.next.next.next = new Node(30);
		head.next.next.next.next.next.next.next.next = new Node(60);

		Node reverseList = list.reorderList(head);
		list.printList(reverseList);
	}
}
