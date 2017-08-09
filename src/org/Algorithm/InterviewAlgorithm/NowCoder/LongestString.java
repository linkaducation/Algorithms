package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ellen on 2017/8/9.
 * 有一组单词，请编写一个程序，在数组中找出由数组中字符串组成的最长的串A，即A是由其它单词组成的(可重复)最长的单词。
 * 给定一个string数组str，同时给定数组的大小n。请返回最长单词的长度，保证题意所述的最长单词存在。
 */
public class LongestString {

	public static void main(String[] args) {
		LongestString ls = new LongestString();
		int longest = ls.getLongest(new String[]{"a", "bc", "abc"}, 6);
		System.out.println(longest);
	}

	public int getLongest(String[] str, int n) {
		// write code here
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});
		HashMap<String, Boolean> map = new HashMap<>();
		for (String s : str) {
			map.put(s, null);
		}
		for (String s : str) {
			if (canBuildWord(s, true, map)) {
				return s.length();
			}
		}
		return 0;
	}

	private boolean canBuildWord(String str, boolean isOriginal, Map<String, Boolean> map) {
		if (map.containsKey(str) && !isOriginal) {
			return true;
		}
		for (int i = 0; i < str.length(); i++) {
			String left = str.substring(0, i);
			String right = str.substring(i);
			if (map.containsKey(left) && canBuildWord(right, false, map)) {
				return true;
			}
		}
		return false;
	}
}