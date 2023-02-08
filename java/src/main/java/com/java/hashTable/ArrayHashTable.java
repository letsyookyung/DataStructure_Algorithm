package com.java.hashTable;


import com.java.list.Node;

public class ArrayHashTable implements IndexInterface<Integer> {
	private Integer table[];
	int numItems;
	static final Integer DELETED = -12345, NOT_FOUND = -1;


	public static void main(String[] args) {
		ArrayHashTable h = new ArrayHashTable(11);

		h.insert(10);
		h.delete(20);
		h.insert(20);
		h.insert(5);
		h.insert(70);
		h.insert(90);

		h.delete(20);
		h.delete(44);

		int slot = h.search(80);
		if (slot == ArrayHashTable.NOT_FOUND) {
			System.out.println("search failed");
		} else {
			System.out.println("found:" + h.getItem(slot));
		}
	}

	public ArrayHashTable(int n) {
		table = new Integer[n];
		numItems = 0;
		for (int i = 0; i < n; i++) {
			table[i] = null;
		}
	}


	private int hash(int i, Integer x) {
		return (x + 1) % table.length;
	}


	@Override
	public void insert(Integer x) {
		int slot;
		if (numItems == table.length) {
			/* 에러 처리 */
		} else {
			for (int i = 0; i < table.length; i++) {
				slot = hash(i, x);
				if (table[slot] == null || table[slot] == DELETED) {
					table[slot] = x;
					numItems++;
					break;

				}
			}
		}
	}


	@Override
	public Integer search(Integer x) {
		int slot;
		for (int i = 0; i < table.length; i++) {
			slot = hash(i, x);
			if (table[slot] == null) {
				return NOT_FOUND;
			}
			if (table[slot].compareTo(x) == 0) {
				return slot;
			}
		}
		return NOT_FOUND;
	}


	@Override
	public void delete(Integer x) {
		int slot = 0;
		for (int i = 0; i < table.length; i++) {
			slot = hash(i, x);
			if (table[slot] == null) {
				break;
			}
			if (table[slot].compareTo(x) == 0) {
				table[slot] = DELETED;
				numItems--;
				break;
			}
		}
	}


	public Integer getItem(Integer i) {
		return table[i];
	}


	@Override
	public boolean isEmpty() {
		return numItems == 0;
	}


	@Override
	public void clear() {
		numItems = 0;
		for (int i = 0; i < table.length; i++) {
			table[i] = null;
		}
	}

}
