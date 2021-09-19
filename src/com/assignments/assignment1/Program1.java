package com.assignments.assignment1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Q1: Make a single linked list of integers. There should be at least 15
 * nodes,. The list should not be sorted. Traverse the list. Now sort the list
 * using selection sort. /do not use any other sorting algorithm. The list
 * should be sorted such that your program unlinks the nodes and relinks them so
 * that they are sorted. (DO NOT SWAP THE VALUES IN THE NODES). use selection
 * sort. Traverse the list again. Submit the complete code. A readme file with
 * instructions to compile. submit each Screen shot of your program execution.
 * 
 * @author pavankumar
 *
 */
public class Program1 {
	
	private static Logger logger = Logger.getLogger(Program1.class.getName());

	protected static void solve(String csv) {
		AssignmentLinkedList<Integer> list = new AssignmentLinkedList<>();
		int i = 0;
		while (i < csv.length()) {
			int indexOfnextComma = csv.indexOf(",", i);
			if (indexOfnextComma < 0) {
				list.add(Integer.parseInt(csv.substring(i)));
				break;
			} else {
				list.add(Integer.parseInt(csv.substring(i, indexOfnextComma)));
				i = indexOfnextComma + 1;
			}
		}
		list.selectionSort();
		logger.log(Level.INFO, "Sorted List : " + list.toString());

	}

}
