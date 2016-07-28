package com.stack;

public interface StackInterface<E> {
	public void push(E element);
	public E pop();
	public E peek();
	public boolean isEmpty();
	public void clear();
	public void printStack();
}
