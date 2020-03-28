package com.hs.array.searching;

import java.util.Arrays;

public class SearchInsertDeleteInUnSortedArray {
	private int search(int[] arr, int value) {
		for(int i = 0; i < arr.length-1; i++ ) {
			if(arr[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	private int insert(int[] arr, int capacity, int n, int value) {
		if(n >= capacity) {
			return -1;
		}
		arr[n] = value;
		return n;
		
	}
	
	private int delete(int[] arr, int value) {
		int index = search(arr, value);
		if(index != -1) {
			for(int i = index; i< arr.length-2; i++ ) {
				arr[i] = arr[i+1];
			}
		}
		return index;
	}
	public static void main(String[] args) {
		SearchInsertDeleteInUnSortedArray se = new SearchInsertDeleteInUnSortedArray();
		// taking sorted array just for simplicity
		int[] arr = new int[]{1,2,3,4,5,6,7,8};
		int index = se.search(arr, 3);
		System.out.println(index);
		
		int capacity = 10;
		arr = new int[capacity];
		arr[0] = 15;
		arr[1] = 20;
		arr[2] = 25;
		arr[3] = 30;
		
		int n = 4;
		
		index = se.insert(arr, capacity, n, 26);
		System.out.println("value inserted at " + index);
		
		index = se.delete(arr, 25);
		System.out.println("Array after deletion 25, " + Arrays.toString(arr));
	}
}
