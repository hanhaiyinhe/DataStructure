package com.stack;

import java.io.Serializable;

public class LinkStack<E> implements StackInterface<E>{
	private Node stack;
	
	public LinkStack(){
		stack=null;
	}
	
	@Override
	public void push(E element) {
		// TODO Auto-generated method stub
		Node newNode=new Node(element,stack);
		stack=newNode;
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		E top=null;
		if(!isEmpty()){
			top=stack.data;
			stack=stack.next;
		}
		return top;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		E top=null;
		if(!isEmpty()){
			top=stack.data;
		}
		return top;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return stack==null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		stack=null;
	}
	
	@Override
	public void printStack() {
		// TODO Auto-generated method stub
		System.out.print("Link Stack: ");
		Node top=stack;
		while(top!=null){
			System.out.print(top.data+" ");
			top=top.next;
		}
		System.out.println();
		
	}
	
	private class Node implements Serializable{
		private E data;
		private Node next;
		
		public Node(E element,Node next){
			this.data=element;
			this.next=next;
		}		
	}

}
