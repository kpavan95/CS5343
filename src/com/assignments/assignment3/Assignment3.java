package com.assignments.assignment3;

import static com.assignments.assignment3.Constants.RANDOM;
import static com.assignments.assignment3.Constants.UPPERBOUND;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Assignment3 {

	private static Logger logger = Logger.getLogger(Assignment3.class.getName());

	public static void main(String[] args) {
		// Generate a array of 15 random integers
		Integer arr[] = new Integer[15];

		IntStream.range(0, 15).forEach(i -> arr[i] = getRandomNO());
		printArrayAsCSV(arr);
		logger.log(Level.INFO, "Converting array into heap");
		convertArrayToMinHeap(arr);
		printArrayAsCSV(arr);
		logger.log(Level.INFO, "Sort array in Descending order using Heap Sort");
		heapSort(arr);
		printArrayAsCSV(arr);

	}

	private static void heapSort(Integer[] arr) {
		int n = arr.length;
		IntStream.iterate(n - 1, i -> i - 1).limit(n - 1).map(i -> swap(arr, 0, i)).forEach(i -> heapify(arr, 0, i));
	}

	private static int swap(Integer[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
		return i;
	}

	private static void convertArrayToMinHeap(Integer[] arr) {
		int nonLeafNodeSize = arr.length / 2 - 1;
		IntStream.iterate(nonLeafNodeSize, i -> i - 1).limit(nonLeafNodeSize+1).forEach(i -> heapify(arr, i, arr.length));
	}

	private static void heapify(Integer[] arr, int i, int length) {
		int smallest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < length && arr[l] < arr[smallest])
			smallest = l;

		if (r < length && arr[r] < arr[smallest])
			smallest = r;

		if (smallest != i) {
			swap(arr, i, smallest);
			heapify(arr, smallest, length);
		}
	}

	private static void printArrayAsCSV(Integer[] arr) {
		StringBuilder sb = new StringBuilder();
		sb.append("List of intigers: ");
		sb.append(Stream.of(arr).map(String::valueOf).collect(Collectors.joining(",")));
		logger.log(Level.INFO, sb.toString());
	}

	private static Integer getRandomNO() {
		return RANDOM.nextInt(UPPERBOUND);
	}

}
