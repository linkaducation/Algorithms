package org.Algorithm.Chapter9Algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/21.
 */
public class TryCode {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            if (s.length() <= 1) {
                System.out.println(1);
                break;
            }
            HashSet<String> set = new HashSet<>();
            StringBuilder sb = null;
            for (int i = 0; i < s.length(); i++) {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i + 1, s.length());
                sb = new StringBuilder();
                sb.append(s1);
                sb.append(s2);
                set.add(sb.toString());
            }
            System.out.println(set.size());
            System.out.println(Arrays.toString(set.toArray()));
        }
    }
}
