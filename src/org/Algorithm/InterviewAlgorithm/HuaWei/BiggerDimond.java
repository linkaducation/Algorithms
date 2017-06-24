package org.Algorithm.InterviewAlgorithm.HuaWei;

import java.util.*;

/**
 * Created by Ellen on 2017/6/24.
 * 小明陪小红去看钻石，他们从一堆钻石中随机抽取两颗并比较她们的重量。这些钻石的重量各不相同。
 * 在他们们比较了一段时间后，它们看中了两颗钻石g1和g2。现在请你根据之前比较的信息判断这两颗钻石的哪颗更重。
 * 给定两颗钻石的编号g1,g2，编号从1开始，同时给定关系数组vector,其中元素为一些二元组，第
 * 一个元素为一次比较中较重的钻石的编号，第二个元素为较轻的钻石的编号。最后给定之前的比较次数n。
 * 请返回这两颗钻石的关系，若g1更重返回1，g2更重返回-1，无法判断返回0。输入数据保证合法，不会有矛盾情况出现。
 * 测试样例：2,3,[[1,2],[2,4],[1,3],[4,3]],4   返回: 1
 */
public class BiggerDimond {

	public static void main(String[] args) {
		int i = find(1, 5, new int[][]{{1, 2}, {2, 4}, {1, 3}, {4, 3}}, 4);
		System.out.println(i);
	}

	private static int find(int g1, int g2, int[][] record, int n) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(n);
		int max = Integer.MIN_VALUE;
		for (int[] ints : record) {
			if (!map.containsKey(ints[0])) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(ints[1]);
				map.put(ints[0], list);
				max = Math.max(max, Math.max(ints[0], ints[1]));
			} else {
				ArrayList<Integer> list = map.get(ints[0]);
				list.add(ints[1]);
				map.put(ints[0], list);
				max = Math.max(max, Math.max(ints[0], ints[1]));
			}
		}
		if (g1 > max || g2 > max) {
			return 0;
		}
		boolean[] isvisitd = new boolean[++max];
		Arrays.fill(isvisitd, false);
		if (counting(g1, g2, map, isvisitd)) {
			return 1;
		} else {
			Arrays.fill(isvisitd, false);
			if (counting(g2, g1, map, isvisitd)) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	private static boolean counting(int start, int end, HashMap<Integer, ArrayList<Integer>> map,
									boolean[] visited) {
		if (start == end) {
			return true;
		}
		if (visited[start] || !map.containsKey(start)) {
			return false;
		}
		visited[start] = true;
		ArrayList<Integer> list = map.get(start);
		for (int i = 0; i < list.size(); i++) {
			int next = list.get(i);
			if (counting(next, end, map, visited)) {
				return true;
			}
		}
		return false;
	}
}
