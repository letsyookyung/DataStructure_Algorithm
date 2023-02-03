package com.java.queue;

public interface QueueInterface<E> {

	void enqueue(E x);
	E dequeue();
	E front();
	boolean isEmpty();
	void dequeueAll();

}
