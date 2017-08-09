package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/8/9.
 * 现有一个小写英文字母组成的字符串s和一个包含较短小写英文字符串的数组p，请设计一个高效算法，对于p中的每一个较短字符串，判断其是否为s的子串。
 * 给定一个string数组p和它的大小n，同时给定string s，为母串，请返回一个bool数组，每个元素代表p中的对应字符串是否为s的子串。保证p中的串长度小于等于8，
 * 且p中的串的个数小于等于500，同时保证s的长度小于等于1000。
 */
public class Substr {

	public static void main(String[] args) {
		Substr substr = new Substr();
		boolean[] subStr = substr.chkSubStr(new String[]{"a", "b", "c", "d"}, 4, "abc");
		System.out.println(Arrays.toString(subStr));
	}

	public boolean[] chkSubStr(String[] p, int n, String s) {
		// write code here
		trieNode head = new trieNode('0');
		for (int i = 0; i < s.length(); i++) {
			insertNode(s, head, i);
		}
		boolean[] res = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (findChild(p[i], head)) {
				res[i] = true;
			} else {
				res[i] = false;
			}
		}
		return res;
	}

	private boolean findChild(String target, trieNode node) {
		for (int i = 0; i < target.length(); i++) {
			int index = target.charAt(i) - 'a';
			if (node == null || node.next[index] == null) {
				return false;
			}
			node = node.next[index];
		}
		return true;
	}

	private void insertNode(String s, trieNode node, int i) {
		if (i >= s.length()) {
			return;
		}
		int index = s.charAt(i) - 'a';
		if (node.next[index] == null) {
			trieNode child = new trieNode(s.charAt(i));
			node.next[index] = child;
			if (i == s.length() - 1) {
				return;
			}
		}
		insertNode(s, node.next[index], i + 1);
	}

	class trieNode {
		char c;
		trieNode[] next = new trieNode[26];

		trieNode(char c) {
			this.c = c;
		}
	}
}
