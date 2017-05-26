package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/5/26. 找出旋转数组的最小元素
 */
public class minNumberInRotateArray {
	public int minNumberInRotateArray(int[] array) {
		if (array.length <= 0) {
			return 0;
		}
		int start = 0;
		int end = array.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (array[start] == array[mid]) {
				start++;
			} else if (array[start] > array[mid]) {
				end = mid;
			} else if (array[start] < array[mid]) {
				start = mid;
			}
		}

		if (array[start] < array[end]) {
			return array[start];
		} else {
			return array[end];
		}
	}

	public static void main(String[] args) {
		minNumberInRotateArray mr = new minNumberInRotateArray();
		int i = mr.minNumberInRotateArray(new int[] { 3, 4, 5, 6, 6, 6, 0, 1, 2 });
		System.out.println(i);
	}
}
