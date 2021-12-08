package com.hs.introduction;

import java.util.LinkedList;

public class Graph {
	int v;
	LinkedList<Integer> arrLinkedList[];

	public Graph(int v) {
		this.v = v;
		arrLinkedList = new LinkedList[v];
		
		for(int i = 0; i< 5; i++) {
			arrLinkedList[i] = new LinkedList();
		}
	}

	public static void addEdge(Graph graph, int source, int destination) {
		graph.arrLinkedList[source].addFirst(destination);
		graph.arrLinkedList[destination].addFirst(source);
	}
	
	public void print() {
		for(int i=0; i<5;i++) {
			LinkedList<Integer> temp = arrLinkedList[i];
			for(int j=0; j<temp.size(); j++) {
				System.out.print(temp.get(j) + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int V = 5;
		Graph graph = new Graph(V);
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 4);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 4);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);
		
		graph.print();
	}
}
