package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/6/25.
 */
public class Replacement {
	public String replaceSpace(String iniString, int length) {
		// write code here
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < iniString.length(); i++) {
			if (iniString.charAt(i) == ' ') {
				sb.append("%20");
			} else {
				sb.append(String.valueOf(iniString.charAt(i)));
			}
		}
		return sb.toString();
	}
}
