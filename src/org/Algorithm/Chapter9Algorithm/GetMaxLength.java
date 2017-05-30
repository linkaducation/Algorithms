package org.Algorithm.Chapter9Algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ellen on 2017/5/30.
 * 给出一个字符串s和一个词典，判断字符串s是否可以被空格切分成一个或多个出现在字典中的单词。
 */
public class GetMaxLength {
	private int getMaxLength(Set<String> dict) {
		int maxLength = 0;
		for (String word : dict) {
			maxLength = Math.max(maxLength, word.length());
		}
		return maxLength;
	}

	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return true;
		}

		int maxLength = getMaxLength(dict);
		boolean[] canSegment = new boolean[s.length() + 1];

		canSegment[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			canSegment[i] = false;
			for (int lastWordLength = 1; lastWordLength <= maxLength && lastWordLength <= i; lastWordLength++) {
				if (!canSegment[i - lastWordLength]) {
					continue;
				}
				String word = s.substring(i - lastWordLength, i);
				if (dict.contains(word)) {
					canSegment[i] = true;
					break;
				}
			}
		}

		return canSegment[s.length()];
	}

	public static void main(String[] args) {
		String a = "aaab";
		HashSet<String> set = new HashSet<>();
		set.add("aa");
		set.add("ab");
		set.add("fds");
		GetMaxLength gml = new GetMaxLength();
		boolean b = gml.wordBreak(a, set);
		System.out.println(b);
	}
}
