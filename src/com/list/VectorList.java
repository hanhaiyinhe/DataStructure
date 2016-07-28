package com.list;

import java.util.Vector;

public class VectorList<E> implements ListInterface<E> {
	private Vector<E> list;
	private final static int INITIAL_CAPACITY=50;
	
	public VectorList(){
		this(INITIAL_CAPACITY);
	}
	
	public VectorList(int initialSize){
		list=new Vector<E>(initialSize);
	}

	@Override
	public boolean add(E element) {
		// TODO Auto-generated method stub
		return list.add(element);
	}

	@Override
	public boolean add(int index, E element) {
		// TODO Auto-generated method stub
		boolean isSuccessful=false;
		if((index>=1)&&(index<=list.size()+1)){
			list.insertElementAt(element, index-1);
			isSuccessful=true;
		}
		return isSuccessful;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		E e=null;
		if(!isEmpty()&&(index>=1)&&(index<=list.size())){
			e=list.remove(index-1);
		}
		return e;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		E e=null;
		if(!isEmpty()&&(index>=1)&&(index<=list.size())){
			e=list.get(index-1);
		}
		return e;
	}

	@Override
	public boolean replace(int index, E element) {
		// TODO Auto-generated method stub
		boolean isSuccessful=false;
		if(!isEmpty()&&(index>=1)&(index<=list.size())){
			list.set(index-1, element);
			isSuccessful=true;
		}
		return isSuccessful;
	}

	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		boolean isFound=false;
		if(!isEmpty()){
			for(int i=0;i<list.size();i++){
				if(list.get(i).equals(element)){
					isFound=true;
					break;
				}
			}
		}
		return isFound;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		list.clear();
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.size()==0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void printList() {
		// TODO Auto-generated method stub
		System.out.print("VectorList:");
		if(!isEmpty()){
			for(int i=0;i<list.size();i++){
				System.out.print(list.get(i)+" ");
			}
		}
		System.out.println();
	}

}
