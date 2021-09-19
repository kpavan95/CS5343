package com.assignments.assignment1;

import static com.assignments.assignment1.Constants.COMMA;
import static com.assignments.assignment1.Constants.NEWLINE;
import static com.assignments.assignment1.Constants.RANDOM;
import static com.assignments.assignment1.Constants.UPPERBOUND;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Assignment1 {
	
	private static Logger logger = Logger.getLogger(Assignment1.class.getName());

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Hie, Welcome to Programming assignment 1").append(NEWLINE);
		sb.append("Professor: Neeraj Gupta").append(NEWLINE);
		sb.append("Written By: Pavan Kumar").append(NEWLINE);
		sb.append("Date Of Submission: Sep 18th 2021").append(NEWLINE).append(NEWLINE);
		sb.append("Please select the Question you want the Program to execute.").append(NEWLINE);
		sb.append("Q1 Will create a Linked list and sort it using selection Sort and print it. For this option, Enter 1").append(NEWLINE);
		sb.append("Q2 Will create an Array, sort it and search for values in the array. For this option, Enter 2").append(NEWLINE);
		sb.append("Enter your option:");
		logger.log(Level.INFO, sb.toString());
		sb.delete(0, sb.length());
		
		String question = CommonUtils.readInput();
		
		
		sb.append("Would you like to give your own input(in CSV format) or have the system generate a random list of integers\n 15 in length and run the program").append(NEWLINE);
		sb.append("Type the CSV of integers or simply click enter for random integers");
		logger.log(Level.INFO, sb.toString());
		sb.delete(0, sb.length());
		
		String csv = CommonUtils.readInput();
		
		if (csv.isEmpty()) {
			for (int i = 0; i < 15; i++) {
				sb.append(RANDOM.nextInt(UPPERBOUND));
				if (i != 14) {
					sb.append(COMMA);
				}
			}
			csv = sb.toString();
		}
		
		logger.log(Level.INFO, "Input :"+csv);
		
		switch(question) {
			case "1":
				Program1.solve(csv);
				break;
			case "2":
				Program2.solve(csv);
				break;
		}

	}

}
