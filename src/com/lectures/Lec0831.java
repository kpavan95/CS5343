package com.lectures;

public class Lec0831 {

	public static void main(String[] args) {
		ListLinked<Integer> list = new ListLinked<>();
		list.add(1);
		list.add(7);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(3);
		list.add(8);
		
		list.insertAfter(5, 12);
		list.printListRec();
		list.insertBefore(5, 14);
		list.printListRec();
		list.insertAfterRec(12, 13);
		list.printListRec();
		System.out.println("List Contains 3 : "+list.contains(3));
		System.out.println("List Contains 3 (Rec): "+list.containsRec(3));
		list.delete(3);
		list.printListRec();
		System.out.println("List length: "+list.nodesLength());
		System.out.println("List length (Rec): "+list.nodesLengthRec());
		System.out.println("Largest item in list: "+list.findLargestRec());
		

	}
	
	public static class ListLinked<T extends Comparable<T>> {
		public Node<T> head = null;
		
		public boolean contains(T value) {
			Node<T> iter = head;
			while(iter.next!=null) {
				iter = iter.next;
				if(iter.value==value) {
					return true;
				}
			} 
			return false;
		}

		public T findLargestRec() {
			if(head==null) {
				return null;
			}
			return findLargestRec(head);
		}

		private T findLargestRec(Node<T> n) {
			if (n.next==null) {
				return n.value;
			}
			T nextLargest = findLargestRec(n.next);
			return n.value.compareTo(nextLargest)>0?n.value: nextLargest;
		}

		public void printListRec() {
			System.out.print("List : ");
			printRec(head);
			System.out.println();
		}

		private void printRec(Node<T> n) {
			if(n==null) {
				return;
			}
			System.out.print(n.value+",");
			printRec(n.next);
		}

		public int nodesLength() {
			int i = 1;
			if(head==null) {
				return 0;
			}
			Node<T> iter = head;
			while(iter.next!=null) {
				iter = iter.next;
				i++;
			}
			return i;
		}

		public int nodesLengthRec() {
			return nodesLengthRec(head);
			
		}

		private int nodesLengthRec(Node<T> n) {
			if(n==null) {
				return 0;
			}
			return nodesLengthRec(n.next)+1;
		}

		public boolean containsRec(T value) {
			return containsRec(head, value);
			
		}

		public boolean containsRec(Node<T> n, T value) {
			if(n==null) {
				return false;
			} else if (n.value == value) {
				return true;
			}
			containsRec(n.next, value);
			return false;
		}
		
		public void add(T value) {
			if(head==null) {
				head = new Node<T>();
				head.value=value;
				return;
			}
			Node<T> n = new Node<>();
			n.value = value;
			Node<T> iter = head;
			while(iter.next!=null) {
				iter=iter.next;
			}
			iter.next = n;
		}
		
		public void insertAfter(T ref, T value) {
			Node<T> iter = head;
			while(iter.value!=ref) {
				iter=iter.next;
			}
			insertAfter(iter, value);
		}
		
		public void insertAfterRec(T ref, T value) {
			Node<T> refNode = findRec(head, ref);
			insertAfter(refNode, value);
		}
		
		public Node<T> findRec(Node<T> iter , T ref) {
			if(iter.value==ref) {
				return iter;
			}
			return findRec(iter.next, ref);
		}
		
		public void insertBefore(T ref, T value) {
			Node<T> iter = head;
			if(head.value==value) {
				replaceHead(value);
				return;
			}
			while(iter.next.value!=ref) {
				iter=iter.next;
			}
			insertAfter(iter, value);
		}

		private void replaceHead(T value) {
			Node<T> newNode = new Node<T>();
			newNode.value = value;
			newNode.next = head;
			head = newNode;
		}
		
		private void insertAfter(Node<T> iter, T value) {
			Node<T> tmp = iter.next;
			Node<T> newNode = new Node<T>();
			newNode.value = value;
			newNode.next = tmp;
			iter.next = newNode;
		}
		
		public boolean delete(T value) {
			if(head.value==value) {
				return deleteHead();
			}
			Node<T> iter = head;
			while(iter.next.value != value) {
				iter = iter.next;
			}
			return deleteNext(iter);
		}

		private boolean deleteNext(Node<T> iter) {
			iter.next = iter.next.next;
			return true;
		}

		private boolean deleteHead() {
			head = head.next; 
			return true;
		}

	}

	public static class Node<T> {
		public T value;
		public Node<T> next = null;
	}
}


