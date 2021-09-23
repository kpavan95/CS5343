package com.lectures;

public class Lec0921 {

	public static void main(String[] args) {
//		AVL tree: The height difference at any node must not be greater than 1
//		four base cases are
//		1. Left left nodes -> just right rotate
//				right child of 2 becomes left child of 1, 1 becomes right child of 2, 2 is now the parent in this sub tree 
//		2. Right right nodes -> just left rotate
//				left child of 2 becomes the right child of 1, 1 becomes the left child of 2, 2 is now the parent in this sub tree 
//		3. Right left nodes ->  Right rotate and the left rotate
//				3 becomes the right of 1, 2 becomes the right of 3, 1 becomes the left of 3, 3 is now the parent of this sub tree
//		4. Left right nodes -> Left rotate and the right rotate
//				3 becomes the left of 1, 2 becomes the left of 3, 1 becomes the right of 3, 3 is now the parent of this sub tree
				
//		Insert 12 in this tree
		AVLTree<Integer> tree =  new AVLTree<>();
		tree.add(3);
		tree.add(7);
		tree.add(10);
		tree.add(11);
		tree.add(13);
		tree.add(15);
		tree.add(20);
		tree.add(23);
		tree.add(12);
		

	}
	
	public static class AVLTree<T extends Comparable<T>> {
		AVLNode<T> root;
		

		public void add(T val) {
			addNode(root, val);
		}
		
		public AVLNode<T> addNode(AVLNode<T> node, T val) {
			if(node==null) {
				return new AVLNode<>(val);
			}
			if(node.val.compareTo(val)<0) {
				node.left = addNode(node.left, val);
			} else if(node.val.compareTo(val)>0) {
				node.right = addNode(node.right, val);
			} else {
				return node;
			}
			
			node.height = 1 + Math.max(height(node.left), height(node.right));
			
			int balance = getBalance(node);
			
			if(balance>1 && node.left.val.compareTo(val)>0) {
//				Left Left case
				return rotateRight(node);
				
			} else if (balance>1 && node.left.val.compareTo(val)<0) {
//				Left Right Case
				node.left = rotateLeft(node.left);
				return rotateRight(node);
				
			} else if(balance<-1 && node.right.val.compareTo(val)<0) {
//				Right Right case
				return rotateLeft(node);
				
			} else if(balance<-1 && node.right.val.compareTo(val)>0) {
//				Right Left case
				node.right = rotateRight(node.right);
				return rotateLeft(node);
				
			}
			
			return node;
		}


		AVLNode<T> rotateLeft(AVLNode<T> node) {
			AVLNode<T> parent = node.right;
			node.right = parent.left;
			parent.left = node;
			return parent;
		}

		AVLNode<T> rotateRight(AVLNode<T> node) {
			AVLNode<T> parent = node.right;
			node.left = parent.right;
			parent.right = node;
			return parent;
		}

		int getBalance(AVLNode<T> node) {
			if(node==null) {
				return 0;
			}
			return height(node.left) - height(node.right);
		}

		int height(AVLNode<T> node) {
			if(node==null) {
				return 0;
			}
			if(node.height!=null) {
				return node.height;
			}
			node.height = 1 + Math.max(height(node.left),height(node.right));
			return node.height;
		}
		
	}
	
	public static class AVLNode<T extends Comparable<T>> {
		T val;
		Integer height;
		AVLNode<T> left;
		AVLNode<T> right;
		
		public AVLNode(T val) {
			this.val=val;
		}
		
	}

}
