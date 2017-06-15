package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/6/15. 对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回
 * -1
 */
public class StrStr {
	public int strStr(String source, String target) {
		// write your code here
        if (source == null || target == null) {
            return -1;
        }

        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            // finished loop, target found
            if (j == target.length()) {
                return i;
            }
        }
        return -1;

    }

	public static void main(String[] args) {
		StrStr ss = new StrStr();
		int i = ss.strStr("acbjhfjkdhfud", "jhf");
		System.out.println(i);
	}
}
