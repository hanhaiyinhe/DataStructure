package com.queue;

import java.io.Serializable;

public class ArrayQueue<E> implements QueueInterface<E>, Serializable {
	private E[] queue;
	private int front;
	private int rear;
	private int count;
	private static final int DEFAULT_CAPACITY=10;
	
	public ArrayQueue(){
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayQueue(int capacity){
		queue=(E[])new Object[capacity];
		front=0;
		rear=0;
		count=0;
	}
	

	@Override
	public void enqueue(E element) {
		// TODO Auto-generated method stub
		if(isFull()){
			doubleArray();
		}
		if(isEmpty()){
			front=front+1;
		}
		rear=(rear+1)%queue.length;
		queue[rear]=element;
		count++;
	}
	
	private void doubleArray(){
		E[] oldQueue=queue;
		int oldSize=queue.length;
		queue=(E[])new Object[2*oldSize];
		for(int i=0;i<oldSize;i++){
			queue[i]=oldQueue[i];
		}
		front=0;
		rear=oldSize-1;
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		E e=null;
		if(!isEmpty()){
			e=queue[front];
			queue[front]=null;
			front=(front+1)%queue.length;
			count--;
		}
		return e;
	}

	@Override
	public E getFront() {
		// TODO Auto-generated method stub
		E e=null;
		if(!isEmpty()){
			e=queue[front];
		}
		return e;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count==0;
	}
	
	private boolean isFull(){
		return count==queue.length;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub\
		while(!isEmpty()){
			dequeue();
		}
		front=0;
		rear=0;
	}

	@Override
	public void printQueue() {
		// TODO Auto-generated method stub
		System.out.print("ArrayQueue: ");
		if(!isEmpty()&&(rear>=front)){
			for(int i=front;i<=rear;i++){
				System.out.print(queue[i]+" ");
			}
		}
		else if(!isEmpty()){
			for(int i=front;i<queue.length;i++){
				System.out.print(queue[i]+" ");
			}
			for(int i=0;i<=rear;i++){
				System.out.print(queue[i]+" ");
			}
		}		
		System.out.println();
	}

}
