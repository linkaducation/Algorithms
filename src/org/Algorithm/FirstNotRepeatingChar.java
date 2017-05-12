package org.Algorithm;

import java.util.HashMap;

/**
 * Created by Ellen on 2017/5/12.
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置。
 * 如果字符串为空,返回-1
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] array = str.toCharArray();
        System.out.println(array);
        for (int i = 0; i < array.length; i++) {
            if (hashMap.containsKey(array[i])) {
                hashMap.put(array[i], hashMap.get(array[i]) + 1);
            } else {
                hashMap.put(array[i], 1);
            }
        }
        Character value = null;
        System.out.println(hashMap);
        for (int i = 0; i < array.length; i++) {
            if (hashMap.get(array[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar fc = new FirstNotRepeatingChar();
        int google = fc.FirstNotRepeatingChar("google");
        System.out.println(google);
    }
}
