package com.lectures;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;

import com.lectures.Lec0909.TreeNode;

public class Lec0916 {

	public static void main(String[] args) {
//		Breadth First Search
//		TreeNode<Integer> root = new TreeNode<>();
//		bfs(root);
		
//		Insert
//		int val = 0;
//		insert(root, val);
		
//		Balanced Binary search Tree
//		AVL - Next Class
		
//		Bubble sort
		Integer[] arr = new Integer[]{21,5,32,16,8,11,14, 22,4};
		bubbleSort(arr);
		Stream.of(arr).forEach(a -> System.out.print(a+","));

	}

	private static void bubbleSort(Integer[] arr) {
		boolean swapped = true;
		while(swapped) {
			swapped=false;
			for(int i = 0;i<arr.length-1;i++) {
				if(arr[i]>arr[i+1]) {
					int tmp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = tmp;
					swapped=true;
				}
			}
		}
		
	}

	private static void insert(TreeNode<Integer> node, int val) {
		if(node.val>val) {
			if(node.left==null) {
				node.left=new TreeNode<Integer>();
				node.left.val = val;
				return;
			}
			insert(node.left, val);
		}else if(node.val<val) {
			
			if(node.right==null) {
				node.right=new TreeNode<Integer>();
				node.right.val = val;
				return;
			}
			insert(node.right, val);
		}
		
	}

	private static void bfs(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> q = new LinkedBlockingQueue<>();
		while(!q.isEmpty()) {
			TreeNode<Integer> iter = q.poll();
			System.out.print(iter.val);
			if(iter.left!=null) {
			q.add(iter.left);
			}
			if(iter.right!=null) {
			q.add(iter.right);
			}
		}
	}

}
