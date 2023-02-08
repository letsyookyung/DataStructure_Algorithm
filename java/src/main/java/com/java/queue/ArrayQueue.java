package com.java.queue;

public class ArrayQueue<E> implements QueueInterface<E> {
	private E queue[];
	private int front, tail, numItems;
	private static final int DEFAULT_CAPACITY = 64;
	private final E ERROR = null;

	public ArrayQueue() {
		queue = (E[]) new Object[DEFAULT_CAPACITY];
		front = 0;
		tail = DEFAULT_CAPACITY-1;
		numItems = 0;
	}

	public ArrayQueue(int n) {
		queue = (E[]) new Object[n];
		front = 0;
		tail = n-1;
		numItems = 0;
	}


	public static void main(String[] args) {
		ArrayQueue<Integer> q = new ArrayQueue<>(8);

		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		q.enqueue(9);

		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);

		System.out.println(q.front());

		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());



//		for (int i = 0; i <= q.queue.length-1; i++) {
//			System.out.printf("%d번째 큐: %d", i, q[i]);
//		}
//		System.out.println(" ");

//		q.enqueue(8);



	}

	@Override
	public void enqueue(E x) { // 원소 삽입은 tail 만 신경쓰면됨
		if (isFull()) {
			System.out.println("Queue Full!");
		} else {
			tail = (tail + 1) % queue.length; //다음 tail
			queue[tail] = x; //현재 tail에 저장
			++numItems;
		}
	}


	public boolean isFull() {
		return numItems == queue.length;
	}


	@Override
	public E dequeue() {
		if (isEmpty()) {
			System.out.println("Queue Empty!");
		} else {
			E queueFront = queue[front];
			front = (front+1) %  queue.length; // 다음 front
			--numItems;
			return queueFront;
		}
		return null;
	}


	@Override
	public E front() {
		if (isEmpty()) {
			return null;
		}
		return queue[front];
	}

	@Override
	public boolean isEmpty() {
		return (numItems == 0) ;
	}

	@Override
	public void dequeueAll() {
		queue = (E[]) new Object[queue.length];
		numItems = 0;
		front = 0;
		tail = queue.length - 1;
	}
}
