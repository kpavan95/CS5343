package com.assignments.assignment1;

/**
 * 
 * @author pavankumar
 *
 */
public class AssignmentLinkedNode<T> {

	protected T val;
	
	protected AssignmentLinkedNode<T> next;
	
	protected AssignmentLinkedNode(T val) {
		this.val = val;
	}

	protected AssignmentLinkedNode(T val, AssignmentLinkedNode<T> next) {
		this.val = val;
		this.next = next;
	}
	
}