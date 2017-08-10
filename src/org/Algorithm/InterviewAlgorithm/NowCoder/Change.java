package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.*;

/**
 * Created by Ellen on 2017/8/10.
 * 现有一个字典，同时给定字典中的两个字符串s和t，给定一个变换，每次可以改变字符串中的任意一个字符，
 * 请设计一个算法，计算由s变换到t所需的最少步数，同时需要满足在变换过程中的每个串都是字典中的串。
 * 给定一个string数组dic，同时给定数组大小n，串s和串t，请返回由s到t变换所需的最少步数。若无法变换到t则返回-1。
 * 保证字符串长度均小于等于10，且字典中字符串数量小于等于500。
 */
public class Change {

	private boolean flag = false;

	public static void main(String[] args) {
		Change change = new Change();
		int countChanges = change.countChanges(new String[]{"abc","adc","bdc","aaa"}, 4, "abc", "bdc");
		System.out.println(countChanges);
	}

	public int countChanges(String[] dic, int n, String s, String t) {
		// write code here
		Set<String> set = new HashSet<>();
		set.addAll(Arrays.asList(dic));
		set.remove(s);
		Queue<String> queue = new LinkedList<>();
		queue.add(s);
		int length = 0;
		Set<String> container = new HashSet<>();
		while (!queue.isEmpty()) {
			length++;
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				String temp = queue.poll();
				for (int i = 0; i < temp.length(); i++) {
					List<String> strings = changeString(temp, i);
					for (String string : strings) {
						if (container.contains(string)) {
							continue;
						}
						container.add(string);
						if (set.contains(string)) {
							queue.add(string);
						}
						if (string.equals(t)) {
							return length;
						}
					}
				}
			}
		}
		return length;
	}

	private List<String> changeString(String orgin, int index) {
		char[] chars = orgin.toCharArray();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			chars[index] = (char) (i + 'a');
			list.add(new String(chars));
		}
		return list;
	}

}
