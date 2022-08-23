package com.hs.leetcode.medium;

import java.util.Random;

import com.hs.basic.ListNode;

public class RandomNode {
	Random random = null;
	ListNode head = null;

	public RandomNode(ListNode head) {
		this.random = new Random();
		this.head = head;
	}

	private int getRandom() {
		int count = 1;
		ListNode current = head;
		int result = 0;
		while (current != null) {
			if (random.nextInt(count) == 0)
				result = current.val;
			count++;
			current = current.next;
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(5);
		head.next = new ListNode(20);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(30);

		RandomNode list = new RandomNode(head);
		int random = list.getRandom();
		System.out.println(random);
	}
}