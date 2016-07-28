package com.tree;

public class BinaryNode<E> implements BinaryNodeInterface<E> {
	
	private E data;
	
	private BinaryNode<E> left;
	
	private BinaryNode<E> right;
	
	public BinaryNode(){
		this(null);
	}
	
	public BinaryNode(E data){
		this(data,null,null);
	}
	
	public BinaryNode(E data,BinaryNode<E> left,BinaryNode<E> right){
		this.data=data;
		this.left=left;
		this.right=right;
	}

	@Override
	public E getData() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public void setData(E data) {
		// TODO Auto-generated method stub
		this.data=data;
	}

	@Override
	public BinaryNodeInterface<E> getLeftChild() {
		// TODO Auto-generated method stub
		return left;
	}

	@Override
	public BinaryNodeInterface<E> getRightChild() {
		// TODO Auto-generated method stub
		return right;
	}

	@Override
	public void setLeftChild(BinaryNodeInterface<E> leftChild) {
		// TODO Auto-generated method stub
		this.left=(BinaryNode<E>) leftChild;
	}

	@Override
	public void setRightChild(BinaryNodeInterface<E> rightChild) {
		// TODO Auto-generated method stub
		this.right=(BinaryNode<E>) rightChild;
	}

	@Override
	public boolean hasLeftChild() {
		// TODO Auto-generated method stub
		return left!=null;
	}

	@Override
	public boolean hasRightChild() {
		// TODO Auto-generated method stub
		return right!=null;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return (left==null)&&(right==null);
	}

	@Override
	public int getNodeHeight() {
		// TODO Auto-generated method stub
		return getNodeHeight(this);
	}
	
	private int getNodeHeight(BinaryNode<E> node){
		int height=0;
		if(node!=null)
			height=1+Math.max(getNodeHeight(node.left), getNodeHeight(node.right));
		return height;
	}

	@Override
	public int getNumberOfNodes() {
		// TODO Auto-generated method stub
		int leftNumber=0;
		int rightNumber=0;
		if(left!=null){
			leftNumber=left.getNumberOfNodes();
		}
		if(right!=null)
			rightNumber=right.getNumberOfNodes();
		return leftNumber+rightNumber+1;
	}

	@Override
	public BinaryNodeInterface<E> copy() {
		// TODO Auto-generated method stub
		return null;
	}

}
