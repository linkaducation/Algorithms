package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/6/25.
 * 反转字符串
 */
public class ReverseString {
	public String reverseString(String iniString) {
		// write code here
		StringBuilder sb = new StringBuilder();
		int len = iniString.length() - 1;
		for (int i = 0; i <= len; i++) {
			sb.append(iniString.charAt(len - i));
		}
		return sb.toString();
	}
}
