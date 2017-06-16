package org.Algorithm.Chapter9Algorithm;

import java.util.HashSet;

/**
 * Created by Ellen on 2017/6/16.
 * 实现一个算法确定字符串中的字符是否均唯一出现
 */
public class IsUnique {
    //version1
    public boolean isUnique(String str) {
        // write your code here
        char[] array = str.toCharArray();
        if (array.length <= 1) {
            return true;
        }
        HashSet<Character> set = new HashSet<>(array.length);
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                return false;
            }
            set.add(array[i]);
        }
        return true;
    }

    //version2
    public boolean isUnique2(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
