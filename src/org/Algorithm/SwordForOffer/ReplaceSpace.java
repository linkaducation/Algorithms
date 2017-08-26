package org.Algorithm.SwordForOffer;

/**
 * Created by Ellen on 2017/8/23.
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String s = replaceSpace(new StringBuffer("we are happy"));
        System.out.println(s);
    }

    public static String replaceSpace(StringBuffer str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        int oldLen = str.length() - 1;
        int len = str.length() + count * 2 - 1;
        str.setLength(len + 1);
        for (int i = oldLen; i >= 0 && len >= 0; i--) {
            if (str.charAt(i) == ' ') {
                str.setCharAt(len--, '0');
                str.setCharAt(len--, '2');
                str.setCharAt(len--, '%');
            } else {
                str.setCharAt(len--, str.charAt(i));
            }
        }
        return str.toString();
    }
}
