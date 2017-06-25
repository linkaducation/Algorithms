package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/6/25.
 * 假定我们都知道非常高效的算法来检查一个单词是否为其他字符串的子串。请将这个算法编写成一个函数，给定两个字符串s1和s2，
 * 请编写代码检查s2是否为s1旋转而成，要求只能调用一次检查子串的函数。
 * 给定两个字符串s1,s2,请返回bool值代表s2是否由s1旋转而成。字符串中字符为英文字母和空格，区分大小写，字符串长度小于等于1000。
 * "waterbottle","erbottlewat"
 */
public class CheckReverseEqual {
	public boolean checkReverseEqual(String s1, String s2) {
		// write code here
		if (s1.length() != s2.length()) {
			return false;
		}
		String s3 = s1 + s1;
		if (s3.contains(s2)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		CheckReverseEqual checkReverseEqual = new CheckReverseEqual();
//		boolean b = checkReverseEqual.checkReverseEqual("", " ");
		boolean b1 = checkReverseEqual.checkReverseEqual("waterbottle", "erbottlewat");
//		System.out.println(b);
		System.out.println(b1);
	}
}
