package com.tree;

public interface BinaryTreeInterface<E>{
	
	public void setTree(E root);
	
	public void setTree(E root,BinaryTreeInterface<E> leftTree,BinaryTreeInterface<E> rightTree);
	
	public boolean find(E element);	
	
	public int getHeight();
	
	public int getNumberOfNodes();
	
	public boolean isEmpty();
	
	public void clear();
	
	public void printTree(int type);
}
