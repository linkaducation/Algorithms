package org.Algorithm.InterviewAlgorithm.Sort;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/7/25.
 * 归并排序
 */
public class MergeSort {

	//归并
	private void mergeSort(int[] arr, int start, int end, int mid) {
		int[] temp = new int[end - start + 1];
		int low = start, higt = mid + 1, k = 0;
		while (low <= mid && higt <= end) {
			if (arr[low] < arr[higt]) {
				temp[k++] = arr[low++];
			} else {
				temp[k++] = arr[higt++];
			}
		}
		while (low <= mid) {
			temp[k++] = arr[low++];
		}
		while (higt <= end) {
			temp[k++] = arr[higt++];
		}
		for (int i = 0; i < temp.length; i++) {
			arr[start++] = temp[i];
		}
	}

	//分治
	private void merge(int[] arr, int start, int end) {
		int mid = (end - start) / 2 + start;
		if (start < end) {
			merge(arr, start, mid);
			merge(arr, mid + 1, end);
			mergeSort(arr, start, end, mid);
		}
	}

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] arr = new int[]{5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
		mergeSort.merge(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

}
