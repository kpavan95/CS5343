package com.assignments.assignment6;

public interface HashTableInterface<K> {

	public void put(K n);

	public int getCurrentCollisions();

	public int getTotalCollisions();

}
