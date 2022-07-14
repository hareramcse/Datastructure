package com.hs.linkedlist;

import java.util.Random;

import com.hs.basic.Node;

// 382. Linked List Random Node Leetcode
public class RandomNode {

	Random random = null;
	Node head = null;

	public RandomNode(Node head) {
		this.random = new Random();
		this.head = head;
	}

	private int getRandom() {
		int count = 1;
		Node current = head;
		int result = 0;
		while (current != null) {
			if (random.nextInt(count) == 0)
				result = current.data;
			count++;
			current = current.next;
		}
		return result;
	}

	public static void main(String[] args) {
		Node head = new Node(5);
		head.next = new Node(20);
		head.next.next = new Node(4);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(30);

		RandomNode list = new RandomNode(head);

		int random = list.getRandom();
		System.out.println(random);
	}
}