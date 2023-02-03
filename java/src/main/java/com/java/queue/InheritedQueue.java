package com.java.queue;

import com.java.list.LinkedList;

public class InheritedQueue<E> extends LinkedList<E> implements QueueInterface<E> {
	public InheritedQueue() {
		super();
	}

	public static void main(String[] args) {
		InheritedQueue<String> q = new InheritedQueue<>();

		q.enqueue("e");
		q.enqueue("g");
		q.enqueue("z");
		q.enqueue("d");

		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

		System.out.println(q.isEmpty());

		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

		System.out.println(q.isEmpty());

	}


	@Override
	public void enqueue(E x) {
		append(x);
	}

	@Override
	public E dequeue() {
		return remove(0);
	}

	@Override
	public E front() {
		return get(0);
	}

	@Override
	public void dequeueAll() {
		clear();
	}
}
