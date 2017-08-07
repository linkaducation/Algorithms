package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/8/7.
 * 有一个排过序的数组，包含n个整数，但是这个数组向左进行了一定长度的移位，例如，原数组为[1,2,3,4,5,6]，
 * 向左移位5个位置即变成了[6,1,2,3,4,5],现在对于移位后的数组，需要查找某个元素的位置。请设计一个复杂度为log级别的算法完成这个任务。
 * 给定一个int数组A，为移位后的数组，同时给定数组大小n和需要查找的元素的值x，请返回x的位置(位置从零开始)。保证数组中元素互异。
 */
public class Finder {


	public int findElement(int[] A, int n, int x) {
		// write code here
		int[] res = new int[1];
		getNum(A, 0, n - 1, x, res);
		return res[0];
	}

	private void getNum(int[] arr, int start, int end, int target, int[] res) {
		if (start >= end) {
			return;
		}
		int mid = (start + end) / 2;
		if (target == arr[mid]) {
			res[0] = mid;
			return;
		}
		if (target == arr[start]) {
			res[0] = start;
			return;
		}
		if (target == arr[end]) {
			res[0] = end;
			return;
		}
		if (target > arr[start]) {
			if (arr[mid] > arr[start] && target > arr[mid]) {
				getNum(arr, mid, end, target, res);
			} else {
				getNum(arr, start, mid, target, res);
			}
		} else {
			if (target < arr[mid] && arr[mid] < arr[end]) {
				getNum(arr, start, mid, target, res);
			} else {
				getNum(arr, mid, end, target, res);
			}
		}


	}

	public static void main(String[] args) {
		Finder finder = new Finder();
		int element = finder.findElement(new int[]{6, 7, 8, 9, 10, 11, 12, 13, 14, 1, 2, 3, 4, 5}, 14, 5);
		System.out.println(element);
	}
}
