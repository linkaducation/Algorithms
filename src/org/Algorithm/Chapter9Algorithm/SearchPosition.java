package org.Algorithm.Chapter9Algorithm;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Ellen on 2017/5/26. 寻找一个数在有序队列的插入位置
 */
public class SearchPosition {
	private int solution(int[] array, int target) {
		int len = array.length - 1;
		if (target < array[0]) {
			return 0;
		}
		if (target > array[len]) {
			return len + 1;
		}
		int start = 0;
		int end = len;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				start = mid;
			} else if (array[mid] > target) {
				end = mid;
			}
		}
		if (array[start] >= target) {
			return start;
		} else if (array[end] >= target) {
			return end;
		} else {
			return end + 1;
		}
	}

	public static void main(String[] args) {
		SearchPosition sp = new SearchPosition();
		int solution = sp.solution(new int[] { 1, 2, 3, 6, 6, 7, 8, 9 }, 10);
		System.out.println(solution);
	}
}
