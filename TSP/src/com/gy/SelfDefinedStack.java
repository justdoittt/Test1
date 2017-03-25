package com.gy;

import java.util.LinkedList;

public class SelfDefinedStack implements Stack{

	/**
	 * 
	 */
	@Override
	public void push(Object obj) {
     	assert obj!=null;	
		assert wellformed();
		num++;
		list.addFirst(obj);
	}
    /**
     * 
     */
	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		assert wellformed();
		return list.pollFirst();
	}
   /**
    * 
    */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		assert wellformed();
		return list.size();
	}
    /**
     * 
     */
	@Override
	public Object top() {
		// TODO Auto-generated method stub
		assert wellformed();
		if(num!=0)
		return list.getFirst();
		else
			return "empty stack";
	}
	
	 public void clear() {
	      list = new LinkedList<Object>();
	      num = 0;
	    }
	
	public boolean isEmpty() {return list.isEmpty();}
	protected boolean wellformed(){

		if (this.size() < 0 || this.size() > num) { 
            return false; 
        } 
        return true;
	  }
	public String Link()
	{
		LinkedList<Object> lnk = new LinkedList<Object>();
		if(num >= 1)
		{
			lnk = list;
		}
		else
		{
			return "Empty Stack";
		}
		return lnk.toString();
	}
   private LinkedList<Object> list = new LinkedList<Object>();
   private int num = 0;
}
