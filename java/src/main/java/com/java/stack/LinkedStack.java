package com.java.stack;

import com.java.list.Node;

public class LinkedStack<E> implements StackInterface<E> {
	private Node<E> topNode;
	private final E ERROR = null;

	public LinkedStack() {
		topNode = null;
	}

	public static void main(String[] args) {
		LinkedStack<Integer> s = new LinkedStack<>();

		s.push(100);
		s.push(200);
		s.push(600);

		System.out.println(s.pop());
		System.out.println(s.top());

		System.out.println(s.isEmpty());
		s.popAll();

		System.out.println(s.isEmpty());
	}


	@Override
	public void push(E newItem) {
		/*
		newNode.item = x
		newNode.next = topNode (현재의탑)
		topNode = newNode (다시 새로운 탑은 뉴노드)
		 */
		topNode = new Node<>(newItem, topNode);
	}

	@Override
	public E pop() {
		if (isEmpty()) return null;
		Node<E> poppedNode = topNode;
		topNode = topNode.next;
		return poppedNode.item;
	}

	@Override
	public E top() {
		return topNode.item;
	}

	@Override
	public boolean isEmpty() {
		return topNode == null;
	}

	@Override
	public void popAll() {
		topNode = null;
	}
}
