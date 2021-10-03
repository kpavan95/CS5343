package com.assignments.assignment2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BinarySearchTree<T extends Comparable<T>> {

	private static Logger logger = Logger.getLogger(BinarySearchTree.class.getName());

	private BinaryNode<T> root;

	protected void inorderPrint() {
		StringBuilder sb = new StringBuilder();
		inorderPrint(root, sb);
		logger.log(Level.INFO, "In Order Traversal : "+sb.toString());
	}

	private void inorderPrint(BinaryNode<T> node, StringBuilder sb) {
		if (node == null) {
			return;
		}
		inorderPrint(node.getLeft(), sb);
		if (sb.length()!=0) {
			sb.append(", ");
		}
		sb.append(node.getValue());
		inorderPrint(node.getRight(), sb);
	}

	protected void insert(T[] values) {
		for (int i = 0; i < values.length; i++) {
			insert(values[i]);
		}
	}

	protected void insert(T val) {
		if (root == null) {
			root = new BinaryNode<T>(val, null, null);
			return;
		}
		insert(root, val);
	}

	private BinaryNode<T> insert(BinaryNode<T> node, T val) {
		if (node == null) {
			return new BinaryNode<T>(val, null, null);
		}
		if (node.getValue().compareTo(val) < 0) {
			node.setRight(insert(node.getRight(), val));
		} else if (node.getValue().compareTo(val) > 0) {
			node.setLeft(insert(node.getLeft(), val));
		}
		return node;
	}

	protected void delete(T val) {
		delete(root, val);
	}

	private BinaryNode<T> delete(BinaryNode<T> node, T val) {
		if (node == null) {
			return null;
		}
		if (node.getValue().compareTo(val) < 0) {
			node.setRight(delete(node.getRight(), val));
		} else if (node.getValue().compareTo(val) > 0) {
			node.setLeft(delete(node.getLeft(), val));
		} else {
			if (node.getLeft() == null && node.getRight() == null) {
				return null;
			} else if (node.getLeft() != null && node.getRight() != null) {

				// get predecessor
				BinaryNode<T> iter = node.getLeft();
				while (iter.getRight() != null) {
					iter = iter.getRight();
				}
				node.setValue(iter.getValue());
				node.setLeft(delete(node.getLeft(),iter.getValue()));
			} else if (node.getLeft() != null) {
				node = node.getLeft();
			} else {
				node = node.getRight();
			}
		}

		return node;
	}

}
