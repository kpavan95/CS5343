package com.lectures;

import com.lectures.Lec0921.AVLNode;
import com.lectures.Lec0921.AVLTree;

public class Lec0923 {

	public static void main(String[] args) {
		AVLTree<Integer> tree = new AVLTree<>();
		delete(tree, tree.root, 3);

	}

	private static AVLNode<Integer> delete (AVLTree<Integer> tree, AVLNode<Integer> node, Integer val) {
		if(node==null) {
			return null;
		} else if(node.val.compareTo(val)>0) {
			node.left = delete(tree, node.left, val);
		} else if(node.val.compareTo(val)<0) {
			node.right = delete(tree, node.right, val);
		} else {
			/*
			 * Delete this node: Replace it with the predecessor
			 */
			AVLNode<Integer> iter = node.left;
			while(iter.right!=null) {
				iter=iter.right;
			}
			iter.right = node.right;
			iter.left = node.left;
			node=iter;
			delete(tree, node.left, node.val);
		}
		
		node.height = 1 + Math.max(tree.height(node.left), tree.height(node.right));
		
		int balance = tree.getBalance(node);
		
		if(balance>1 && tree.getBalance(node.left)>=0) {
//			Right rotate
			return tree.rotateRight(node.right);
		} else if (balance>1 && tree.getBalance(node.left)<0) {
//			left rotate and then right Rotate
			node.left = tree.rotateLeft(node.left);
			return tree.rotateRight(node);
		} else if (balance<-1 && tree.getBalance(node.right)<=0) {
//			Left Rotate
			return tree.rotateLeft(node);
		} else if(balance<-1 && tree.getBalance(node.right)>0) {
//			Right Rotate and then left Rotate
			node.right = tree.rotateRight(node.right);
			return tree.rotateLeft(node);
		}
		
		return node;
	}

}