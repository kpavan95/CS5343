package com.lectures;

import java.util.Stack;

public class Lec0909 {

	/**
	 * Binary Trees
	 * @param args
	 */
	public static void main(String[] args) {
		// Given the smallest complete binary tree of height H, How many leaf nodes are present
		
//		Traverse
//		Post Order : LRP
//		Pre Order : PLR
//		In Order : LPR
		
		// Given a binary tree, count total nodes

//		count(TreeNode root);
		
		// Count total Leaf nodes
//		countLeaf(root);
	}
	
	static class TreeNode<T> {
		T val;
		TreeNode<T> left;
		TreeNode<T> right;
	}
	
	public static int countLeafRec(TreeNode iter) {
		if(iter==null) {
			return 0;
		}
		if(iter.left==null && iter.right==null) {
			return 1;
		}
		return countLeafRec(iter.left) + countLeafRec(iter.right);
	}
	
	public static int count(TreeNode node) {
		if(node==null) {
			return 0;
		}
		int count = 1;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(node);
		while(!stack.isEmpty()) {
			count++;
			TreeNode tmp = stack.pop();
			if(tmp.right!=null) {
				stack.push(tmp.right);
			}
			if(tmp.left!=null) {
				stack.push(tmp.left);
			}
		}
		return count;
	}
	
	public static int countRec(TreeNode iter) {
		if(iter==null) {
			return 0;
		}
		return countRec(iter.left) + countRec(iter.right) + 1;
	}
	
	
	
	public static void preOrder(TreeNode iter) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(iter);
		while(!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			System.out.print(tmp.val);
			if(tmp.right!=null) {
				stack.push(tmp.right);
			}
			if(tmp.left!=null) {
				stack.push(tmp.left);
			}
			
		}
	}
	
	public static void preOrderRec(TreeNode iter) {
		if(iter==null) {
			return;
		}
		System.out.print(iter.val);
		preOrderRec(iter.left);
		preOrderRec(iter.right);
	}

}
