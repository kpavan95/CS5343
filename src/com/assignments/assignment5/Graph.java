package com.assignments.assignment5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Graph {

	private static Logger logger = Logger.getLogger(Graph.class.getName());

	int nodesCount;
	int adjacencyMatrix[][];
	String verticesNames[];
	Map<String, Integer> vertixToIndexMap;
	boolean hasCycle = false;

	public Graph(String csv) {
		this.vertixToIndexMap = new HashMap<>();
		addVerticesNamesAsCSV(csv);
		this.nodesCount = verticesNames.length;
		this.adjacencyMatrix = new int[nodesCount][nodesCount];
	}

	public void addDirectedEdge(String v, String w) {
		int vIndex = getIndex(v);
		int wIndex = getIndex(w);
		adjacencyMatrix[vIndex][wIndex] = 1;
	}

	private int getIndex(String vertix) {
		return vertixToIndexMap.get(vertix);
	}

	public List<Integer> adj(int v) {
		List<Integer> adjacencyList = new ArrayList<>();
		for (int i = 0; i < nodesCount; i++) {
			if (adjacencyMatrix[v][i] == 1) {
				adjacencyList.add(i);
			}
		}
		return adjacencyList;
	}

	public int getNodesCount() {
		return nodesCount;
	}

	public int[][] getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	private void addVerticesNamesAsCSV(String csv) {
		verticesNames = csv.split(",");
		vertixToIndexMap = IntStream.range(0, verticesNames.length).mapToObj(i -> i)
				.collect(Collectors.toMap(i -> verticesNames[i], i -> i));
	}

	public void dfs() {
		boolean visited[] = new boolean[nodesCount];
		boolean onStack[] = new boolean[nodesCount];
		Stack<Integer> dfsResult = new Stack<>();
		for (int i = 0; i < nodesCount; i++) {
			if (!visited[i]) {
				dfs(i, visited, onStack, dfsResult);
			}
		}
		if (hasCycle) {
			logger.log(Level.INFO, "Cycle Detected. Cannot do DFS");
		} else {
			printStack(dfsResult);
		}
	}

	public void dfs(int v, boolean visited[], boolean onStack[], Stack<Integer> dfsResult) {
		onStack[v] = true;
		visited[v] = true;
		for (int w : adj(v)) {

			if(visited[w] && onStack[w]) {
				hasCycle = true;
			}

			if (!visited[w]) {
				dfs(w, visited, onStack, dfsResult);
			}

		}
		onStack[v] = false;
		dfsResult.push(v);
	}

	public void bfs() {
		int indegree[] = new int[nodesCount];

		for (int i = 0; i < nodesCount; i++) {
			for (int node : adj(i)) {
				indegree[node]++;
			}
		}

		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < nodesCount; i++) {
			if (indegree[i] == 0)
				queue.add(i);
		}
		int count = 0;
		List<Integer> bfsResult = new LinkedList<>();
		while (!queue.isEmpty()) {
			int u = queue.poll();
			bfsResult.add(u);
			for (int node : adj(u)) {
				if (--indegree[node] == 0)
					queue.add(node);
			}
			count++;
		}
		if (count != nodesCount) {
			logger.log(Level.INFO, "Cycle Detected. Cannot do BFS");
		} else {
			printList(bfsResult);
		}
	}

	private void printList(List<Integer> result) {
		StringBuilder sb = new StringBuilder();
		sb.append("Result: ");
		result.stream().forEach(r -> sb.append(verticesNames[r]).append(","));
		sb.deleteCharAt(sb.length() - 1);
		logger.log(Level.INFO, sb.toString());
	}

	private void printStack(Stack<Integer> result) {
		StringBuilder sb = new StringBuilder();
		sb.append("Result: ");
		while (!result.empty()) {
			sb.append(verticesNames[result.pop()]).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		logger.log(Level.INFO, sb.toString());
	}

}
