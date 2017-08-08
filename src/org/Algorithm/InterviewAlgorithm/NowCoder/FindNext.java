package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Random;
import java.util.Stack;

/**
 * Created by Ellen on 2017/8/8.
 * 现在我们有一个int数组，请你找出数组中每个元素的下一个比它大的元素。
 * 给定一个int数组A及数组的大小n，请返回一个int数组，代表每个元素比他大的下一个元素,若不存在则为-1。保证数组中元素均为正整数。
 */
public class FindNext {

	public static int[] findNext(int[] A) {
		int[] res = new int[A.length];
		res[A.length - 1] = -1;
		Stack<Integer> stack = new Stack<>();
		stack.push(A[A.length - 1]);
		for (int i = A.length - 2; i >= 0; i--) {
			while (!stack.isEmpty() && A[i] >= stack.peek()) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				res[i] = -1;
			} else {
				res[i] = stack.peek();
			}
			stack.push(A[i]);
		}
		return res;
	}

	public static int[] findNext(int[] A, int n) {
		// write code here
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			int j = i + 1;
			for (; j < n; j++) {
				if (A[i] < A[j]) {
					res[i] = A[j];
					break;
				}
			}
			if (j == n) {
				res[i] = -1;
			}
		}
		res[n - 1] = -1;
		return res;
	}

	public static void main(String[] args) {
		int[] arr = new int[1000000];
		Random r = new Random();
		for (int i = 0; i < 1000000; i++) {
			arr[i] = r.nextInt(100);
		}
		long s1 = System.currentTimeMillis();
		int[] next = findNext(arr, arr.length);
		long s2 = System.currentTimeMillis();
		int[] next1 = findNext(arr);
		long s3 = System.currentTimeMillis();
		System.out.println((s2 - s1) + " : " + (s3 - s2));
	}
}
