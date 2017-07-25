package org.Algorithm.InterviewAlgorithm.Sort;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/7/25.
 * 快排
 */
public class QuickSort {

	private void quickSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int s = start, e = end;
		int index = arr[start];
		while (start < end) {
			while (start < end && arr[end] > index) {
				end--;
			}
			if (start < end) {
				arr[start] = arr[end];
			}
			while (start < end && arr[start] < index) {
				start++;
			}
			if (start < end) {
				arr[end--] = arr[start];
			}
		}
		arr[start] = index;
		quickSort(arr, s, start - 1);
		quickSort(arr, start + 1, e);
	}

	public static void main(String[] args) {
		int[] arr = new int[]{5, 4, 2, 9, 4, 6, 0, 100, 999, -10, -60};
		QuickSort quickSort = new QuickSort();
		quickSort.quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
