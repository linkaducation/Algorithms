package org.Algorithm.InterviewAlgorithm.Aiqiyi;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/9/10.
 */
public class Prblem1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            String s = in.next();
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                sb1.append(s);
            }
            String s2 = in.next();
            int m = in.nextInt();
            for (int i = 0; i < m; i++) {
                sb2.append(s2);
            }
            String string1 = sb1.toString();
            String string2 = sb2.toString();
            String res = "Equal";
            if (string1.length() > string2.length()) {
                res = "Greater";
            } else if (string1.length() < string2.length()) {
                res = "Less";
            } else {
                int i = 0;
                for (; i < string1.length(); i++) {
                    if (string1.charAt(i) < string2.charAt(i)) {
                        res = "Less";
                        break;
                    } else if (string1.charAt(i) > string2.charAt(i)) {
                        res = "Greater";
                        break;
                    }
                }
                if (i == string1.length()) {
                    res = "Equal";
                }
            }
            System.out.println(res);
        }
    }

}
