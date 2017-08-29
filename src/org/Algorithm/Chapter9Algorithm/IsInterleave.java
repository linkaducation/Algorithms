package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/8/29.
 */
public class IsInterleave {

    public static void main(String[] args) {
        boolean res = isInterleave("aabcc", "dbbca", "aadbbbaccc");
        System.out.println(res);
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s3 == null) {
            return false;
        }
        if (s1 == null) {
            if (s2 != null) {
                return s2.equals(s3);
            }
            return s3 == null;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        boolean[][] map = new boolean[c1.length + 1][c2.length + 1];
        for (int i = 1; i <= c1.length; i++) {
            if (c1[i - 1] == c3[i - 1]) {
                map[i][0] = true;
            }
        }
        for (int i = 1; i <= c2.length; i++) {
            if (c2[i - 1] == c3[i - 1]) {
                map[0][i] = true;
            }
        }
        map[0][0] = true;

        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                if ((map[i - 1][j] && c1[i - 1] == c3[i + j - 1]) ||
                        (map[i][j - 1] && c2[j - 1] == c3[i + j - 1])) {
                    map[i][j] = true;
                }
            }
        }
        return map[c1.length][c2.length];
    }
}
