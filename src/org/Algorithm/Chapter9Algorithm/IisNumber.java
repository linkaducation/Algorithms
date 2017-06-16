package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/6/16.
 * 验证一个字符串是否是数字
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * "2e.2" =>false
 */
public class IisNumber {
    public boolean isNumber(String s) {
        // Write your code here
        if (s == null || s.length() <= 0) {
            return false;
        }
                
    }

    private boolean isaNumber(String s) {
        String f = String.valueOf(s.charAt(0));
        if (!f.equals("-")) {
            int num = s.charAt(0) - '0';
            if (num < 0 || num > 9) {
                return false;
            }
        }
        for (int i = 1; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            if (n < 0 || n > 9) {
                return false;
            }
        }
        return true;
    }

}
