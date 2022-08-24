package com.hs.queue.basic;

public class QueqeUsingLinkedList {

	private Node front;
	private Node rear;

	// insert at last index
	private void enQueue(int data) {
		if (front == null && rear == null) {
			Node newNode = new Node(data);
			front = rear = newNode;
			return;
		} else {
			Node newNode = new Node(data);
			rear.next = newNode;
			rear = newNode;
		}
	}

	// delete head element
	private void deQueue() {
		if (front == null && rear == null) {
			System.out.println("queue is empty");
			return;
		} else if (front == rear) {
			front = rear = null;
		} else {
			front = front.next;
		}
	}

	private void printData() {
		Node temp = front;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		QueqeUsingLinkedList queueByList = new QueqeUsingLinkedList();
		queueByList.enQueue(10);
		queueByList.enQueue(20);
		queueByList.enQueue(30);
		queueByList.printData();
		queueByList.deQueue();
		System.out.println("after deQueue");
		queueByList.printData();
	}
}
