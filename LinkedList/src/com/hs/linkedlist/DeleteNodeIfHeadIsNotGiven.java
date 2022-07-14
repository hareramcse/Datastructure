package com.hs.linkedlist;

import com.hs.basic.Node;

// 237. Delete Node in a Linked List Leetcode
public class DeleteNodeIfHeadIsNotGiven {
	public void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
