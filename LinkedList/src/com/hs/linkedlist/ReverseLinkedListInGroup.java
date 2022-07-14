package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class ReverseLinkedListInGroup {

	public Node reverseKGroup(Node head, int k) {
		if (head == null || head.next == null)
			return head;

		int length = length(head);

		Node dummyHead = new Node();
		dummyHead.next = head;

		Node pre = dummyHead;
		Node cur;
		Node nex;

		while (length >= k) {
			cur = pre.next;
			nex = cur.next;
			for (int i = 1; i < k; i++) {
				cur.next = nex.next;
				nex.next = pre.next;
				pre.next = nex;
				nex = cur.next;
			}
			pre = cur;
			length -= k;
		}
		return dummyHead.next;
	}

	private int length(Node head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}

	public static void main(String[] args) {
		ReverseLinkedListInGroup list = new ReverseLinkedListInGroup();
		Node head = new Node(10);
		head.next = new Node(4);
		head.next.next = new Node(15);
		head.next.next.next = new Node(20);
		head.next.next.next.next = new Node(20);
		head.next.next.next.next.next = new Node(50);
		head.next.next.next.next.next.next = new Node(25);
		head.next.next.next.next.next.next.next = new Node(30);

		Node rev = list.reverseKGroup(head, 3);
		LinkedListUtil.printLinkedList(rev);
	}
}