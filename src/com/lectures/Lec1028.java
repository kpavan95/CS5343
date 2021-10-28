package com.lectures;

public class Lec1028 {

	public static void main(String[] args) {
		/*
		 * 		Bellman-Ford Algo Continuation. New Problem
		 * 
		 * 
		 * S - 1 = 7
		 * S - 2 = 2
		 * 1 - 2 = 3
		 * 1 - 3 = 1
		 * 2 - 1 = 2
		 * 2 - 3 = 8
		 * 2 - 4 = 5
		 * 3 - 4 = 4
		 * 4 - 3 = 5
		 * 
		 * 		S	1	2	3	4
		 * 	d	0	4	2	8	7
		 * 	p	S	2	S	1	2
		 * 
		 * 	d	0	4	2	5	7
		 * 	p	S	2	S	1	2
		 * 
		 * 	Final Tree:
		 * 
		 * 		S - 2 -	1 -	3
		 * 			|
		 * 			4
		 *
		 * 
		 * Shortest Path Tree - Minimum Spanning Tree
		 * Prim's Algorith and Kruskal's Algorithm
		 * 
		 * Kruskal's Algorithm:
		 * Initially let every vertex be it's own tree. We basically start
		 * joining the trees with the smallest edge first. The only caveat
		 * is if the edge forms a cycle, then that edge is skipped.
		 * 
		 * Problem:
		 * A-F=10
		 * A-B=8
		 * A-H=5
		 * B-C=4
		 * B-H=4
		 * B-E=4
		 * F-D=6
		 * D-G=2
		 * G-E=3
		 * G-H=3
		 * D-E=1
		 * C-D=3
		 * F-c=3
		 * F-B=4
		 * 
		 * Prim's Algorithm
		 * 
		 * 
		 * Sparse graph, we use Kruskal's algo while in a dense graph,
		 * u use Prim's algo.
		 * 
		 * Problem:
		 * A-B=8
		 * B-C=4
		 * C-D=3
		 * D-E=25
		 * E-G=7
		 * G-H=3
		 * H-A=4
		 * A-F=10
		 * F-C=3
		 * F-B=7
		 * B-E=10
		 * D-G=2
		 * H-B=9
		 * F-D=18
		 * 
		 * Start from D and find the minimum spanning tree using Kruskal's algorithm
		 * 
		 * D=0, E=25, C=3, F=18, G=2
		 * 
		 * D-G => H=3, E=7, C=3, F=18
		 * 
		 * C-D-G => H=3, E=7, F=3, B=4
		 * 
		 * F-C-D-G => H=3, E=7, B=4, A=10
		 * 
		 * F-C-D-G-H => E=7, B=4, A=4
		 * 
		 * F-C-D-G-H-A => E=7, B=4
		 * 
		 * F-C-D-G-H-A => E=7
		 *   |
		 *   B
		 *   
		 * F-C-D-G-H-A
		 *   |	 |
		 *   B   E
		 *   
		 *   
		 *   ∞	∞	∞	0	∞	∞	∞	∞
		 *   ∞	∞	3	0	7	18	2*	∞
		 *   ∞	∞	3*	0	7	18	2*	3
		 *   ∞	4	3	0	7	3	2	3
		 *   4	4	3	0	7	3	2	3
		 *   4	4	3	0	2	3	3	3
		 *   4	4	3	0	2	3	2	3
		 *   4	4	3	0	2	3	2	3
		 */
		
		

	}

}
