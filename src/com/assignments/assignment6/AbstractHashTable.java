package com.assignments.assignment6;

import static com.assignments.assignment6.Constants.NEWLINE;
import static com.assignments.assignment6.Constants.TAB;

import java.util.logging.Logger;

@SuppressWarnings("unchecked")
public abstract class AbstractHashTable<K> implements HashTableInterface<K> {

	private static Logger logger = Logger.getLogger(AbstractHashTable.class.getName());

	private static final double DEFAULT_LOAD_FACTOR = 0.5;

	protected int totalCollisions, currentCollisions, capacity, size, threshold;
	protected double loadFactor;
	protected K[] keys;

	@Override
	public int getCurrentCollisions() {
		return this.currentCollisions;
	}

	@Override
	public int getTotalCollisions() {
		return this.totalCollisions;
	}

	public AbstractHashTable(int capacity) {
		this(capacity, DEFAULT_LOAD_FACTOR);
	}

	protected AbstractHashTable(int capacity, double loadFactor) {
		if (capacity <= 0)
			throw new IllegalArgumentException("Illegal capacity: " + capacity);

		if (loadFactor <= 0 || Double.isNaN(loadFactor) || Double.isInfinite(loadFactor))
			throw new IllegalArgumentException("Illegal loadFactor: " + loadFactor);

		this.loadFactor = loadFactor;
		this.capacity = capacity;
		threshold = (int) (this.capacity * loadFactor);
		keys = (K[]) new Object[this.capacity];
	}

	protected final int normalizeIndex(int keyHash) {
		return (keyHash & 0x7FFFFFFF) % capacity;
	}

	protected void increaseCapacity() {
		capacity = (2 * capacity) + 1;
	}

	public void put(K key) {
		if (key == null) {
			throw new IllegalArgumentException("Null key");
		}
		if (size >= threshold) {
			resizeTable();
		}
		boolean insearted = false;
		final int offset = normalizeIndex(key.hashCode());

		int index = offset;

		for (int i = 0; index < capacity; i++) {

			index = getNextIndex(index, i);

			if (keys[index] == null) {
				keys[index] = key;
				insearted = true;
				break;
			}
			if (i == 0) {
				totalCollisions++;
				currentCollisions++;
			}
		}
		if (insearted) {
			size++;
		} else {
			logger.warning("Was not able to insert Key: " + key);
		}
	}

	protected abstract int getNextIndex(int index, int i);

	protected void resizeTable() {
		increaseCapacity();

		threshold = (int) (capacity * loadFactor);

		K[] oldKeyTable = keys;
		keys = (K[]) new Object[capacity];

		// Reset the key count and buckets used since we are about to
		// re-insert all the keys into the hash-table.
		size = currentCollisions = 0;

		for (int i = 0; i < oldKeyTable.length; i++) {
			if (oldKeyTable[i] != null) {
				put(oldKeyTable[i]);
			}
			oldKeyTable[i] = null;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("HashTable").append(NEWLINE);
		sb.append("Index").append(TAB).append("=").append(TAB).append("Key").append(NEWLINE);
		for (int i = 0; i < capacity; i++) {
			if (keys[i] != null) {
				sb.append(i).append(TAB).append("=").append(TAB).append(keys[i]).append(NEWLINE);
			}
		}
		return sb.toString();
	}
}
