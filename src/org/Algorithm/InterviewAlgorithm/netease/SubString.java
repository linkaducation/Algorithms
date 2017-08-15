package org.Algorithm.InterviewAlgorithm.netease;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/15.
 */
public class SubString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            String sub = in.next();
            int i = 0, j = 0;
            boolean flag = true;
            for (; i < sub.length(); ) {
                for (; j < s.length(); j++) {
                    if (sub.charAt(i) == s.charAt(j)) {
                        i++;
                        j++;
                        break;
                    }
                }
                if (j == s.length() && i != sub.length()) {
                    flag = false;
                    break;
                }
            }
            System.out.println(flag ? "Yes" : "No");
        }
    }
}
