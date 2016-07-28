package com.stack;

import java.io.Serializable;
import java.util.Vector;

public class VectorStack<E> implements StackInterface<E>, Serializable {
	private Vector<E> stack;
	
	public VectorStack(){
		stack=new Vector();
	}
	
	public VectorStack(int size){
		stack=new Vector(size);
	}

	@Override
	public void push(E element) {
		// TODO Auto-generated method stub
		stack.addElement(element);
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		E top=null;
		if(!isEmpty()){
			top=stack.lastElement();
			stack.removeElementAt(stack.size()-1);
		}
		return top;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		E top=null;
		if(!isEmpty()){
			top=stack.lastElement();
		}
		return top;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return stack.isEmpty();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		stack.removeAllElements();
	}

	@Override
	public void printStack() {
		// TODO Auto-generated method stub
		System.out.print("VectorStack: ");
		for(int i=stack.size()-1;i>=0;i--){
			System.out.print(stack.get(i)+" ");
		}
		System.out.println();
	}

}
