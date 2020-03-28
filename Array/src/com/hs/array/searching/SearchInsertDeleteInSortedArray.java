package com.hs.array.searching;

import java.util.Arrays;

public class SearchInsertDeleteInSortedArray {
	private int search(int[] arr, int value) {
		int low = 0;
		int high = arr.length-1;
		int mid = (low+high)/2;
		
		while(low<=high) {
			if(arr[mid] == value) {
				return mid;
			}
			
			if(arr[mid] > value) {
				mid = mid-1;
			}else {
				mid = mid+1;
			}
		}
		
		return -1;
	}
	
	private int insert(int[] arr, int capacity, int n, int value) {
		if(n >= capacity) {
			return -1;
		}
		int i; 
        for (i = n - 1; (i >= 0 && arr[i] > value); i--) 
            arr[i + 1] = arr[i]; 
  
        arr[i + 1] = value;
		return i+1;
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
		SearchInsertDeleteInSortedArray se = new SearchInsertDeleteInSortedArray();
		// taking sorted array just for simplicity
		int[] arr = new int[]{1,2,3,4,5,6,7,8};
		int index = se.search(arr, 3);
		System.out.println(index);
		
		int capacity = 10;
		arr = new int[capacity];
		arr[0] = 5;
		arr[1] = 10;
		arr[2] = 15;
		arr[3] = 20;
		arr[4] = 25;
		arr[5] = 30;
		arr[6] = 40;
		
		int n = 7;
		
		index = se.insert(arr, capacity, n, 17);
		System.out.println("value inserted at " + index + " and array is " + Arrays.toString(arr));
		
		index = se.delete(arr, 17);
		System.out.println("Array after deletion 17, " + Arrays.toString(arr));
	}
}
