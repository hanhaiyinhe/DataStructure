package com.list;

public class AList<E> implements ListInterface<E> {
	private E[] list;		//固定大小的数组
	private int length;		//线性表的长度
	private final static int MAX_SIZE=50;//默认数组的大小
	
	public AList(){
		this(MAX_SIZE);
	}
	
	public AList(int size){
		this.length=0;
		list=(E[])new Object[size];
	}
	

	@Override
	public boolean add(E element) {
		// TODO Auto-generated method stub
		boolean isSuccessful=false;
		if(!isFull()){
			list[length++]=element;
			isSuccessful=true;
		}
		return isSuccessful;
	}

	@Override
	public boolean add(int index, E element) {
		// TODO Auto-generated method stub
		boolean isSuccessful=false;
		if(!isFull()&&(index>=1)&&(index<=length+1)){
			for(int i=length;i>=index;i--){
				list[i]=list[i-1];
			}
			list[index-1]=element;
			length++;
			isSuccessful=true;
		}
		return isSuccessful;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		E e=null;
		if(!isEmpty()&&(index>=1)&&(index<=length)){
			e=list[index-1];
			for(int i=index;i<length;i++){
				list[i-1]=list[i];
			}
			length--;
		}
		return e;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		E e=null;
		if(!isEmpty()&&(index>=1)&&(index<=length)){
			e=list[index-1];
		}
		return e;
	}

	@Override
	public boolean replace(int index, E element) {
		// TODO Auto-generated method stub
		boolean isSuccessful=false;
		if(!isEmpty()&&(index>=1)&&(index<=length)){
			list[index-1]=element;
			isSuccessful=true;
		}
		return isSuccessful;
	}

	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		boolean isFound=false;
		if(!isEmpty()){
			for(int i=0;i<length-1;i++){
				if(list[i].equals(element)){
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
		if(!isEmpty()){
			for(int i=length-1;i>=0;i--){
				list[i]=null;
			}
		}
		length=0;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return length;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return length==0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return length==list.length;
	}

	@Override
	public void printList() {
		// TODO Auto-generated method stub
		System.out.print("AList:");
		if(!isEmpty()){
			for(int i=0;i<length;i++){
				System.out.print(list[i]+" ");
			}
		}
		System.out.println();
	}

}
