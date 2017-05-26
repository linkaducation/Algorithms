package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/5/26.
 * 找出两个拍好数的数组的第K大的数 例如[1,2,4,6,7] [1,2,3,4,5]中第四大的数为2
 */
public class MediamOfTwoSortArray {
	public int getNokOfTwoArray(int[] array1, int[] array2, int k) {
		if (k > array1.length + array2.length) {
			return -1;
		}
		return findK(array1, 0, array2, 0, k);
	}

	private int findK(int[] A, int a_start, int[] B, int b_start, int k) {
		if (a_start >= A.length) {
			return B[b_start + k - 1];
		}
		if (b_start >= B.length) {
			return A[a_start + k - 1];
		}
		if (k == 1) {
			return Math.min(A[a_start], B[b_start]);
		}
		int A_key = a_start + k / 2 - 1 < A.length ? A[a_start + k / 2 - 1] : Integer.MAX_VALUE;
		int B_key = b_start + k / 2 - 1 < B.length ? B[b_start + k / 2 - 1] : Integer.MAX_VALUE;
		if (A_key < B_key) {
			return findK(A, a_start + k / 2, B, b_start, k - k / 2);
		} else {
			return findK(A, a_start, B, b_start + k / 2, k - k / 2);
		}
	}

	public static void main(String[] args) {
		MediamOfTwoSortArray mt = new MediamOfTwoSortArray();
		int mediam = mt.getNokOfTwoArray(new int[] { 1, 2, 5, 6, 7, 8 }, new int[] { 9, 10 }, 8);
		System.out.println(mediam);
	}
}
