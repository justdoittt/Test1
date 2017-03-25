package com.gy;


public class Solution {
    public String reverseString(String s) {
		char[] arr =s.toCharArray();
		for(int i =0,j=arr.length-1;i<j;i++,j--){
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		String s1 = new String(arr);
       return s1;
       
        
    }
}
