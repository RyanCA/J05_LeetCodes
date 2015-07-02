package com.leetcode.java;


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



public class MinStackByLink {
	
	private Node<Integer> first;
	private Node<Integer> last;
	private Integer min;
	
	
    public void push(int x) {
    	if(first==null && last==null){
    		Node<Integer> temp = new Node<Integer>(null, new Integer(x), null);
    		first = temp;
    		last = temp;
    		last.setPre(null);
    		last.setNext(null);
    		min = temp.getValue();
    	}
    	else{
    		Node<Integer> temp = new Node<Integer>(null, new Integer(x), null);
    		last.setNext(temp);
    		temp.setPre(last);
    		last = temp;
    		if(temp.getValue() < min) {
    			min = temp.getValue();
    		}
    	}

	}

    public void pop() {
    	if(last != null){
    		if(last.getPre() != null){
    			last = last.getPre();
    			this.setMin();
    		}
    		//The only one node in list
    		else{
    			first = null;
    			last = null;
    		}
    	}
        
    }

    public int top() {
    	//Stack has not been formed
    	if(last == null & first == null){
    		throw new NullPointerException();
    	}
    	
    	return last.getValue();
        
    }

    public int getMin() {
    	//Stack has not been formed yet
    	if(first == null && last == null){
    		throw new NullPointerException();
    	}
    	
        return min.intValue();
    }
    
    private void setMin() {
    	//Stack has not been formed yet
    	if(first == null && last == null){
    		throw new NullPointerException();
    	}
    	
    	Node<Integer> temp = first;
    	Integer minInteger = first.getValue();
    	while(temp.getNext() != null){
    		if(temp.getNext().getValue()<minInteger){
    			minInteger = temp.getNext().getValue();
    		}
    		temp = temp.getNext();
    	}
        min = minInteger;
    }

}

class Node<Integer>{
    private Integer item;
    private Node<Integer> pre;
    private Node<Integer> next;
    
    public Node(Node<Integer> pre, Integer item, Node<Integer> next){
    	this.pre = pre;
    	this.item = item;
    	this.next = next;
    }
    
    public Integer getValue(){
    	return this.item;
    }
    
    public void setValue(Integer value){
    	this.item = value;
    }
    
    public Node<Integer> getPre(){
    	return this.pre;
    }
    
    public void setPre(Node<Integer> pre){
    	this.pre = pre;
    }
    
    public Node<Integer> getNext(){
    	return this.next;
    }
    
    public void setNext(Node<Integer> next){
    	this.next = next;
    }
	
}
