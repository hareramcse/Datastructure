package com.hs.queue.basic;

import java.util.LinkedList;

public class ImplementQueqeUsingLinkedList {
	LinkedList<Integer> ll = new LinkedList<>();

	// insert at last index
	private void enQueue(int data) {
		ll.addLast(data);
	}

	// delete head element
	private void deQueue() {
		ll.removeFirst();
	}

	private void printData() {
		for (Integer i : ll) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		ImplementQueqeUsingLinkedList queueByList = new ImplementQueqeUsingLinkedList();
		queueByList.enQueue(10);
		queueByList.enQueue(20);
		queueByList.enQueue(30);
		queueByList.printData();
		queueByList.deQueue();
		System.out.println("after deQueue");
		queueByList.printData();
	}
}