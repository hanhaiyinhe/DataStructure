package com.queue;

import java.io.Serializable;

public class LinkQueue<E> implements QueueInterface<E>, Serializable {
	
	private Node front;
	private Node rear;
	
	public LinkQueue(){
		front=null;
		rear=null;
	}

	@Override
	public void enqueue(E element) {
		// TODO Auto-generated method stub
		if(isEmpty()){
			front=new Node(element,null);
			rear=front;
		}
		else{
			Node newNode=new Node(element);
			rear.next=newNode;
			rear=rear.next;
		}
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		E e=null;
		if(!isEmpty()){
			e=front.data;
			front=front.next;
			if(front==null)
				rear=null;
		}
		return e;
	}

	@Override
	public E getFront() {
		// TODO Auto-generated method stub
		E e=null;
		if(!isEmpty()){
			e=front.data;
		}
		return e;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return front==null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		front=null;
		rear=null;
	}

	@Override
	public void printQueue() {
		// TODO Auto-generated method stub
		System.out.print("LinkQueue: ");
		Node node=front;
		while(node!=null){
			System.out.print(node.data+" ");
			node=node.next;
		}
		System.out.println();
	}
	
	private class Node{
		private E data;
		private Node next;
		
		public Node(E element){
			this.data=element;
			this.next=null;
		}

		public Node(E element,Node next){
			this.data=element;
			this.next=next;
		}
				
	}

}
