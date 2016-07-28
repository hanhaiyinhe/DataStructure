package com.test;

import com.list.AList;
import com.list.ExpandableArrayList;
import com.list.ListInterface;
import com.list.VectorList;
import com.queue.ArrayQueue;
import com.queue.DequeInterface;
import com.queue.LinkDeque;
import com.queue.LinkLoopDeque;
import com.queue.LinkQueue;
import com.queue.QueueInterface;
import com.queue.VectorQueue;
import com.stack.ArrayStack;
import com.stack.LinkStack;
import com.stack.StackInterface;
import com.stack.VectorStack;
import com.tree.BinaryTreeInterface;
import com.tree.LinkBinaryTree;

public class test {
	public static void main(String[] args){
		//testList();
		//testStack();
		//testQueue();
		//testDeque();
		testLinkBinaryTree();
	}
	
	public static void testList(){
		ListInterface list=new AList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add(2, "d");
		list.add(1,"e");
		list.printList();
		System.out.println(list.get(2));
		list.remove(3);
		list.printList();
		list.remove(3);
		list.replace(3, "f");
		list.printList();
		
		list=new ExpandableArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add(2, "d");
		list.add(1,"e");
		list.printList();
		System.out.println(list.get(2));
		list.remove(3);
		list.printList();
		list.remove(3);
		list.replace(3, "f");
		list.printList();
		
		list=new VectorList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2, 4);
		list.add(1,5);
		list.printList();
		System.out.println(list.get(2));
		list.remove(3);
		list.printList();
		list.remove(3);
		list.replace(3, 6);
		System.out.println(list.contains(3));
		list.printList();
	}
	
	public static void testStack(){
		StackInterface stack=new VectorStack();
		stack.push("Jim");
		stack.push("Jess");
		stack.push("Jill");
		stack.push("Jane");
		stack.push("Joe");
		stack.printStack();
		
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		stack.printStack();
		System.out.println(stack.isEmpty());
		stack.clear();
		System.out.println(stack.isEmpty());
		stack.printStack();
	}
	
	public static void testQueue(){
		QueueInterface queue=new VectorQueue();
		queue.enqueue("Jim");
		queue.enqueue("Jess");
		queue.enqueue("Jill");
		queue.enqueue("Jane");
		queue.enqueue("Joe");
		queue.printQueue();
		
		System.out.println(queue.getFront());
		System.out.println(queue.dequeue());
		queue.printQueue();
		System.out.println(queue.isEmpty());
		queue.clear();
		System.out.println(queue.isEmpty());
		queue.printQueue();
	}
	
	public static void testDeque(){
		DequeInterface deque=new LinkLoopDeque();
		System.out.println(deque.isEmpty());
		deque.addToFront("Jim");
		deque.addToBack("Jess");
		deque.addToFront("Jill");
		deque.printDeque();
		deque.printReDeque();
		
		System.out.println(deque.getBack());
		System.out.println(deque.getFront());
		
		deque.addToFront("Kate");
		deque.removeBack();
		deque.printDeque();
		deque.printReDeque();
		
		deque.addToBack("Helen");
		deque.removeFront();
		deque.printDeque();
		deque.printReDeque();
		
	}
	
	public static void testLinkBinaryTree(){
		BinaryTreeInterface<String> d=new LinkBinaryTree<String>();
		d.setTree("D");
		BinaryTreeInterface<String> f=new LinkBinaryTree<String>();
		f.setTree("F");
		BinaryTreeInterface<String> g=new LinkBinaryTree<String>();
		g.setTree("G");
		BinaryTreeInterface<String> h=new LinkBinaryTree<String>();
		h.setTree("H");
		
		BinaryTreeInterface<String> emptyTree=new LinkBinaryTree<String>();
	
		BinaryTreeInterface<String> e=new LinkBinaryTree<String>();
		e.setTree("E",f,g);
		BinaryTreeInterface<String> b=new LinkBinaryTree<String>();
		b.setTree("B",d,e);
		BinaryTreeInterface<String> c=new LinkBinaryTree<String>();
		c.setTree("C",emptyTree,h);
		BinaryTreeInterface<String> a=new LinkBinaryTree<String>();
		a.setTree("A",b,c);
		
		System.out.println(a.getNumberOfNodes());
		System.out.println(a.getHeight());
		
		a.printTree(0);
		a.printTree(1);
		a.printTree(2);
		a.printTree(3);
		a.printTree(4);
		a.printTree(5);
		a.printTree(6);
	}
}
