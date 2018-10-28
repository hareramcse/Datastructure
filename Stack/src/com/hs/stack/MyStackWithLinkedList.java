package com.hs.stack;

public class MyStackWithLinkedList {
	Node head = null;

	// add head element
	private void push(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		} else {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
		}
	}

	// delete head element
	private void pop() {
		if (head == null) {
			System.out.println("sack is empty");
			return;
		} else {
			head = head.next;
		}
	}

	private int top() {
		if (head == null) {
			return -1;
		} else {
			return head.data;
		}
	}

	private void printData() {
		if (head == null) {
			System.out.println("stack is empty");
			return;
		} else {
			Node temp = head;
			while (temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}

	public static void main(String[] args) {
		MyStackWithLinkedList myStackList = new MyStackWithLinkedList();
		myStackList.push(10);
		myStackList.push(20);
		myStackList.push(30);
		myStackList.printData();
		myStackList.pop();
		System.out.println("after 1st pop ");
		myStackList.printData();
		System.out.println("top element is " + myStackList.top());
	}
}
