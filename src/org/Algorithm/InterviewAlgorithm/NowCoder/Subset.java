package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ellen on 2017/8/4.
 * 请编写一个方法，返回某集合的所有非空子集。给定一个int数组A和数组的大小int n，
 * 请返回A的所有非空子集。保证A的元素个数小于等于20，且元素互异。各子集内部从大到小排序,子集之间字典逆序排序
 */
public class Subset {
	public ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
		// write code here
		//总共有2^n-1种情况（n是数组个数），每种情况代表一个数，一个数的各位代表取或者不取
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(A);
		int max = 1 << n;
		for (int k = max - 1; k >= 1; k--) {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for (int i = k, index = 0; i > 0; i >>= 1, index++) {
				if ((i & 1) == 1) {
					arr.add(0, A[index]);
				}
			}
			list.add(arr);
		}
		return list;
	}


	public static void main(String[] args) {
		Subset subset = new Subset();
		ArrayList<ArrayList<Integer>> subsets = subset.getSubsets(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 10);
		for (ArrayList<Integer> integers : subsets) {
			System.out.println(Arrays.toString(integers.toArray()));
		}
	}

}
