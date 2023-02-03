package com.java.stack;

public class ArrayStack<E> implements StackInterface<E> {
	private E stack[];
	private int topIndex;
	private static final int DEFAULT_CAPACITY = 64;
	private final E ERROR = null;


	//생성자1
	public ArrayStack() {
		stack = (E[]) new Object[DEFAULT_CAPACITY];
		topIndex = -1;
	}

	//생성자2
	public ArrayStack(int n) {
		stack = (E[]) new Object[n];
		topIndex = -1;
	}


	public static void main(String[] args) {
		ArrayStack<Integer> s = new ArrayStack<>(10);

		s.push(300);
		s.push(400);
		s.push(500);

		System.out.println(s.pop());
		System.out.println(s.top());

		System.out.println(s.isEmpty());
		s.popAll();

		System.out.println(s.isEmpty());
	}


	@Override
	public void push(E newItem) {
		if (isFull()) {
			System.out.println("stack over flow");
		} else {
			stack[++topIndex] = newItem;
		}

	}

	@Override
	public E pop() {
		if (isEmpty()) {
			System.out.println("stack is empty");
		} else {
			return stack[topIndex--];
		}
		return null;
	}

	@Override
	public E top() {
		if (isEmpty()) {
			System.out.println("stack is empty");
		} else {
			return stack[topIndex];
		}
		return null;
	}


	@Override
	public boolean isEmpty() {
		return topIndex < 0;
	}


	public boolean isFull() {
		return topIndex >= stack.length-1 ;
	}

	@Override
	public void popAll() {
		topIndex = -1;
		stack = (E[]) new Object[stack.length];
	}
}
