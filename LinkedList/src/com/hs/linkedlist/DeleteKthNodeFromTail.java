package com.hs.linkedlist;

import com.hs.basic.Node;

// 19. Remove Nth Node From End of List Leetcode
public class DeleteKthNodeFromTail {
	private Node deleteKthNodeFromEnd(Node head, int n) {
		Node start = new Node();
		start.next = head;
		Node slow = head;
		Node fast = head;

		for (int i = 0; i <= n; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
		return start.next;
	}

	public static void main(String[] args) {
		DeleteKthNodeFromTail list = new DeleteKthNodeFromTail();
		Node head = new Node(20);
		head.next = new Node(10);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);

		Node node = list.deleteKthNodeFromEnd(head, 3);
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
}