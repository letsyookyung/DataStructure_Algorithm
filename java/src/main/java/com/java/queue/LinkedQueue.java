package com.java.queue;

import com.java.list.Node;

public class LinkedQueue<E> implements QueueInterface<E> {
	private Node<E> tail;

	public LinkedQueue() {
		tail = null;
	}


	public static void main(String[] args) {
		LinkedQueue<String> q = new LinkedQueue<>();

		q.enqueue("hello");
		q.enqueue("java");
		q.enqueue("world");
		q.enqueue("!");


		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

		System.out.println(q.isEmpty());

		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

		System.out.println(q.isEmpty());




	}

	@Override
	public void enqueue(E x) {
		Node<E> newNode = new Node<>(x);
		if (isEmpty()) {
			newNode.next = newNode;
			tail = newNode;
		} else {
			newNode.next = tail.next;
			tail.next = newNode;
			tail = newNode;
		}

	}

	@Override
	public E dequeue() {
		if (isEmpty()) return null;
		else {
			Node<E> front = tail.next;
			if (front == tail) {
				tail = null;
			} else {
				tail.next = tail.next.next;
			}
			return front.item;
		}
	}

	@Override
	public E front() {
		if (isEmpty()) return null;
		else return tail.next.item;
	}

	@Override
	public boolean isEmpty() {
		return (tail == null);
	}

	@Override
	public void dequeueAll() {
		tail = null;
	}
}
