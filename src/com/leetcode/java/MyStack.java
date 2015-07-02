package com.leetcode.java;


/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 * 
 * In Leetscode, the class name should be MyStack, otherwise, it doesn't work
 * 
 * LinkedList implements the Queue interface, providing first in, 
 * first out (FIFO) queue operations for add, poll, and so on.
 * 
 * You must use only standard operations of a queue -- which means only 
 * push to back, peek/pop from front, size, and is empty operations are valid.
 * 
 * You can use below Queue methods to implement your Queue
 * push(), peek(), poll(), isEmpty, size()
 * 
 * 
 */


public class MyStack{//StackUsing2Queues
	
	/**
	 * Define two queues, when stack invoking pop() or top() methods, ensure p1
	 * has only one elements left and others are transfered to p2;
	 * Remember to swap p1 and p2 before ending of the pop() and top() methods
	 * 
	 * 
	 * Simillary, two stacks can be used to implement the functions of a queue
	 */
	
	private MyQueue q1 = new MyQueue();
	private MyQueue q2 = new MyQueue();
	
    // Push element x onto stack.
    public void push(int x) {
        q1.push(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
    	if(q1.size()>0){
    		while(q1.size()!=1){
    			q2.push(q1.poll().getValue());
    		}
    		MyQueue temp = q1;
        	q1=q2;
        	q2=temp;
        	q2.poll();
    	}
    	
    }

    // Get the top element.
    public int top() {
    	if(q1.size()>0){
    		while(q1.size()!=1){
    			q2.push(q1.poll().getValue());
    		}
        	int value = q1.peek().getValue();
        	q2.push(q1.poll().getValue());
        	//q1 is empty, q2 is full now. And swap them
        	MyQueue temp = q1;
        	q1=q2;
        	q2=temp;
        	return value;
    	}
    	else{
    		throw new QueueNodeNullException();
    	}
 
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.size()==0?true:false;
    }
    
    public static void main(String args[]){
    	MyStack q = new MyStack();
    	q.push(10);
    	q.push(11);
    	q.push(12);
    	System.out.println(" peek value="+q.top());
    	
    	System.out.println(" pop ");
    	q.pop();
    	System.out.println(" peek value="+q.top());
    	
    	System.out.println(" pop ");
    	q.pop();
    	System.out.println(" peek value="+q.top());
    	
//    	System.out.println(" pop ");
//    	q.pop();
//    	System.out.println(" peek value="+q.top());

    	
    }
}

class MyQueue{
	
	private QueueNode first = null;
	private QueueNode last = null;
	private int size = 0;
	
	public void push(int x){
		//First node of the queue
		if(size == 0){
			last = new QueueNode(x);
			first = last;
		}
		else{
			QueueNode temp = new QueueNode(x);
			last.setNext(temp);
			temp.setPre(last);
			last = temp;
		}
		size++;
	}
	
	public QueueNode poll(){
		if(size == 0){
			return null;
		}
		
		QueueNode node = first;
		
		if(first == last){
			last = null;
			first = null;
		}
		else{
			first = first.getNext();
			first.setPre(null);
		}
		size--;
		return node;
	}
	
	public QueueNode peek(){
		return first;
	}
	
	public int size(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return size == 0 ? true : false;
	}
}

class QueueNode {
	private int value;
	private QueueNode pre;
	private QueueNode next;
	
	private QueueNode(QueueNode pre, int value, QueueNode next){
		this.pre = pre;
		this.value = value;
		this.next = next;
	}
	
	public QueueNode(int value){
		this(null, value, null);
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	public QueueNode getPre(){
		return this.pre;
	}
	
	public void setPre(QueueNode pre){
		this.pre = pre;
	}
	
	public QueueNode getNext(){
		return this.next;
	}
	
	public void setNext(QueueNode next){
		this.next = next;
	}
	
}

class QueueNodeNullException extends RuntimeException{
	
}