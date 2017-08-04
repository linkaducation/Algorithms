package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/8/4.
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 */
public class Parenthesis {
	public boolean chkParenthesis(String A, int n) {
		// write code here
		int crl = 0;
		char[] chars = A.toCharArray();
		for (int i = 0; i < n; i++) {
			if (crl < 0) {
				return false;
			}
			if (chars[i] == '(') {
				crl++;
			} else if (chars[i] == ')') {
				crl--;
			} else {
				return false;
			}
		}
		return crl == 0;
	}
}
