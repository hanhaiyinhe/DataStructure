package com.tree;

import com.queue.QueueInterface;
import com.stack.LinkStack;
import com.stack.StackInterface;
import com.queue.LinkQueue;

public class LinkBinaryTree<E> implements BinaryTreeInterface<E> {
	private BinaryNodeInterface<E> root;
	
	public LinkBinaryTree(){
		root=null;
	}
	
	public LinkBinaryTree(E rootData){
		root=new BinaryNode<E>(rootData);
	}
	
	public LinkBinaryTree(E rootData, LinkBinaryTree<E> leftTree, LinkBinaryTree<E> rightTree){
		privateSetTree(rootData,leftTree,rightTree);
	}

	@Override
	public void setTree(E rootData) {
		// TODO Auto-generated method stub
		root=new BinaryNode<E>(rootData);
	}

	@Override
	public void setTree(E rootData, BinaryTreeInterface<E> leftTree, BinaryTreeInterface<E> rightTree) {
		// TODO Auto-generated method stub
		privateSetTree(rootData,(LinkBinaryTree<E>)leftTree,(LinkBinaryTree<E>)rightTree);

	}
	
	private void privateSetTree(E rootData,LinkBinaryTree<E> leftTree,LinkBinaryTree<E> rightTree){
		root=new BinaryNode<E>(rootData);
		if((leftTree!=null)&& !leftTree.isEmpty()){
			root.setLeftChild(leftTree.getRoot());
		}
		if((rightTree!=null)&& !rightTree.isEmpty()){
			if(rightTree!=leftTree)
				root.setRightChild(rightTree.getRoot());
			else
				root.setRightChild(rightTree.root.copy());
		}
		
		if((leftTree!=null)&& (leftTree!=this))
			leftTree.clear();
		if((rightTree!=null)&& (rightTree!=this))
			rightTree.clear();
	}
	
	public E getRootData(){
		E rootData=null;
		if(root!=null)
			rootData=root.getData();
		return rootData;
	}
	
	public void setRootData(E rootData){
		root.setData(rootData);
	}


	public BinaryNodeInterface<E> getRoot() {
		return root;
	}

	public void setRoot(BinaryNodeInterface<E> root) {
		this.root = root;
	}

	@Override
	public boolean find(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return root.getNodeHeight();
	}
	
	@Override
	public int getNumberOfNodes() {
		// TODO Auto-generated method stub
		return root.getNumberOfNodes();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return root==null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		root=null;
	}

	@Override
	public void printTree(int type) {
		// TODO Auto-generated method stub
		switch(type){
		case 0:
			System.out.print("Level traverse: ");
			levelOrder((BinaryNode<E>)root);
			break;
		case 1:
			System.out.print("PreOrder traverse(recursive):");
			preOrder(root);
			break;
		case 2:
			System.out.print("PreOrder traverse(non-recursive):");
			preOrder1(root);
			break;
		case 3:
			System.out.print("InOrder traverse(recursive):");
			inOrder(root);
			break;
		case 4:
			System.out.print("InOrder traverse(non-recursive):");
			inOrder1(root);
			break;
		case 5:
			System.out.print("PostOrder traverse(recursive):");
			postOrder(root);
			break;
		case 6:
			System.out.print("PostOrder traverse(non-recursive):");
			postOrder1(root);
			break;
		default:
			break;
		}
		System.out.println();
	}
	
	private void preOrder(BinaryNodeInterface<E> root) {
		// TODO Auto-generated method stub
		if(root!=null)
			System.out.print(root.getData()+" ");
		if(root.getLeftChild()!=null)
			preOrder(root.getLeftChild());
		if(root.getRightChild()!=null)
			preOrder(root.getRightChild());
	}

	private void inOrder(BinaryNodeInterface<E> root) {
		// TODO Auto-generated method stub
		if(root.getLeftChild()!=null)
			inOrder(root.getLeftChild());
		if(root!=null)
			System.out.print(root.getData()+" ");
		if(root.getRightChild()!=null)
			inOrder(root.getRightChild());
	}

	private void postOrder(BinaryNodeInterface<E> root) {
		// TODO Auto-generated method stub
		if(root.getLeftChild()!=null)
			postOrder(root.getLeftChild());
		if(root.getRightChild()!=null)
			postOrder(root.getRightChild());
		if(root!=null)
			System.out.print(root.getData()+" ");
	}
	

	private void preOrder1(BinaryNodeInterface<E> root) {
		// TODO Auto-generated method stub
		StackInterface<BinaryNode> stack=new LinkStack<BinaryNode>();
		if(root!=null){
			System.out.print(root.getData()+" ");
			if(root.hasRightChild())
				stack.push((BinaryNode)root.getRightChild());
			if(root.hasLeftChild())
				stack.push((BinaryNode)root.getLeftChild());
			BinaryNode bn=null;
			while(!stack.isEmpty()){
				bn=stack.pop();
				System.out.print(bn.getData()+" ");
				if(bn.hasRightChild())
					stack.push((BinaryNode)bn.getRightChild());
				if(bn.hasLeftChild())
					stack.push((BinaryNode)bn.getLeftChild());
			}
		}
		System.out.println();
	}

	private void inOrder1(BinaryNodeInterface<E> root) {
		// TODO Auto-generated method stub
		StackInterface<BinaryNode> stack=new LinkStack<BinaryNode>();
		if(root!=null){
			BinaryNode bn=(BinaryNode)root;
			while(!stack.isEmpty()|| bn!=null){
				if(bn!=null){
					stack.push(bn);
					bn=(BinaryNode) bn.getLeftChild();
				}
				else{
					bn=stack.pop();
					System.out.print(bn.getData()+" ");
					bn=(BinaryNode)bn.getRightChild();
				}
			}
			
		}
		System.out.println();
	}

	private void postOrder1(BinaryNodeInterface<E> root) {
		// TODO Auto-generated method stub
		StackInterface<BinaryNode> stack=new LinkStack<BinaryNode>();
		if(root==null) return;
		BinaryNode h=(BinaryNode)root;
		BinaryNode c=null;
		stack.push(h);
		while(!stack.isEmpty()){
			c=stack.peek();
			if(c.hasLeftChild() && h!=c.getLeftChild() && h!=c.getRightChild()){
				stack.push((BinaryNode)c.getLeftChild());
			}
			else if(c.hasRightChild() && h!=c.getRightChild()){
				stack.push((BinaryNode)c.getRightChild());
			}
			else{
				System.out.print(stack.pop().getData()+" ");
				h=c;
			}
		}
		System.out.println();
	}

	private void levelOrder(BinaryNode<E> root) {
		// TODO Auto-generated method stub
		QueueInterface<BinaryNode> qu=new LinkQueue<BinaryNode>();
		if(root!=null)
			qu.enqueue((BinaryNode)root);
		BinaryNode bn=null;
		while((root!=null)&&(!qu.isEmpty())){
			bn=qu.dequeue();
			System.out.print(bn.getData()+" ");
			if(bn.hasLeftChild())
				qu.enqueue((BinaryNode)(bn.getLeftChild()));
			if(bn.hasRightChild())
				qu.enqueue((BinaryNode)(bn.getRightChild()));		
		}
		System.out.println();
	}

}
