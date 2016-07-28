package com.queue;

public interface DequeInterface<E> {
	public void addToFront(E element);
	
	public void addToBack(E element);
	
	public E removeFront();
	
	public E removeBack();

	public E getFront();
	
	public E getBack();
	
	public boolean isEmpty();
	
	public void clear();
	
	public void printDeque();
	
	public void printReDeque();
	
}
