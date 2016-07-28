package com.queue;

public class LinkLoopDeque<E> implements DequeInterface<E> {
	
	private DLNode front;
	private DLNode rear;
	
	public LinkLoopDeque(){
		front=null;
		rear=null;
	}

	@Override
	public void addToFront(E element) {
		// TODO Auto-generated method stub
		DLNode newNode=new DLNode(element);
		if(isEmpty()){
			front=newNode;
			rear=newNode;
			front.prev=front;
			front.next=front;
			rear.prev=rear;
			rear.next=rear;
		}
		else{
			newNode.next=front;
			newNode.prev=rear;
			front.prev=newNode;
			rear.next=newNode;
			front=front.prev;
		}
	}

	@Override
	public void addToBack(E element) {
		// TODO Auto-generated method stub
		DLNode newNode=new DLNode(element);
		if(isEmpty()){
			rear=newNode;
			front=newNode;
			front.prev=newNode;
			front.next=newNode;
			rear.next=newNode;
			rear.prev=newNode;
		}else{
			rear.next=newNode;
			newNode.prev=rear;
			newNode.next=front;
			front.prev=newNode;
			rear=rear.next;
		}
	}

	@Override
	public E removeFront() {
		// TODO Auto-generated method stub
		E e=null;
		if(!isEmpty()){
			if(front==rear){
				e=front.data;
				front=null;
				rear=null;
			}
			else{
				DLNode p=front;
				e=p.data;
				front=p.next;
				front.prev=rear;
				rear.next=front;
			}
		}
		return e;
	}

	@Override
	public E removeBack() {
		// TODO Auto-generated method stub
		E e=null;
		if(!isEmpty()){
			if(front==rear){
				e=rear.data;
				front=null;
				rear=null;
			}
			else{
				DLNode p=rear;
				e=p.data;
				rear=p.prev;
				rear.next=front;
				front.prev=rear;
			}
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
	public E getBack() {
		// TODO Auto-generated method stub
		E e=null;
		if(!isEmpty()){
			e=rear.data;
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
		while(!isEmpty()){
			removeFront();
		}
		front=null;
		rear=null;
	}
	
	@Override
	public void printDeque() {
		// TODO Auto-generated method stub
		System.out.print("LinkLoopDeque: ");
		if(!isEmpty()){
			DLNode p=front;
			while(p.next!=front){
				System.out.print(p.data+" ");
				p=p.next;
			}
			System.out.print(p.data+" ");
		}
		System.out.println();
	}

	@Override
	public void printReDeque() {
		// TODO Auto-generated method stub
		System.out.print("LinkLoopReDeque: ");
		if(!isEmpty()){
			DLNode p=rear;
			while(p.prev!=rear){
				System.out.print(p.data+" ");
				p=p.prev;
			}
			System.out.print(p.data+" ");
		}
		System.out.println();
	}
	
	private class DLNode{
		private E data;
		private DLNode prev;
		private DLNode next;
		
		public DLNode(E element){
			this.data=element;
			this.prev=null;
			this.next=null;
		}
		
		public DLNode(E element, DLNode prev, DLNode next){
			this.data=element;
			this.prev=prev;
			this.next=next;
		}
	}
}
