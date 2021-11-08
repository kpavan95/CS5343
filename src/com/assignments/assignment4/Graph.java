package com.assignments.assignment4;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private int verticesCount, edgesCount;
	private List<DirectedEdge>[] adj;

	@SuppressWarnings("unchecked")
	public Graph(int verticesCount) {
		this.verticesCount = verticesCount;
		adj = new ArrayList[verticesCount];
		for (int i = 0; i < verticesCount; i++) {
			adj[i] = new ArrayList<DirectedEdge>();
		}
	}

	public void addEdge(DirectedEdge edge) {
		int vertexFrom = edge.getVertexFrom();
		adj[vertexFrom].add(edge);
		edgesCount++;
	}
	
	public List<DirectedEdge> adjecencyList(int vertex) {
		return adj[vertex];
	}

	public int getVerticesCount() {
		return verticesCount;
	}

	public void setVerticesCount(int verticesCount) {
		this.verticesCount = verticesCount;
	}

	public int getEdgesCount() {
		return edgesCount;
	}

	public void setEdgesCount(int edgesCount) {
		this.edgesCount = edgesCount;
	}

	public List<DirectedEdge>[] getAdj() {
		return adj;
	}

	public void setAdj(List<DirectedEdge>[] adj) {
		this.adj = adj;
	}
	

}
