package com.assignments.assignment6;

import static com.assignments.assignment6.Constants.CHARS;
import static com.assignments.assignment6.Constants.RANDOM;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Assignment6 {

	private static Logger logger = Logger.getLogger(Assignment6.class.getName());

	public static void main(String[] args) {

		List<String> names = getNames();

		HashTableInterface<String> table = new HashTableQP<>(31);

		names.stream().forEach(n -> table.put(n));
		logger.info("Number of Collisions currently in the Table: " + table.getCurrentCollisions());
		logger.info("Number of Collisions Totally occured in the Table: " + table.getTotalCollisions());
		logger.info("The Hash Table after populating 20 names: " + table.toString());

	}

	private static List<String> getNames() {
		return IntStream.range(0, 20).mapToObj(i -> getRandomName(3, 8)).collect(Collectors.toList());
	}

	private static String getRandomName(int minLength, int maxLength) {
		int n = maxLength - minLength;
		StringBuilder sb = new StringBuilder();
		int length = minLength + RANDOM.nextInt(n);
		IntStream.range(0, length).forEach(i -> sb.append(CHARS.charAt(RANDOM.nextInt(CHARS.length()))));
		return sb.toString();
	}

}
