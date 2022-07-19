package com.hs.linkedlist;

import com.hs.basic.Node;

// 142. Linked List Cycle II Leetcode
public class FindStartNodeOfLoop {
	public Node findStartNode(Node head) {
		Node slow = head;
		Node fast = head;
		boolean loopExist = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				loopExist = true;
				break;
			}
		}

		if (loopExist) {
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return fast;
		}
		return null;
	}

	public static void main(String[] args) {
		FindStartNodeOfLoop list = new FindStartNodeOfLoop();
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = new Node(60);
		head.next.next.next.next.next.next = new Node(70);
		head.next.next.next.next.next.next.next = new Node(80);

		head.next.next.next.next.next.next.next = head.next.next;

		Node startNode = list.findStartNode(head);
		System.out.println(startNode.data);
	}
}