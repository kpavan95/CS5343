package com.lectures;

import com.lectures.Lec0831.ListLinked;
import com.lectures.Lec0831.Node;

public class Lec0902 {

	public static void main(String[] args) {
		Node<Integer> n = new Node<>();
		n.value=10;
		System.out.println("Sum of all elements : " + add(n));
		
		/* 
		 * Recursive algo of double linked list assume the no of nodes is odd
		 * find the middle
		 */
		
		DoubleLinkedList<Integer> dl = new DoubleLinkedList<>();
		System.out.println("Middle value of odd length list : "+ dl.middle().value);
		
		/*
		 * Find middle for single linked list
		 * 
		 */
		ListLinked<Integer> l = new ListLinked<>();
		System.out.println("Middle Value of SinglyLinked List : "+ middle(l).value);
		
		/*
		 * 
		 */
	}
	
	public static boolean loopExists(ListLinked<Integer> l) {
		return loopExists(l.head, l.head.next);
	}
	
	private static boolean loopExists(Node<Integer> iter1, Node<Integer> iter2) {
		if(iter1==iter2) {
			return true;
		}
		if(iter2==null || iter2.next==null) {
			return false;
		}
		return loopExists(iter1.next,iter2.next.next);
	}

	public static Node<Integer> middle(ListLinked<Integer> l) {
		return middle(l.head, l.head.next);
	}
	
	public static Node<Integer> middle(Node<Integer> iter1, Node<Integer> iter2) {
		if(iter2==null || iter2.next==null) {
			return iter1;
		}
		return middle(iter1.next, iter2.next.next);
	}
	
	public static int add(Node<Integer> l) {
		if(l==null) {
			return 0;
		}
		return l.value + add(l.next);
	}
	
	public static class DoubleLinkedList<T extends Comparable<T>> {
		DNode<T> head;
		DNode<T> tail;
		
		public void insertAfter(T ref, T val) {
			if (head==null) {
				head = new DNode<T>(val, null, null);
				tail = head;
				return;
			}
			DNode<T> iter = head;
			while(iter.next!=null && iter.value!=ref) {
				iter=iter.next;
			}
			insert(iter,val);
		}
		
		public void insertBefore(T ref, T val) {
			if(head==null) {
				head = new DNode<T>(val, null, null);
				tail = head;
				return;
			}
			DNode<T> iter= tail;
			while(iter.prev!=null && iter.prev!=ref) {
				iter=iter.prev;
			}
			insert(iter.prev, val);
			
		}
		
		public void insert(DNode<T> iter, T val) {
			DNode<T> tmp = iter.next;
			iter.next = new DNode<T>(val,iter,tmp);
			if(tmp!=null) {
				tmp.prev = iter.next;
			}
		}
		
		public DNode<T> middle() {
			return middle(head, tail);
			
		}

		private DNode<T> middle(DNode<T> iterFront, DNode<T> iterBack) {
			if(iterFront==iterBack)
			return iterBack;
			return middle(iterFront.next, iterBack.prev);
		}
		
	}

	
	public static class DNode<T extends Comparable<T>> {
		T value;
		DNode<T> next;
		DNode<T> prev;
		
		DNode(T value, DNode<T> prev, DNode<T> next) {
			this.value=value;
			this.prev = prev;
			this.next = next;
		}
	}


	
}
