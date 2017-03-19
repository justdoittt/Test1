package com.gy;

public class Calculator {
	
	private static int result = 0;
	
	public void add(int n){
		result = result +n;
	}
	
	public void sub(int n){
		result = result -1;//bug
	}
	
	public void multi(int n){
		result = result*n;
	}
	
	public void devide(int n){
		if(n!=0){
			result = result/n;
		}
	}
	
	public void clear(){
		result = 0;
	}
	
	public int getResult(){
		return this.result;
	}

}
