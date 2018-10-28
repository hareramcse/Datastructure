package com.hs.linkedlist;

public class MyDoubliLinkedlList {

	private Node head = null;

	private void addBefore(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		} else {
			Node newNode = new Node(data);
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
	}

	private void addAfterIndex(int index, int data) {
		if (head == null) {
			head = new Node(data);
			return;
		} else {
			Node newNode = new Node(data);
			int count = 0;
			Node temp = head;
			while (temp.next != null) {
				count++;
				if (count == index) {
					break;
				}
				temp = temp.next;
			}
			newNode.next = temp.next;
			newNode.prev = temp;
			temp.next = newNode;
		}
	}

	private void addLast(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		} else {
			Node temp = head;
			Node newNode = new Node(data);
			while (temp.next != null) {
				temp = temp.next;
			}
			newNode.prev = temp;
			temp.next = newNode;
		}
	}

	private void deleteFirst() {
		if (head == null) {
			System.out.println("list is empty");
			return;
		} else {
			head = head.next;
		}
	}

	private void deleteIndex(int index) {
		if (head == null) {
			System.out.println("list is empty");
			return;
		} else {
			int count = 0;
			Node temp = head;
			while (temp.next != null) {
				count++;
				if (count == index) {
					break;
				}
				temp = temp.next;
			}
			temp.next = temp.next.next;
		}
	}

	private void deleteLast() {
		if (head == null) {
			System.out.println("list is empty");
			return;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.prev.next = null;
		}
	}

	private void printData() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		MyDoubliLinkedlList myDobList = new MyDoubliLinkedlList();
		myDobList.addBefore(10);
		myDobList.addBefore(20);
		myDobList.addBefore(30);
		myDobList.addBefore(40);
		myDobList.printData();
		myDobList.addAfterIndex(2, 50);
		System.out.println("after adding data at index 2");
		myDobList.printData();
		myDobList.addLast(60);
		System.out.println("after adding the data at last");
		myDobList.printData();
		myDobList.deleteFirst();
		System.out.println("delete the head element");
		myDobList.printData();
		myDobList.deleteIndex(2);
		System.out.println("delete the 2nd element");
		myDobList.printData();
		myDobList.deleteLast();
		System.out.println("delete last element");
		myDobList.printData();
	}
}
