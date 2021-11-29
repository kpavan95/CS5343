package com.assignments.assignment6;

public class HashTableQP<K> extends AbstractHashTable<K> implements HashTableInterface<K> {

	public HashTableQP(int capacity) {
		super(capacity);
	}
	
	protected int getNextIndex(int currIndex, int i) {
		return normalizeIndex(currIndex + (i*i));
	}
	
}
