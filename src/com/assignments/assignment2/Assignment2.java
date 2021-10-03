package com.assignments.assignment2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Assignment2 {
	
	private static Logger logger = Logger.getLogger(Assignment2.class.getName());

	public static void main(String[] args) {

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(new Integer[] { 40, 60, 20, 80, 50, 10, 30, 15, 5, 35, 25, 45, 55, 70, 90, 32, 33, 48, 46 });
		logger.log(Level.INFO, "Elements Inserted");
		bst.inorderPrint();
		bst.delete(40);
		logger.log(Level.INFO, "Element 40 deleted");
		bst.inorderPrint();
		bst.delete(20);
		logger.log(Level.INFO, "Element 20 deleted");
		bst.inorderPrint();
	}

}
