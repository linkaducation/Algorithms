package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/5/26.
 * 输入一个波峰数组，返回数组的peek
 */
public class PeekOfArray {
	private static int findPeekOfArray(int[] array) {
		int end = array.length - 1;
		if (end <= 2) {
			return 0;
		}
		if (array[0] > array[1]) {
			return array[0];
		}
		if (array[end] > array[end - 1]) {
			return array[end];
		}
		int start = 0;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (array[mid] == array[mid + 1]) {
				start++;
			} else if (array[mid] < array[mid + 1]) {
				start = mid;
			} else if (array[mid] > array[mid + 1]) {
				end = mid;
			}
		}
		if (array[start] > array[end]) {
			return array[start];
		} else {
			return array[end];
		}
	}

	public static void main(String[] args) {
		int i = findPeekOfArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 4, 3, 1 });
		System.out.println(i);
	}
}
