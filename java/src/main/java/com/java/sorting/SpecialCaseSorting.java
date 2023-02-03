package com.java.sorting;

public class SpecialCaseSorting {
	int[] A;

	public SpecialCaseSorting(int[] B) {
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


		SpecialCaseSorting s = new SpecialCaseSorting(B);

//		s.mergeSort();
//		s.quickSort();
//		s.shellSort();


		s.countingSort();

	}


	public void countingSort() {
		int[] cntSize = theLargestSmallest();
		int k = cntSize[0] - cntSize[1] ;

		int[] cnt = new int[k]; // k개 cnt 배열 만듬
		int[] accArr = new int[k];
		int[] B = new int[A.length];

		for (int i = 0; i <= A.length - 1; i++) {
			cnt[A[i]]++;
		}

		int result = 0;
		for (int i = 0; i <= k-1; i++) {
			for (int j = 0; j <= i; j++) {
				result += cnt[j];
			}
			accArr[i] = result-1;
			result = 0;
		}

		for (int i = A.length-1; i >= 0 ; i--) {
			B[accArr[A[i]]] = A[i];
			accArr[A[i]]--;
		}
	}


	int[] theLargestSmallest() {
		int max = 0;
		int small = 0;
		int[] result = new int[2];
		for (int i = 0; i <= A.length - 1; i++) {
			if (A[i] > max) {
				max = A[i];
			}
			if (A[i] < small) {
				small = A[i];
			}
		}
		result[0] = max;
		result[1] = small;

		return result;
	}


	public void radixSort() {

	}


	public void bucketSort() {

	}


}
