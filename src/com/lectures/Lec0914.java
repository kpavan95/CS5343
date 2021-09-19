package com.lectures;

import com.lectures.Lec0909.TreeNode;

public class Lec0914 {

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>();
		Integer max = findLargest(root);
		System.out.println(max);
		
//		Given a binary tree and a node, find the sibling
		TreeNode<Integer> node = new TreeNode<>();
		TreeNode<Integer> sibling = findSibling(root, 10);
		
//		Find parent
		TreeNode<Integer> parent = findParent(root, 10);
		
//		Make a mirror img of binary tree
		mirror(root);

	}

	private static void mirror(TreeNode<Integer> node) {
		if(node==null) {
			return;
		}
		mirror(node.left);
		mirror(node.right);
		TreeNode<Integer> tmp = node.left;
		node.left = node.right;
		node.right=node.left;
		
	}

	private static TreeNode<Integer> findParent(TreeNode<Integer> iter, int i) {
		if(iter==null || iter.val==i) {
			return null;
		}
		if(iter.left!=null && iter.left.val==i) {
				return iter;
		}
		if(iter.right!=null && iter.right.val==i) {
			return iter;
		}
		TreeNode<Integer> parent = findParent(iter.left, i);
		if(parent==null) {
			parent = findParent(iter.right, i);
		}
		return parent;
	}

	private static TreeNode<Integer> findSibling(TreeNode<Integer> iter, int val) {
		if(iter==null || iter.val==val) {
			return null;
		}
		if(iter.left.val==val) {
			return iter.right;
		}
		if(iter.right.val==val) {
			return iter.left;
		}
		TreeNode<Integer> sibling = findSibling(iter.left, val);
		if(sibling==null) {
			findSibling(iter.right, val);
		}
		return sibling;
	}

	private static Integer findLargest(TreeNode<Integer> node) {
		if(node.left == null && node.right == null) {
			return node.val;
		}
		int max = node.val;
		if(node.left!=null) {
			max =  Math.max(max,findLargest(node.left));
		}
		if(node.right!=null) {
			max =  Math.max(max,findLargest(node.right));
		}
		return max;
	}

}
