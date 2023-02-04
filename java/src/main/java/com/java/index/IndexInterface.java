package com.java.index;

public interface IndexInterface<E> {
	void insert(Comparable x);

	E search(Comparable x);

	void delete(Comparable x);

	boolean isEmpty();

	void clear();



}
