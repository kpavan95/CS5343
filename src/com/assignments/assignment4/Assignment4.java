package com.assignments.assignment4;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class Assignment4 {

	protected static final Random RANDOM = new Random();

	public static void main(String[] args) {
		System.out.println(
				"Welcome to Programming assignment 4.\nWe are going to look into the workings of Dijkstra’s algorithm");

		Graph g = constructGraph(10);

		printGraph(g);

		Dijkstra d = runDijkstra(g);

		printTree(d);

	}

	private static void printTree(Dijkstra d) {
		StringBuilder sb = new StringBuilder();

		// Even though I have assigned the vertices to be from 0 to 9, I am getting them
		// from the tree so as to prove the graph is proper
		String verticesCSV = Arrays.stream(d.edgeTo).filter(Objects::nonNull)
				.flatMap(e -> Arrays.asList(e.getVertexFrom(), e.getVertexTo()).stream()).collect(Collectors.toSet())
				.stream().map(v -> v + "").collect(Collectors.joining(","));
		sb.append("\nPrinting Tree.\nList of Vertices:").append(verticesCSV).append("\n").append(" List of Edges:")
				.append("tree (From ---(distance From Source 0)---> To): ").append("\n");
		for (int i = 0; i < d.edgeTo.length; i++) {
			if (d.edgeTo[i] != null) {
				sb.append(d.edgeTo[i].getVertexFrom()).append(" ---(").append(d.distTo[i]).append(")---> ").append(i)
						.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	private static Dijkstra runDijkstra(Graph g) {
		return new Dijkstra(g, 0);

	}

	private static void printGraph(Graph g) {
		StringBuilder sb = new StringBuilder();

		// Even though I have assigned the vertices to be from 0 to 9, I am getting them
		// from the graph so as to prove the graph is proper
		String verticesCSV = Arrays.stream(g.getAdj()).flatMap(el -> el.stream())
				.flatMap(e -> Arrays.asList(e.getVertexFrom(), e.getVertexTo()).stream()).collect(Collectors.toSet())
				.stream().map(v -> v + "").collect(Collectors.joining(","));

		sb.append("Printing Graph.\nList of Vertices:").append(verticesCSV).append("\n").append(" List of Edges:")
				.append("Graph (From ---(Weight)---> To): ").append("\n");
		Arrays.stream(g.getAdj()).flatMap(el -> el.stream()).forEach(e -> sb.append(e.getVertexFrom()).append(" ---(")
				.append(e.getWeight()).append(")---> ").append(e.getVertexTo()).append("\n"));
		System.out.println(sb.toString());
	}

	private static Graph constructGraph(int verticesCount) {
		Graph graph = new Graph(verticesCount);
		for (int i = 0; i < verticesCount; i++) {
			int edgeCount = 0;
			Integer edge1 = null;
			while (edgeCount < 3) {
				int toVertex = Util.getRandom(verticesCount);
				if (toVertex != i && (edge1 == null || edge1 != toVertex)) {
					graph.addEdge(new DirectedEdge(i, toVertex, Util.getRandom(1, 30)));
					if (edge1 == null) {
						edge1 = toVertex;
					}
					edgeCount++;
				}
			}
		}
		return graph;
	}

}
