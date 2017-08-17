package org.Algorithm.InterviewAlgorithm.HaoWeilai;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Ellen on 2017/8/17.
 */
public class DeleteChar {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String sub = in.nextLine();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < sub.length(); i++) {
                if (!set.contains(sub.charAt(i))) {
                    set.add(sub.charAt(i));
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (!set.contains(s.charAt(i))) {
                    sb.append(s.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
