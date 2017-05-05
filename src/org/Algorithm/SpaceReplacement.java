package org.Algorithm;

/**
 * Created by Ellen on 2017/5/5.
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */
public class SpaceReplacement {
    public String replaceSpace(StringBuffer str) {
        int oldLength = str.length();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        int newlength = oldLength + count*2;
        str.setLength(newlength);
        newlength--;
        for (int k = oldLength - 1;k >= 0 && newlength >= 0; k--){
            if (str.charAt(k) == ' ') {
                str.setCharAt(newlength--, '0');
                str.setCharAt(newlength--, '2');
                str.setCharAt(newlength--, '%');
            }else {
                str.setCharAt(newlength--, str.charAt(k));
            }
        }
        return str.toString();
    }
}
