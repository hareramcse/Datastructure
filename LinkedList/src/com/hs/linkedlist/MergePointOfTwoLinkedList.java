package com.hs.linkedlist;

public class MergePointOfTwoLinkedList {

	public Node head = null;

	MergePointOfTwoLinkedList() {
		head = null;
	}

	private void insert(int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node temp = head;
			Node newNodee = new Node(data);
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNodee;
		}
	}

	private int length(Node list) {
		int lenght = 0;
		Node tmp = list;
		while (tmp != null) {
			lenght++;
			tmp = tmp.next;
		}
		return lenght;
	}

	// 1st way and its time complexity is (m*n)
	private Node findMerge(Node firstList, Node secondList) {
		int firstLength = length(firstList);
		int secondLength = length(secondList);
		Node pointHead = secondList;
		for (int i = 0; i < firstLength; i++) {
			secondList = pointHead;
			for (int j = 0; j < secondLength; j++) {
				if (firstList.data == secondList.data) {
					return firstList;
				}
				secondList = secondList.next;
			}
			firstList = firstList.next;
		}
		return null;
	}

	// 2nd way its time complexity is (m+n)
	private Node findMergePoint(Node firstList, Node secondList) {
		int firstLength = length(firstList);
		int secondLength = length(secondList);
		int diff = secondLength - firstLength;
		if (firstLength > secondLength) {
			Node tmp = firstList;
			firstList = secondList;
			secondList = tmp;
			diff = firstLength - secondLength;
		}
		for (int i = 0; i < diff; i++) {
			secondList = secondList.next;
		}
		while (firstList != null && secondList != null) {
			if (firstList.data == secondList.data) {
				return firstList;
			}
			firstList = firstList.next;
			secondList = secondList.next;
		}
		return null;
	}

	public static void main(String[] args) {
		MergePointOfTwoLinkedList merge1 = new MergePointOfTwoLinkedList();
		/*
		 * merge1.insert(90); merge1.insert(50); merge1.insert(60);
		 * merge1.insert(70); merge1.insert(90); merge1.insert(40);
		 * merge1.insert(70);
		 */
		merge1.insert(10);
		merge1.insert(20);
		merge1.insert(30);
		merge1.insert(40);
		merge1.insert(100);

		MergePointOfTwoLinkedList merge2 = new MergePointOfTwoLinkedList();
		merge2.insert(90);
		merge2.insert(50);
		merge2.insert(60);
		merge2.insert(70);
		merge2.insert(90);
		merge2.insert(40);
		merge2.insert(70);
		/*
		 * merge1.insert(10); merge1.insert(20); merge1.insert(30);
		 * merge1.insert(40); merge1.insert(100);
		 */

		MergePointOfTwoLinkedList merge = new MergePointOfTwoLinkedList();
		Node Node = merge.findMergePoint(merge1.head, merge2.head);
		Node n = merge.findMerge(merge1.head, merge2.head);
		if (Node == null) {
			System.out.println("there is no any merging point");
		} else {
			System.out.println(Node.data);
		}
		if (n == null) {
			System.out.println("there is no any merging point");
		} else {
			System.out.println(n.data);
		}
	}
}