package com.list;

public interface ListInterface<E>{
	public boolean add(E element);
	
	public boolean add(int index, E element);
	
	public E remove(int index);
	
	public E get(int index);
	
	public boolean replace(int index,E element);
	
	public boolean contains(E element);
	
	public void clear();
	
	public int getLength();	
	
	public boolean isEmpty();
	
	public boolean isFull();
	
	public void printList();
}
