package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.HashMap;

/**
 * Created by Ellen on 2017/8/8.
 * 请设计一个高效算法，找出数组中两数之和为指定值的所有整数对。
 * 给定一个int数组A和数组大小n以及需查找的和sum，请返回和为sum的整数对的个数。保证数组大小小于等于3000。
 */
public class FindPair {

	public int countPairs(int[] A, int n, int sum) {
		// write code here
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			count += getCount(map, sum - A[i]);
			map.put(A[i], getCount(map, A[i]) + 1);
	}
		return count;
	}

	public int getCount(HashMap<Integer, Integer> map, int value) {
		if (map.containsKey(value)) {
			return map.get(value);
		} else {
			return 0;
		}
	}
}
