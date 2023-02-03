package com.java.sorting;

public class BasicSorting {
	int[] A;

	public BasicSorting(int[] B) {
		A = B;
	}


	public static void main(String[] args) {
		int[] B = new int[10000];
		for (int i = 0; i <= B.length-1 ; i++) {
			int random = (int) ((Math.random() * (100000)) + 1);
			B[i] = random;
			}

		BasicSorting s = new BasicSorting(B);
//		s.selectionSort();

//		s.bubbleSort();
//		s.bubbleSort_ivy();

//		Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
		long startTime = System.currentTimeMillis();
		s.insertSort_ivy();
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime));
//		Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
//		System.out.println(timestamp2-timestamp1);



	}

	// 선택 정렬
	public void selectionSort() {
		int largestIndex, tmp;

		for (int last = A.length - 1; last >= 1; last--) {
			largestIndex = theLargest(last); // 인덱스
			tmp = A[largestIndex];
			A[largestIndex] = A[last];
			A[last] = tmp;
		}

	}

	public int theLargest(int lastIndex) { // 비교하면서 최댓값 갱신하면서 한바퀴 돌기 (n-1)번 비교
		int largestIndex = 0;
		for (int i = 0; i <= lastIndex; i++) {
			if (A[i] > A[largestIndex]) {
				largestIndex = i;
			}
		}
		return largestIndex;

	}


	// 버블 정렬
	public void bubbleSort_ivy() {
		int tmp = 0;

		for (int k = 0; k <= A.length - 1; k++) {
			for (int i = 0; i <= A.length - 2; i++) {
				if (A[i] > A[i + 1]) {
					tmp = A[i + 1];
					A[i + 1] = A[i];
					A[i] = tmp;
				}
			}
		}
	}


	public void bubbleSort() { //안됨 ㅜ
		int tmp = 0;
		boolean swapped;
		for (int last = A.length - 1; last >= 2; last--) {
			swapped = false;
			for (int i = 0; i <= last - 1; i++) {
				if (A[i] > A[i + 1]) {
					tmp = A[i];
					A[i] = A[i + 1];
					A[i + 1] = tmp;
					swapped = true;
				}
				if (swapped == false) {
					break;
				}
			}
		}
		tmp = tmp;
	}


	// 삽입 정렬
	public void insertSort_ivy() { //시간이 오래걸리지만 이해가 안됨 ㅜㅜ
		for (int i = 1; i <= A.length - 1; i++) {
			int newItem = A[i];
			int j = i - 1;

			for (int k = 0; k <= j; k++) {
				if (A[k] > newItem) {
					int completeArr = i;
					while (completeArr >= k + 1) {
						A[completeArr] = A[completeArr - 1];
						completeArr--;
					}
					A[k] = newItem;
					break;
				}
			}
		}
	}


	public void insertSort() {
		for (int i = 1; i <= A.length-1; i++) {
			int loc = i-1;
			int newItem = A[i];
			while (loc >= 0 && newItem < A[loc]) {
				A[loc+1] = A[loc];
				loc--;
			}
			A[loc+1] = newItem;
		}
	}



}


