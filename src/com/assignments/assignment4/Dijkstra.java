package com.assignments.assignment4;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
	public DirectedEdge[] edgeTo;
	public Integer[] distTo;
	public PriorityQueue<Node> minHeap;

	public Dijkstra(Graph g, int s) {

		edgeTo = new DirectedEdge[g.getVerticesCount()];
		distTo = new Integer[g.getVerticesCount()];
		minHeap = new PriorityQueue<>(g.getVerticesCount());

		Arrays.fill(distTo, Integer.MAX_VALUE);
		distTo[s] = 0;

		minHeap.add(new Node(s, 0));

		System.out.println("Dijkstra initiated");
		while (!minHeap.isEmpty()) {
			relax(g, minHeap.poll().node);
		}

	}

	public void relax(Graph g, int v) {
		for (DirectedEdge directedEdge : g.adjecencyList(v)) {
			int to = directedEdge.getVertexTo();
			if (distTo[to] > distTo[v] + directedEdge.getWeight()) {
				distTo[to] = distTo[v] + directedEdge.getWeight();
				edgeTo[to] = directedEdge;
				minHeap.removeIf(n -> n.node == to);
				minHeap.add(new Node(to, distTo[to]));
			}
		}
	}
}
