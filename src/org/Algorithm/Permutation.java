package org.Algorithm;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Ellen on 2017/5/11.
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
 */
public class Permutation {
    public ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            permutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return res;
    }
    private void permutationHelper(char[] cs, int i, ArrayList<String> list) {
        if (i == cs.length - 1) { //解空间的一个叶节点
            list.add(String.valueOf(cs)); //找到一个解
        } else {
            for (int j = i; j < cs.length; ++j) {
                if (j == i || cs[j] != cs[i]) {
                    swap(cs, i, j);
                    permutationHelper(cs, i + 1, list);
                    swap(cs, i, j); //复位
                }
            }
        }
    }

    private char[] swap(char[] bytes, int i, int j) {
        char temp = bytes[i];
        bytes[i] = bytes[j];
        bytes[j] = temp;
        return bytes;
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        ArrayList<String> list = p.permutation("");
        System.out.println(list);
    }
}
