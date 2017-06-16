package org.Algorithm.Chapter9Algorithm;

import java.util.ArrayList;

/**
 * Created by Ellen on 2017/6/15. 给定n个不同的正整数，整数k（1<= k <= n）以及一个目标数字。 在这n个数里面找出K个数，使得这K个数的和等于目标数字，你需要找出所有满足要求的方案
 */
public class KSumII {
	ArrayList<ArrayList<Integer>> res = null;

	public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
		// write your code here
		res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<>();
        dfs(A, target, k, A.length - 1,list);
        return res;
	}

	private void dfs(int[] arr, int target, int k, int index, ArrayList<Integer> list) {
		if (target == 0 && k == 0) {
			res.add(new ArrayList<>(list));
			return;
		}
		if (target < 0 || k < 0 || index < 0) {
			return;
		}
		dfs(arr, target, k, index - 1, list);
		list.add(arr[index]);
		dfs(arr, target - arr[index], k - 1, index, list);
        list.remove(list.size() - 1);
	}
}
