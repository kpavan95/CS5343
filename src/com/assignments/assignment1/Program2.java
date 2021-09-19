package com.assignments.assignment1;

import static com.assignments.assignment1.Constants.COMMA;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * /** We covered binary search algorithm for an array. Write program similar to
 * binary search, but now divide the list into 3 parts each time. So this would
 * be tertiary search algorithm. Your program must be recursive, Submit the code
 * and screen shot of executions. run it 2 times .. once try to search a number
 * in the list. Second time search a number not in the list.
 * 
 * @author pavankumar
 *
 */
public class Program2 {

	private static Logger logger = Logger.getLogger(Program2.class.getName());

	protected static void solve(String csv) {
		int[] arr = Arrays.stream(csv.split(COMMA)).mapToInt(Integer::parseInt).toArray();
		CommonUtils.bubbleSort(arr);
		logger.log(Level.INFO, "Type the number you want to search for and press enter");
		int val = Integer.parseInt(CommonUtils.readInput());
		boolean exists = CommonUtils.ternarySearch(arr, val, 0, arr.length-1);
		logger.log(Level.INFO, "Value exists: " + exists);

	}

}
