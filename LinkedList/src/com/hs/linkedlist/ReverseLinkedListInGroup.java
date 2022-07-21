package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

// 25. Reverse Nodes in k-Group Leetcode
public class ReverseLinkedListInGroup {

	public Node reverseKGroup(Node head, int k) {
		if (head == null || head.next == null)
			return head;

		Node current = head;
		Node prev = null;
		Node next = null;

		// this case is only for if length of linkedlist size is not divisible by k
		boolean isCheck = check(head, k);
		if (isCheck) {
			return head;
		}

		int count = 0;
		while (current != null && count < k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		if (next != null) {
			head.next = reverseKGroup(next, k);
		}

		return prev;
	}

	private boolean check(Node head, int k) {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count < k ? true : false;
	}

	public static void main(String[] args) {
		ReverseLinkedListInGroup list = new ReverseLinkedListInGroup();
		Node head = new Node(10);
		head.next = new Node(4);
		head.next.next = new Node(15);
		head.next.next.next = new Node(20);
		head.next.next.next.next = new Node(25);
		head.next.next.next.next.next = new Node(50);
		head.next.next.next.next.next.next = new Node(35);
		head.next.next.next.next.next.next.next = new Node(30);

		Node rev = list.reverseKGroup(head, 3);
		LinkedListUtil.printLinkedList(rev);
	}
}