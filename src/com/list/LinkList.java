package com.list;

public class LinkList<E> implements ListInterface<E> {
	private Node head;
	
	private class Node{
		private E data;
		private Node next;
		
		private Node(E data){
			this.data=data;
			this.next=null;
		}
		
		private Node(E data,Node next){
			this.data=data;
			this.next=next;
		}
	}

	@Override
	public boolean add(E element) {
		// TODO Auto-generated method stub
		Node p=head;
		while(p.next!=null)
			p=p.next;
		Node newNode=new Node(element);
		p.next=newNode;
		return true;
	}

	@Override
	public boolean add(int index, E element) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		E e=null;
		if(!isEmpty()&&(index>=1)){
			Node p=head;
			while((p!=null)&&(index>1)){
				p=p.next;
				index--;
			}
			e=p.data;
		}
		return e;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		E e=null;
		if(!isEmpty()&&(index>=1)){
			Node p=head;
			while((p!=null)&&(index>1)){
				p=p.next;
				index--;
			}
			e=p.data;
		}
		return e;
	}

	@Override
	public boolean replace(int index, E element) {
		// TODO Auto-generated method stub
		boolean isSuccessful=false;
		if(!isEmpty()&&(index>=1)){
			Node p=head;
			while((p!=null)&&(index>1)){
				p=p.next;
				index--;
			}	
			
		}
		return isSuccessful;
	}

	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		boolean isFound=false;
		if(!isEmpty()){
			Node p=head;
			while(p!=null){
				if(p.data.equals(element)){
					isFound=true;
					break;
				}
				else{
					p=p.next;
				}
			}
		}
		return isFound;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head=null;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		int length=0;
		Node p=head;
		while(p!=null){
			length++;
			p=p.next;
		}
		return length=0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head==null;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void printList() {
		// TODO Auto-generated method stub
		Node p=head;
		System.out.print("LinkList:");
		while(p!=null){
			System.out.print(p.data+" ");
			p=p.next;
		}
		System.out.println();
	}

}
