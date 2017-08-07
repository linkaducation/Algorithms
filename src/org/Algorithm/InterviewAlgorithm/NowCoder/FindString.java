package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/8/7.
 * 有一个排过序的字符串数组，但是其中有插入了一些空字符串，请设计一个算法，找出给定字符串的位置。算法的查找部分的复杂度应该为log级别。
 * 给定一个string数组str,同时给定数组大小n和需要查找的string x，请返回该串的位置(位置从零开始)。
 */
public class FindString {
	public static int findString(String[] str, int n, String x) {
		// write code here
		int start = 0, end = n - 1;
		int mid;
		while (start <= end) {
			mid = (start + end) / 2;
			int tempMid = mid;
			while (tempMid > start && str[tempMid].equals("")) {
				tempMid--;
			}
			if (str[tempMid].equals(x)) {
				return tempMid;
			} else if (tempMid == start || str[tempMid].compareTo(x) < 0) {
				start = mid + 1;
			} else if (str[tempMid].compareTo(x) > 0) {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int c = findString(new String[]{"a", "b", "", "c", "", "d"}, 6, "b");
		System.out.println(c);
	}

}
