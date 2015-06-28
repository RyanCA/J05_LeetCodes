package com.citi;

public class ReverseString {
	
	public static String reverse(String temp){
		
//		if(temp == null){
//			throw new NullPointerException();
//		}
		
        byte[] byteSeq = temp.getBytes();
        
        for(byte a : byteSeq){
        	System.out.println((char)(a));
        }
        
    	for(int i = 1; i<=byteSeq.length/2; i++){
    		byte tempByte = byteSeq[i-1];
    		byteSeq[i-1]=byteSeq[byteSeq.length-i];
    		byteSeq[byteSeq.length-i] = tempByte;
    	
        }
    	
    	String result =  new String(byteSeq);
    	System.out.println("result="+result);
    	
    	return result;
        
	}
	
	
	public static void main(String args[]){
		
		//reverse(null);
		reverse(new String());
		reverse(new String(""));
		reverse(new String("a"));
		reverse(new String("abc"));
		reverse(new String("abcd"));

		
	}

}
