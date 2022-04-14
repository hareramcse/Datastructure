package com.hs.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// Leetcode MEDIUM
// some test cases are failing
public class KClosestNumber {

	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        Queue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < arr.length; i++){
            maxHeap.add(new Pair(Math.abs(arr[i]-x), arr[i]));
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        
        while(!maxHeap.isEmpty())
        {
            list.add(maxHeap.poll().value);
        }
        Collections.sort(list);
        return list;
    }
    
    public static void main(String[] args){
    	KClosestNumber sol = new KClosestNumber();
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        List<Integer> res = sol.findClosestElements(arr, k, x);
        System.out.println(res);
    }
}