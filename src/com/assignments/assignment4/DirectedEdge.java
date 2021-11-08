package com.assignments.assignment4;

public class DirectedEdge {

	private final int vertexFrom, vertexTo, weight;

	public DirectedEdge(int vertexFrom, int vertexTo, int weight) {
		this.vertexFrom = vertexFrom;
		this.vertexTo = vertexTo;
		this.weight = weight;
	}

	public int getVertexFrom() {
		return vertexFrom;
	}

	public int getVertexTo() {
		return vertexTo;
	}

	public int getWeight() {
		return weight;
	}
}
