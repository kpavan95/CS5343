package com.assignments.assignment5;

import static com.assignments.assignment5.Constants.NEWLINE;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Assignment5 {

	private static Logger logger = Logger.getLogger(Assignment5.class.getName());

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		sb.append("Welcome to Programming assignment 5").append(NEWLINE);
		sb.append("Professor: Neeraj Gupta").append(NEWLINE);
		sb.append("Written By: Pavan Kumar").append(NEWLINE);
		sb.append("Date Of Submission: Nov 14th 2021").append(NEWLINE).append(NEWLINE);
		logger.log(Level.INFO, sb.toString());
		sb.delete(0, sb.length());

		Graph graph1 = new Graph("1,2,3,4,5,6,7,8");
		graph1.addDirectedEdge("1", "2");
		graph1.addDirectedEdge("1", "5");
		graph1.addDirectedEdge("1", "6");
		graph1.addDirectedEdge("2", "3");
		graph1.addDirectedEdge("2", "7");
		graph1.addDirectedEdge("2", "5");
		graph1.addDirectedEdge("3", "4");
		graph1.addDirectedEdge("4", "5");
		graph1.addDirectedEdge("5", "7");
		graph1.addDirectedEdge("5", "8");
		graph1.addDirectedEdge("6", "5");
		graph1.addDirectedEdge("6", "8");
		graph1.addDirectedEdge("7", "4");
		graph1.addDirectedEdge("7", "8");
		
		logger.log(Level.INFO, "DFS Being Performed on the Graph 1");
		graph1.dfs();
		logger.log(Level.INFO, "BFS Being Performed on the Graph 1");
		graph1.bfs();
		
		Graph graph2 = new Graph("m,n,o,p,q,r,s,t,u,v,w,x,y,z");
		graph2.addDirectedEdge("m", "r");
		graph2.addDirectedEdge("m", "q");
		graph2.addDirectedEdge("m", "x");
		graph2.addDirectedEdge("n", "o");
		graph2.addDirectedEdge("n", "u");
		graph2.addDirectedEdge("n", "q");
		graph2.addDirectedEdge("o", "s");
		graph2.addDirectedEdge("o", "v");
		graph2.addDirectedEdge("o", "r");
		graph2.addDirectedEdge("p", "z");
		graph2.addDirectedEdge("p", "s");
		graph2.addDirectedEdge("p", "o");
		graph2.addDirectedEdge("q", "t");
		graph2.addDirectedEdge("r", "y");
		graph2.addDirectedEdge("r", "u");
		graph2.addDirectedEdge("s", "r");
		graph2.addDirectedEdge("u", "t");
		graph2.addDirectedEdge("v", "w");
		graph2.addDirectedEdge("v", "x");
		graph2.addDirectedEdge("w", "z");
		graph2.addDirectedEdge("y", "v");
		
		logger.log(Level.INFO, "DFS Being Performed on the Graph 2");
		graph2.dfs();
		logger.log(Level.INFO, "BFS Being Performed on the Graph 2");
		graph2.bfs();
	}

}
