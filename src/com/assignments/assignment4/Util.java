package com.assignments.assignment4;

import static com.assignments.assignment4.Constants.RANDOM;

public class Util {

	public static int getRandom(int upperBound) {
		return getRandom(0, upperBound);
	}

	public static int getRandom(int lowerBound, int upperBound) {
		return lowerBound + RANDOM.nextInt(upperBound - lowerBound);
	}
}
