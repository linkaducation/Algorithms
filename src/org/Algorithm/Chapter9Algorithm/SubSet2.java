package org.Algorithm.Chapter9Algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ellen on 2017/5/25.
 * 传入一个数组，返回数组的所有子集,去除重复的数
 */
public class SubSet2 {
	public ArrayList<ArrayList<Integer>> getSubSet(int[] nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		Arrays.sort(nums);
		subSetHelper(result, list, nums, 0);
		return result;
	}

	private void subSetHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] nums, int pos) {
		result.add(new ArrayList<>(list));
		for (int i = pos; i < nums.length; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			list.add(nums[i]);
			subSetHelper(result, list, nums, i + 1);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		SubSet2 ss = new SubSet2();
		ArrayList<ArrayList<Integer>> subSet = ss.getSubSet(new int[] { 1, 2, 2, 2, 2, 3, 4, 5 });
		for (ArrayList<Integer> integers : subSet) {
			System.out.println(integers);
		}
	}
}
