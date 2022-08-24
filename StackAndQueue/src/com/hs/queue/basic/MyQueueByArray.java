package com.hs.queue.basic;

public class MyQueueByArray {
	int front;
	int rear;
	int size;
	int queue[];

	MyQueueByArray(int size) {
		this.front = -1;
		this.rear = -1;
		this.size = size;
		queue = new int[size];
	}

	private void enQueue(int data) {
		// if((rear+1)%size==front){ for circular array
		if (isFull()) {
			System.out.println("queue is full");
			return;
		} else if (isEmpty()) {
			front = rear = 0;
		} else {
			rear = rear + 1;
			// rear=(rear+1)%size; for circular array
		}
		queue[rear] = data;
	}

	private void deQueue() {
		if (isEmpty()) {
			System.out.println("queue is empty");
			return;
		} else if (front == rear) {
			front = rear = -1;
		} else {
			front = front + 1;
			// front=(front+1)%size;
		}
	}

	private boolean isEmpty() {
		if (front == -1 && rear == -1) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isFull() {
		if (rear == size) {
			return true;
		} else {
			return false;
		}
	}

	private void printData() {
		for (int i = front; i <= rear; i++) {
			System.out.println(queue[i]);
		}
	}

	public static void main(String[] args) {
		MyQueueByArray queueArray = new MyQueueByArray(10);
		queueArray.enQueue(10);
		queueArray.enQueue(20);
		queueArray.enQueue(30);
		queueArray.printData();
		queueArray.deQueue();
		System.out.println("after deQueqe");
		queueArray.printData();
		System.out.println("3 modulo 10 is " + 3 % 10);
	}
}
