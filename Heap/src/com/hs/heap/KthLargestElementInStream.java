package com.hs.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElementInStream {

	/*
	 * using min heap DS
	 * 
	 * how data are stored in min Heap DS 1 2 3 if k==3 , then top element of heap
	 * itself the kth largest largest element
	 * 
	 */
	static PriorityQueue<Integer> min;
	static int k;

	static List<Integer> getAllKthNumber(int arr[]) {

		// list to store kth largest number
		List<Integer> list = new ArrayList<>();

		// one by one adding values to the min heap
		for (int val : arr) {

			// if the heap size is less than k , we add to
			// the heap
			if (min.size() < k)
				min.add(val);

			/*
			 * otherwise , first we compare the current value with the min heap TOP value
			 * 
			 * if TOP val > current element , no need to remove TOP , bocause it will be the
			 * largest kth element anyhow
			 * 
			 * else we need to update the kth largest element by removing the top lowest
			 * element
			 */

			else {
				if (val > min.peek()) {
					min.poll();
					min.add(val);
				}
			}

			// if heap size >=k we add
			// kth largest element
			// otherwise -1

			if (min.size() >= k)
				list.add(min.peek());
			else
				list.add(-1);
		}
		return list;
	}

//Driver Code
	public static void main(String[] args) {
		min = new PriorityQueue<>();

		k = 4;

		int arr[] = { 1, 2, 3, 4, 5, 6 };

		List<Integer> res = getAllKthNumber(arr);

		for (int x : res)
			System.out.print(x + " ");
	}

	// This code is Contributed by Pradeep Mondal P

}