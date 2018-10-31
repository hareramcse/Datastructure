package com.hs.array.rotation;

import java.util.Arrays;

public class TwoReversalArrayRotation {
	
	private void arrayReversal(int arr[], int start, int end){
		while(start<end) {
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
	}
	
	private void leftRotate(int arr[], int d) {
		int n=arr.length;
		arrayReversal(arr, 0, d-1);
		arrayReversal(arr, d, n-1);
		arrayReversal(arr, 0, n-1);
	}
	
	
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6,7};
		int d=2;
		TwoReversalArrayRotation rotation= new  TwoReversalArrayRotation();
		rotation.leftRotate(arr, d);
		System.out.println(Arrays.toString(arr));
	}
}