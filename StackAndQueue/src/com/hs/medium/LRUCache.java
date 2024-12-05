package com.hs.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private Map<Integer, Node> map = new HashMap<>();
	private Node head, tail;
	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;

		Node node = map.get(key);
		removeFromTail(node);
		insertAfterHead(node);
		return node.value;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			removeFromTail(node);
		}
		if (map.size() == capacity) {
			Node node = tail.prev;
			removeFromTail(node);
		}
		insertAfterHead(new Node(key, value));
	}

	private void removeFromTail(Node node) {
		map.remove(node.key);
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	private void insertAfterHead(Node node) {
		map.put(node.key, node);
		node.next = head.next;
		node.next.prev = node;
		head.next = node;
		node.prev = head;
	}

	public static void main(String[] args) {
		LRUCache obj = new LRUCache(2);
		obj.put(1, 1);
		obj.put(2, 2);
		int res = obj.get(1);
		System.out.println(res);
		obj.put(3, 3);
		res = obj.get(2);
		System.out.println(res);
		obj.put(4, 4);
		res = obj.get(1);
		System.out.println(res);
		res = obj.get(3);
		System.out.println(res);
		res = obj.get(4);
		System.out.println(res);
	}
}