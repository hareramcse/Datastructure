package com.hs.stack.geekforgeeks;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {
	public static void main(String[] args) {
        Stack<Integer> stack    = new Stack<Integer>();
        Stack<Integer> maxStack = new Stack<Integer>(); // keeps track of maximums

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int query = scan.nextInt();
            switch (query) {
                case 1:
                    int x = scan.nextInt();
                    stack.push(x);
                    if (maxStack.isEmpty() || x >= maxStack.peek()) {
                        maxStack.push(x);
                    }
                    break;
                case 2:
                    int poppedValue = stack.pop();
                    if (poppedValue == maxStack.peek()) {
                        maxStack.pop();
                    }
                    break;
                case 3:
                    System.out.println(maxStack.peek());
                    break;
                default:
                    break;
            }
        }        
        scan.close();
    }
}
