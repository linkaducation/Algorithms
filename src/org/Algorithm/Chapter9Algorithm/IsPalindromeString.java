package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/6/16.
 * 判断字符串是否是回文串，忽略大小写
 */
public class IsPalindromeString {
    public boolean isPalindrome(String s) {
        // Write your code here
        if (s == null) {
            return false;
        }
        if (s.equals("")) {
            return true;
        }
        int pre = 0,pos = s.length() - 1;
        while (pre < pos) {
            String pr = String.valueOf(s.charAt(pre));
            String po = String.valueOf(s.charAt(pos));
            if (":., ?=+-!".contains(pr)) {
                pre++;
                continue;
            }
            if (":., ?=+-!".contains(po)) {
                pos--;
                continue;
            }
            if (!pr.equalsIgnoreCase(po)) {
                return false;
            }
            pre++;
            pos--;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindromeString ips = new IsPalindromeString();
        boolean res = ips.isPalindrome("race a car");
        System.out.println(res);
    }
}
