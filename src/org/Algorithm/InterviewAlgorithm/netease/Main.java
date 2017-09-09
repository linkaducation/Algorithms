package org.Algorithm.InterviewAlgorithm.netease;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Ellen on 2017/9/9.
 */
public class Main {

    static HashMap<Integer, Integer> map = new HashMap<>();
    static Set<String> set = new HashSet<>();
    static String target;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            target = in.next();
            int len = target.length();
            build("", 0, len);
            int max = -1;
            for (Integer integer : map.values()) {
                max = Math.max(max, integer);
            }
            
            System.out.println(max == -1 ? 0 : max);
        }
    }

    private static void build(String s, int len, int end) {
        if (len == end) {
            if (isTrue(s)) {
                if (set.contains(s)) {
                    return;
                }
                int tem = longestCommonSubsequence(target, s);
                if (map.containsKey(tem)) {
                    map.put(tem, map.get(tem) + 1);
                } else {
                    map.put(tem, 1);
                }
                set.add(s);
            }
            return;
        }
        String left = s + "(";
        build(left, len + 1, end);
        String right = s + ")";
        build(right, len + 1, end);
    }

    public static int longestCommonSubsequence(String A, String B) {
        if (A == null || B == null || A.length() == 0 ||
                B.length() == 0) {
            return 0;
        }
        char[] s1 = A.toCharArray();
        char[] s2 = B.toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[s1.length][s2.length];
    }

    public static boolean isTrue(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count < 0) {
                return false;
            }
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
        }
        return count == 0;
    }

}
