package com.java.hashTable;

import com.java.list.LinkedList;
import com.java.list.Node;


public class ChainedHashTable implements IndexInterface<Node<Integer>> {
	private LinkedList<Integer>[] table;
	int numItems = 0;


	public static void main(String[] args) {
		ChainedHashTable h = new ChainedHashTable(11);
		h.insert(10);
		h.delete(20);
		h.insert(20);
		h.insert(5);
		h.insert(80);
		h.insert(90);

		h.delete(20);
		h.delete(44);

		Node<Integer> nd = h.search(80);
		if (nd == null) {
			System.out.println("search failed");
		} else {
			System.out.println("found:" + nd.item);
		}


	}

	public ChainedHashTable(int n) {
		table = (LinkedList<Integer>[]) new LinkedList[n];
		for (int i = 0; i < n; i++) {
			table[i] = new LinkedList<>();
		}
		numItems = 0;

	}


	private int hash(Integer x) {
		return x % table.length;
	}


	@Override
	// 삽입
	public void insert(Integer x) {
		int slot = hash(x);
		table[slot].add(0,x);
		numItems++;
	}


	@Override
	// 검색
	public Node<Integer> search(Integer x) {
		int slot = hash(x);
		if (table[slot].isEmpty()) {
			return null;
		} else {
			int i = table[slot].indexOf(x);
			if (i == LinkedList.NOT_FOUND) {
				return null;
			} else {
				return table[slot].getNode(i);
			}
		}
	}


	@Override
	// 삭제
	public void delete(Integer x) {
		if (isEmpty()) {
			/* 에러 처리 */
		} else {
			int slot = hash(x);
			table[slot].removeItem(x);
			numItems--;
		}

	}


	@Override
	public boolean isEmpty() {
		return numItems == 0;
	}


	@Override
	public void clear() {
		for (int i = 0; i < table.length; i++) {
			table[i] = new LinkedList<>();
		}
		numItems = 0;
	}
}
