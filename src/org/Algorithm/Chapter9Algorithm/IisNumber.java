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
        s = s.trim();
        if (s == null || s.length() <= 0) {
            return false;
        }
        if (String.valueOf(s.charAt(0)).equals("+") || String.valueOf(s.charAt(0)).equals("-")) {
            s = s.substring(1);
        }
        if (s.contains("e")) {
            int index = s.indexOf("e");
            if (index == 0 || index == s.length() - 1) {
                return false;
            }
            String[] es = s.split("e");
            if (es.length > 2) {
                return false;
            }
            for (String e : es) {
                if (!isaNumber(e)) {
                    return false;
                }
            }
        } else {
            if (String.valueOf(s.charAt(0)).equals(".")) {
                if (s.length() == 1) {
                    return false;
                }
                s = s.substring(1);
            }
            if (!isaNumber(s)) {
                return false;
            }
        }
        return true;

    }

    private boolean isaNumber(String s) {
        String f = String.valueOf(s.charAt(0));
        if (!f.equals("-")) {
            int num = s.charAt(0) - '0';
            if (num < 0 || num > 9) {
                return false;
            }
        } else {
            if (s.length() <= 1) {
                return false;
            }
            if (String.valueOf(s.charAt(1)).equals(".")) {
                return false;
            }
        }
        if (f.equals(".")) {
            return false;
        }
        boolean flag = false;
        for (int i = 1; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals(".")) {
                if (flag) {
                    return false;
                }
                flag = true;
                continue;
            }
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IisNumber num = new IisNumber();
        boolean flag = num.isNumber(" -.1 ");
        System.out.println(flag);
    }

}
