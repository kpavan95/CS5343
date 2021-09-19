package com.assignments.assignment1;

import static com.assignments.assignment1.Constants.COMMA;

public class AssignmentLinkedList<T extends Comparable<T>> {
	
	protected AssignmentLinkedNode<T> head;
	
	protected int length;
	
	@Override
	public String toString() {
		AssignmentLinkedNode<T> iter = head;
		StringBuilder sb = new StringBuilder();
		while(iter!=null) {
			sb.append(iter.val).append(COMMA);
			iter=iter.next;
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

	protected void add(T val) {
		if(head==null) {
			head = new AssignmentLinkedNode<>(val);
			return;
		}
		AssignmentLinkedNode<T> iter = head;
		while(iter.next!=null) {
			iter=iter.next;
		}
		iter.next = new AssignmentLinkedNode<>(val);
		length++;
	}

	protected void selectionSort() {
		AssignmentLinkedNode<T> iterprev = null;
		AssignmentLinkedNode<T> iter = head;
		
		while(iter!=null) {
			AssignmentLinkedNode<T> min = iter;
			AssignmentLinkedNode<T> minprev = null;
			
			AssignmentLinkedNode<T> iter2prev = iter;
			while(iter2prev.next!=null) {
				if(iter2prev.next.val.compareTo(min.val)<0) {
					minprev = iter2prev;
					min = iter2prev.next;
				}
				iter2prev = iter2prev.next;	
			}
			if (iter != min) {
				if (iterprev == null) {
					if (iter.next == min) {
						iter.next = min.next;
						min.next = iter;
					} else {
						AssignmentLinkedNode<T> temp = iter.next;
						iter.next = min.next;
						min.next = temp;
						minprev.next = iter;
					}
					head = min;

				} else {
					if (iter.next == min) {
						iterprev.next = min;
						iter.next = min.next;
						min.next = iter;
					} else {
						AssignmentLinkedNode<T> temp = iter.next;
						iterprev.next = min;
						iter.next = min.next;
						minprev.next = iter;
						min.next = temp;

					}

				}
			}
			iter = min;
			iterprev = iter;
			iter = iter.next;
		}
		
	}
	
} 
