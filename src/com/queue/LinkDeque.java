package com.queue;

public class LinkDeque<E> implements DequeInterface<E> {
	private DNode front;
	private DNode rear;
	
	public LinkDeque(){
		front=null;
		rear=null;
	}
	

	@Override
	public void addToFront(E element) {
		// TODO Auto-generated method stub
		DNode newNode=new DNode(element);
		if(isEmpty()){
			front=newNode;
			rear=newNode;
		}
		else{
			newNode.next=front;
			front.prev=newNode;
			front=newNode;
		}
	}

	@Override
	public void addToBack(E element) {
		// TODO Auto-generated method stub
		DNode newNode=new DNode(element);
		if(isEmpty()){
			rear=newNode;
			front=newNode;
		}else{
			rear.next=newNode;
			newNode.prev=rear;
			rear=newNode;
		}
	}

	@Override
	public E removeFront() {
		// TODO Auto-generated method stub
		E e=null;
		if(!isEmpty()){
			if(front.next==null){
				e=front.data;
				front=null;
				rear=null;
			}
			else{
				DNode p=front;
				e=p.data;
				front=p.next;
				front.prev=null;
			}
		}
		return e;
	}

	@Override
	public E removeBack() {
		// TODO Auto-generated method stub
		E e=null;
		if(!isEmpty()){
			if(front.next==null){
				e=rear.data;
				front=null;
				rear=null;
			}
			else{
				DNode p=rear;
				e=p.data;
				rear=p.prev;
				rear.next=null;
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
		front=null;
		rear=null;
	}
	
	@Override
	public void printDeque() {
		// TODO Auto-generated method stub
		System.out.print("LinkDeque: ");
		if(!isEmpty()){
			DNode p=front;
			while(p!=null){
				System.out.print(p.data+" ");
				p=p.next;
			}
		}
		System.out.println();
	}


	@Override
	public void printReDeque() {
		// TODO Auto-generated method stub
		System.out.print("LinkReDeque: ");
		if(!isEmpty()){
			DNode p=rear;
			while(p!=null){
				System.out.print(p.data+" ");
				p=p.prev;
			}
		}
		System.out.println();
	}
	
	private class DNode{
		private E data;
		private DNode prev;
		private DNode next;
		
		public DNode(E element){
			this.data=element;
			this.prev=null;
			this.next=null;
		}
		
		public DNode(E element, DNode prev, DNode next){
			this.data=element;
			this.prev=prev;
			this.next=next;
		}
	}

}
