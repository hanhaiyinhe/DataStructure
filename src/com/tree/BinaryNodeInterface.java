package com.tree;

public interface BinaryNodeInterface<E> {
	
	public E getData();
	
	public void setData(E data);
	
	public BinaryNodeInterface<E> getLeftChild();
	
	public BinaryNodeInterface<E> getRightChild();
	
	public void setLeftChild(BinaryNodeInterface<E> leftChild);
	
	public void setRightChild(BinaryNodeInterface<E> rightChild);
	
	public boolean hasLeftChild();
	
	public boolean hasRightChild();
	
	public boolean isLeaf();
	
	public int getNodeHeight();
	
	public int getNumberOfNodes();
	
	public BinaryNodeInterface<E> copy();
}
