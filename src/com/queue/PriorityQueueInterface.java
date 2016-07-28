package com.queue;

public interface PriorityQueueInterface<E> {
	public void add(E element);
	
	public E remove();
	
	public E peek();
	
	public boolean isEmpty();
	
	public int getSize();
	
	public void clear();
}
