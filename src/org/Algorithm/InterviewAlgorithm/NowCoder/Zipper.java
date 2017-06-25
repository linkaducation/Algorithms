package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/6/25.
 */
public class Zipper {
	public String zipString(String iniString) {
		// write code here
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < iniString.length(); i++) {
			int temp = 1;
			while (i + 1 < iniString.length() && iniString.charAt(i) == iniString.charAt(i + 1)) {
				temp++;
				i++;
			}
			sb.append(String.valueOf(iniString.charAt(i)) + temp);
		}
		if (sb.toString().length() >= iniString.length()) {
			return iniString;
		}
		return sb.toString();
	}

}
