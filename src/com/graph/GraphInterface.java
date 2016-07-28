package com.graph;

public interface GraphInterface<E> {
	
	public void addVertex(E vertex);
	
	public boolean addEdge(E begin, E end, double edgeWeight);
	
	public boolean addEdge(E begin, E end);
	
	public boolean hasEdge(E begin, E end);
	
	public boolean isEmpty();
	
	public int getNumberOfVertices();
	
	public int getNumberOfEdges();
	
	public void clear();
}
