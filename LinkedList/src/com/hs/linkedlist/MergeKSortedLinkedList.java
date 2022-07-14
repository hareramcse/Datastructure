package com.hs.linkedlist;

import java.util.PriorityQueue;
import java.util.Queue;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

// 23. Merge k Sorted Lists Leetcode
public class MergeKSortedLinkedList {

	public Node mergeKLists(Node[] lists) {
		Queue<Integer> minHeap = new PriorityQueue<>();
		for (Node head : lists) {
			while (head != null) {
				minHeap.add(head.data);
				head = head.next;
			}
		}

		Node dummy = new Node();
		Node head = dummy;
		while (!minHeap.isEmpty()) {
			head.next = new Node(minHeap.remove());
			head = head.next;
		}
		return dummy.next;
	}

	public static void main(String args[]) {
		MergeKSortedLinkedList list = new MergeKSortedLinkedList();
		int k = 3; // Number of linked lists

		// an array of pointers storing the head nodes of the linked lists
		Node arr[] = new Node[k];

		arr[0] = new Node(1);
		arr[0].next = new Node(3);
		arr[0].next.next = new Node(5);
		arr[0].next.next.next = new Node(7);

		arr[1] = new Node(2);
		arr[1].next = new Node(4);
		arr[1].next.next = new Node(6);
		arr[1].next.next.next = new Node(8);

		arr[2] = new Node(0);
		arr[2].next = new Node(9);
		arr[2].next.next = new Node(10);
		arr[2].next.next.next = new Node(11);

		// Merge all lists
		Node head = list.mergeKLists(arr);
		LinkedListUtil.printLinkedList(head);
	}
}