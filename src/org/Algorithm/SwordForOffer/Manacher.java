package org.Algorithm.SwordForOffer;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/25.
 * 最长回文子串
 */
public class Manacher {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            System.out.println(Palindrome(in.next()));;
        }
    }

    public static String Palindrome(String s) {
        int len = s.length();
        char[] tem = new char   [len * 2 + 1];
        for (int i = 0,j = 0; i < len; i++) {
            tem[j++] = '#';
            tem[j++] = s.charAt(i);
        }
        tem[len * 2] = '#';
        len = tem.length;
        int[] res = new int[len];
        int index = -1, max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int j = 0;
            while (i - j >= 0 && i + j < len) {
                if (tem[i - j] == tem[i + j]) {
                    j++;
                } else {
                    break;
                }
            }
            res[i] = j;
            if (res[i] > max) {
                max = res[i];
                index = i;
            }
        }
        int start = index - max + 1;
        int end = index + max;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            if (tem[i] != '#') {
                sb.append(tem[i]);
            }
        }
        return sb.toString();
    }
}
