package com.leetcode.java;

import java.util.ArrayList;


/**
 * https://leetcode.com/problems/min-stack/
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum 
 * element in constant time.

	push(x) -- Push element x onto stack.
	pop() -- Removes the element on top of the stack.
	top() -- Get the top element.
	getMin() -- Retrieve the minimum element in the stack.
	
 *
 *
 */



public class MinStack {
	
	private ArrayList<Integer> list = new ArrayList<Integer>();
	private Integer min;
	
	
    public void push(int x) {
    	list.add(new Integer(x));
    	if(list.size()==1){
    		min=list.get(0);
    	}
    	else{
    		if(min > new Integer(x)){
    			min = list.get(list.size()-1);
    		}
    	}
    	
    	

	}

    public void pop() {
    	int size = list.size();
    	if(size > 0){
    		list.remove(size-1);
    		resetMin();
    	}
        
    }

    public int top() {
    	
    	int size = list.size();
    	int value = 0;
    	if(size > 0){
    		value = list.get(size-1);
    	}
    	else{
    		throw new MyStackOutOfBoundaryException();
    	}
    	return value;

    	
        
    }

    public int getMin(){
    	if(list.size() > 0){
    		return min.intValue();
    	}
    	else{
    		throw new MyStackOutOfBoundaryException();
    	}
        
    }
    
    private void resetMin() {
    	if(list.size() > 0){
    		Integer minum = list.get(0);
    		for(Integer temp : list){
    			if(temp < minum){
    				minum = temp;
    			}
    		}
    		this.min = minum;
    	}
//    	else{
//    		throw new NullPointerException();
//    	}
    }
    
    public static void main(String args[]){
    	MinStack stack = new MinStack();
    	stack.push(10);
    	stack.push(12);
    	System.out.println("min="+stack.getMin());
    	stack.pop();
    	System.out.println("min="+stack.getMin());
    	stack.push(8);
    	System.out.println("min="+stack.getMin());
    	
    }

}

class MyStackOutOfBoundaryException extends RuntimeException{
	
}

