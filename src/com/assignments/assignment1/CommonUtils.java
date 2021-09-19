package com.assignments.assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommonUtils {

	private static Logger logger = Logger.getLogger(CommonUtils.class.getName());

	public static String readInput() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			input = reader.readLine();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Not able to parse your input");
		}
		return input;
	}
	
	protected static boolean ternarySearch(int[] arr, int val, int start, int end) {
		if (end > 0 && end > start) {
			int oneThird, twoThird;
			oneThird = start + ((end-start) / 3);
			twoThird = end - ((end-start) / 3);
			if(oneThird>twoThird) {
				return false;
			}
			if (arr[start] == val || arr[end] == val || arr[oneThird] == val || arr[twoThird] == val) {
				return true;
			}
			if (val < arr[oneThird]) {
				return ternarySearch(arr, val, start + 1, oneThird - 1);
			} else if (val > arr[oneThird] && val < arr[twoThird]) {
				return ternarySearch(arr, val, oneThird + 1, twoThird - 1);
			} else {
				return ternarySearch(arr, val, twoThird + 1, end - 1);
			}
		}
		return false;
	}

	protected static void bubbleSort(int[] arr) {
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

}
