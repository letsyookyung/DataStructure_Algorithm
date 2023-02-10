package com.java.sorting;



public class AdvancedSorting {
	int[] A;

	public AdvancedSorting(int[] B) {
		A = B;
	}


	public static void main(String[] args) {
		int[] B = new int[6];
//		int i = 0;
//		while (i <= B.length-1) {
//			int random = (int) ((Math.random() * (30)) + 1);
//			for (int j = 0; j <= i; j++) {
//				if (!(B[j].equals(random))) {
//			B[i++] = random;
//					break;
//				}

		B[0] = 6;
		B[1] = 4;
		B[2] = 4;
		B[3] = 2;
		B[4] = 10;
		B[5] = 1;
//		B[6] = 2;
//		B[7] = 7;
//		B[8] = 6;
//		B[9] = 6;



		AdvancedSorting s = new AdvancedSorting(B);

//		s.mergeSort();
//		s.quickSort();
//		s.shellSort();


	}


	public void mergeSort() {
		int[] B = new int[A.length];
		mSort(0, A.length - 1, B);
	}

	public void mSort(int p, int r, int[] B) {
		if (p < r) {
			int q = (p + r) / 2;
			mSort(p, q, B);
			mSort(q + 1, r, B);
			merge(p, q, r, B);
		}
	}


	public void merge(int p, int q, int r, int[] B) {
		int i = p;
		int j = q + 1;
		int t = 0;

		while (i <= q && j <= r) {
			if (A[i] < A[j]) {
				B[t++] = A[i++];
			} else {
				B[t++] = A[j++];
			}
		}

		while (i <= q) {
			B[t++] = A[i++];
		}

		while (j <= r) {
			B[t++] = A[j++];
		}

		i = p;
		t = 0;
		while (i <= r) {
			A[i++] = B[t++];
		}

	}

	public void quickSort() {
		qSort(0, A.length - 1);
	}


	public void qSort(int p, int r) { // 마지막 자리의 원소부터 시작하기
		if (p < r) {
			int q = partition(p, r); // 새로운 피봇 등장
			qSort(p, q - 1); // 왼쪽도 동일하게 partition 돌리고, 더이상 돌릴게 없어진 상태면
			qSort(q + 1, r); // 오른쪽도 동일하게 ~~
		}
	}


	public int partition(int p, int r) {
		int x = A[r];
		int i = p - 1;
		int tmp;

		for (int j = p; j <= r - 1; j++) {
			if (A[j] < x) { //피봇보다 작은게 나타나면,
				i++; // 왼쪽배열 한칸 늘리고,
				tmp = A[i]; // 작은게 나타난 j번째 애랑 스왑
				A[i] = A[j];의
				A[j] = tmp;
			}
		}

		tmp = A[i + 1]; // 다 정리되면,
		A[i + 1] = A[r]; // 피봇보다 작은애랑 큰애랑의 중간에 위치하도록
		A[r] = tmp;

		return i + 1; // 피봇의 인덱스 return


	}


	public void heapSort() {
		buildHeap();
		int tmp;
		for (int i = A.length-1; i >=1; i--) {
			tmp = A[0];
			A[0] = A[i];
			A[i] = tmp;
			percolateDown(0, i-1); // 기존 힙구조에서 대상으로하는 배열의 개수가 하나씩 줄어드는것만 다름
		}

	}

	public void buildHeap() {
		if (A.length >=2) {
			for (int i = (A.length-2) / 2; i >= 0; i--) {
				percolateDown(i, A.length-1);
			}
		}
	}


	public void percolateDown(int i, int n) {
		int child = 2 * i + 1;
		int rightChild = 2 * i + 2;

		if ((rightChild <= n) && (A[child] < A[rightChild])) {
			child = rightChild;
		}

		if (A[i] < A[child]){
			int tmp = A[i];
			A[i] = A[child];
			A[child] = tmp;
			percolateDown(child, n);
		}

	}


	public void shellSort() {
		for (int h = A.length/3; h > 2; h = h/5 -1) {
			for (int k = 0; k <= h-1; k++) {
				stepInsertionSort(k,h);
			}
		}
		stepInsertionSort(0,1);
	}


	void stepInsertionSort(int k, int h) {
		int j, insItem;
		for (int i = k+h; i <= A.length-1; i += h) {
			insItem = A[i];
			for (j = i-h; j >= 0 && A[j] > insItem; j -= h) {
				A[j+h] = A[j];
			}
			A[j+h] = insItem;
		}
	}

}
