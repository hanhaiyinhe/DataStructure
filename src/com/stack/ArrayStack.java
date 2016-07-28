package com.stack;

import java.io.Serializable;

public class ArrayStack<E> implements StackInterface<E>, Serializable {
	private E[] stack;
	private int top;
	private static final int DEFAULT_CAPACITY=50;
	
	public ArrayStack(){
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayStack(int initCapacity){
		stack=(E[])new Object[initCapacity];
		top=-1;
	}

	@Override
	public void push(E element) {
		// TODO Auto-generated method stub
		top++;
		if(top==stack.length){
			doubleArray();
		}
		stack[top]=element;
	}
	
	private void doubleArray(){
		E[] oldStack=stack;
		int oldSize=stack.length;
		stack=(E[])new Object[oldSize*2];
		for(int i=0;i<oldSize;i++){
			stack[i]=oldStack[i];
		}
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		E e=null;
		if(!isEmpty()){
			e=stack[top];
			stack[top]=null;
			top--;
		}
		return e;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		E e=null;
		if(!isEmpty()){
			e=stack[top];
		}
		return e;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top==-1;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		while(!isEmpty()){
			pop();
		}
	}

	@Override
	public void printStack() {
		// TODO Auto-generated method stub
		System.out.print("ArrayStack: ");
		for(int i=top;i>=0;i--){
			System.out.print(stack[i]+" ");
		}
		System.out.println();
	}

}
