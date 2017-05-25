package org.Algorithm.Chapter9Algorithm;

import java.util.ArrayList;

/**
 * Created by Ellen on 2017/5/25.
 * 传入一个数组，返回数组的所有子集
 */
public class SubSet {
	public ArrayList<ArrayList<Integer>> getSubSet(int[] nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		subSetHelper(result,list,nums,0);
		return result;
	}

	private void subSetHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] nums, int pos) {
		result.add(new ArrayList<>(list));
		for (int i = pos; i < nums.length; i++) {
			list.add(nums[i]);
			subSetHelper(result, list, nums, i + 1);
			list.remove(list.size() - 1);
		}
	}

    public static void main(String[] args) {
        SubSet ss = new SubSet();
        ArrayList<ArrayList<Integer>> subSet = ss.getSubSet(new int[]{1, 2, 3, 4, 5});
        for (ArrayList<Integer> integers : subSet) {
            System.out.println(integers);
        }
    }
}
