package com.hs.linkedlist;

import com.hs.basic.Node;

public class LongestPolindromInLinkedList {
	// function for counting the common elements
	private int countCommon(Node a, Node b) {
		int count = 0;

		// loop to count common in the list starting from node a and b
		for (; a != null && b != null; a = a.next, b = b.next) {

			// increment the count for same values
			if (a.data == b.data) {
				++count;
			} else {
				break;
			}
		}

		return count;
	}

	// Returns length of the longest palindrome sublist in given list
	private int maxPalindrome(Node head) {
		int result = 0;
		Node prev = null, current = head;

		// loop till the end of the linked list
		while (current != null) {
			// The sublist from head to current reversed.
			Node next = current.next;
			current.next = prev;

			// check for odd length palindrome by finding
			// longest common list elements beginning from prev and
			// from next (We exclude curr)
			result = Math.max(result, 2 * countCommon(prev, next) + 1);

			// check for even length palindrome
			// by finding longest common list elements beginning from curr and from next
			result = Math.max(result, 2 * countCommon(current, next));

			// update prev and curr for next iteration
			prev = current;
			current = next;
		}
		return result;
	}

	public static void main(String[] args) {
		LongestPolindromInLinkedList list = new LongestPolindromInLinkedList();
		
		Node head = new Node(2);
		head.next = new Node(4);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(2);
		head.next.next.next.next.next = new Node(15);

		System.out.println(list.maxPalindrome(head));
	}
}