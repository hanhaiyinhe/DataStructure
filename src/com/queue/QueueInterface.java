package com.queue;

public interface QueueInterface<E> {
	public void enqueue(E element);
	
	public E dequeue();
	
	public E getFront();
	
	public boolean isEmpty();
	
	public void clear();
	
	public void printQueue();
}
