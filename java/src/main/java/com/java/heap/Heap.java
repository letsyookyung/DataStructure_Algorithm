package com.java.heap;

public class Heap<E extends Comparable> implements PQInterface<E> {
	private E[] A;
	private int numItems;

	public Heap(int arraySize) { // 기본 초기 생성자
		A = (E[]) new Comparable[arraySize]; // 여기는 Comparable로 선언하고..
		numItems = 0;
	}
	
	
	public Heap(E[] B, int numElements) { // 바깥에서 배열을 받은 경우의 생성자
		A = B;
		numItems = numElements;
	}

	@Override
	public void insert(E newItem) throws PQException {
		if (numItems < A.length) {
			A[numItems] = newItem;
			percolateUp(numItems);
			numItems++;
		} else throw new PQException("HeapErr: Insert()-Overflow!");
	}

	// 스며오르기
	public void percolateUp(int i) {
		int parent = (i-1)/2;
		if (parent >= 0 && A[i].compareTo(A[parent])>0) { //비교
			E tmp = A[i];
			A[i] = A[parent];
			A[parent] = tmp;
			percolateUp(parent); // 계속 이어가는 경우
		}
	}


	@Override
	public E deleteMax() throws PQException {
		if (!isEmpty()) {
			E maxElement = A[0];
			A[0] = A[numItems - 1];
			numItems--;
			percolateDown(0);
			return maxElement;
		} else throw new PQException("HeapErr: DeleteMax()-Underflow");

	}


	public void percolateDown(int i) {
		int leftChild = (2 * i) + 1;
		int rightChild = (2 * i) + 2;
		int child = leftChild; // 디폴트 차일드

		if (child <= numItems - 1) { // 탈출
			if (rightChild <= numItems - 1 && A[leftChild].compareTo(A[rightChild]) < 0) {
				child = rightChild;
			}
			if (A[i].compareTo(A[child]) < 0) {
				E tmp = A[i];
				A[i] = A[child];
				A[child] = tmp;
				percolateDown(child);
			}

		}
	}


	public void buildHeap() {
		if (numItems >= 2) {
			for (int i = (numItems - 2) / 2; i >= 0; i--) {
				percolateDown(i); // i가 parent값이 되도록 해야하는데 -1하면 계산이 안맞누
			}
		}
	}


	@Override
	public E max() throws PQException {
			if (!isEmpty()) {
				return A[0];
			} else throw new PQException("HeapErr: Max()-empty");
		}


	@Override
	public boolean isEmpty() {
		return numItems == 0;
	}

	@Override
	public void clear() {
		A = (E[]) new Object[A.length]; // 여기는 Object로 선언하고..
		numItems = 0;
	}
}
