package org.Algorithm.Chapter9Algorithm;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/21.
 */
public class MinUgly {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s= in.next();
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                int j = i;
                while (j < s.length() - 1 && s.charAt(i) == s.charAt(j + 1)
                        && s.charAt(j) != '?') {
                    j++;
                    System.out.println(s.charAt(i));
                }
                count = count + j - i;
                i = j;
            }
            for (int i = 1; i < s.length() - 1; i++) {
                int j = i;
                while (s.charAt(j) == '?' && j < s.length() - 1) {
                    j++;
                }
                if (j != i && (j - i) % 2 == 0 && s.charAt(i - 1) == s.charAt(j)
                        && s.charAt(i - 1) != '?' && s.charAt(j) != '?') {
                    count++;
                    System.out.println(String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1)));
                }
                if (j != i && (j - i) % 2 == 1 && s.charAt(i - 1) != s.charAt(j)
                        && s.charAt(i - 1) != '?' && s.charAt(j) != '?') {
                    count++;
                    System.out.println(String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1)));
                }
                i = j;
            }
            System.out.println(count);
        }
    }
}
