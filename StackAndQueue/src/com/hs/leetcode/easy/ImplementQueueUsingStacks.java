package com.hs.leetcode.easy;

import java.util.Stack;

public class ImplementQueueUsingStacks {
	private Stack<Integer> input = new Stack<>();
    private Stack<Integer> output = new Stack<>();
    
    public ImplementQueueUsingStacks() {
        
    }
    
    public void push(int x) {
        input.add(x);
    }
    
    public int pop() {
        if(output.isEmpty()){
            shiftStacks();
        }
        return output.pop();
    }
    
    public int peek() {
        if(output.isEmpty()){
            shiftStacks();
        }
        return output.peek();
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
    
    private void shiftStacks(){
        while(!input.isEmpty()){
            int temp = input.pop();
            output.add(temp);
        }
    }
}
