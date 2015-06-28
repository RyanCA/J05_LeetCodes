package com.citi;

import java.util.Iterator;
import java.util.LinkedList;

public class AverageOfLinkedList {
	
	public static float averageOfLinkedList(LinkedList<Integer> ll){
		if(ll == null ){
			throw new NullPointerException();
		}
		if(ll.size() ==0 ){
			return 0;
		}
		Iterator ite = ll.iterator();
		int total = 0;
		int size = ll.size();
		while(ite.hasNext()){
			Integer temp = (Integer)ite.next();
			total = total + temp;
		}
		float average = total/size;
		return average;
		
	}
	
	public static void main(String args[]){
		LinkedList a = null;
		LinkedList<Float> b = new LinkedList<Float>();
		LinkedList<Integer> c = new LinkedList<Integer>();
		LinkedList<Integer> d = new LinkedList<Integer>();
		d.add(new Integer(10));
		d.add(new Integer(20));
		
		//averageOfLinkedList(a);
		//averageOfLinkedList(b);
		System.out.println(averageOfLinkedList(c));
		System.out.println(averageOfLinkedList(d));
	}

}
