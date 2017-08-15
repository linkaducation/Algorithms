package org.Algorithm.InterviewAlgorithm.netease;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/15.
 */
public class Palindrome {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String string = in.next();
            String subString = in.next();
            int count = 0;
            for (int i = 0; i <= string.length(); i++) {
                String pre = string.substring(0, i);
                String pos = string.substring(i, string.length());
                if (isPalindrome(pre + subString + pos)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }


    private static boolean isPalindrome(String string) {
        int pre = 0, pos = string.length() - 1;
        boolean flag = true;
        while (pre + 1 < pos) {
            if (string.charAt(pre) != string.charAt(pos)) {
                flag = false;
                break;
            }
            pre++;
            pos--;
        }
        return flag;
    }
}
