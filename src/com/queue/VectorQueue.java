package com.queue;

import java.io.Serializable;
import java.util.Vector;

public class VectorQueue<E> implements Serializable, QueueInterface<E> {
	private Vector<E> queue;
	
	public VectorQueue(){
		queue=new Vector();
	}
	
	public VectorQueue(int capacity){
		queue=new Vector<E>(capacity);
	}

	@Override
	public void enqueue(E element) {
		// TODO Auto-generated method stub
		queue.add(element);
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		E e=null;
		if(!isEmpty()){
			e=queue.remove(0);
		}
		return e;
	}

	@Override
	public E getFront() {
		// TODO Auto-generated method stub
		E e=null;
		if(!isEmpty()){
			e=queue.get(0);
		}
		return e;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return queue.isEmpty();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		queue.clear();
	}

	@Override
	public void printQueue() {
		// TODO Auto-generated method stub
		System.out.print("VectorQueue: ");
		for(int i=0;i<queue.size();i++){
			System.out.print(queue.get(i)+" ");
		}
		System.out.println();
	}

}
