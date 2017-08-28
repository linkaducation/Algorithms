package org.Algorithm.Chapter9Algorithm;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/8/28.
 * 给出字符串S和字符串T，计算S的不同的子序列中T出现的个数。
 * 子序列字符串是原始字符串通过删除一些(或零个)产生的一个新的字符串，并且对剩下的字符的相对位置没有影响。
 * (比如，“ACE”是“ABCDE”的子序列字符串,而“AEC”不是)。
 * <p>
 * 给出S = "rabbbit", T = "rabbit"
 * 返回 3
 * <p>
 * 思路：Fn[i][j]表示T中第i个字符和S中第j个字符匹配最多有多少种
 * 初始化Fn[i][0] = 0, Fn[0][j] = 1;
 * 状态转移方程：
 * if (S.charAt(j) == T.charAt(i)) :
 * Fn[i][j] = Fn[i][j] = Fn[i - 1][j - 1] + Fn[i][j - 1];
 * else :
 * Fn[i][j] = Fn[i][j - 1];
 */
public class NumDistinct {

    public static void main(String[] args) {
        int res = numDistinct("rrabbbitt", "rabbit");
        System.out.println(res);
    }

    public static int numDistinct(String S, String T) {
        // write your code here
        if (S == null || T == null || S.length() < T.length()) {
            return 0;
        }
        int[][] Fn = new int[T.length() + 1][S.length() + 1];
        Arrays.fill(Fn[0], 1);
        for (int i = 1; i <= T.length(); i++) {
            Fn[i][0] = 0;
            for (int j = 1; j <= S.length(); j++) {
                if (S.charAt(j - 1) == T.charAt(i - 1)) {
                    Fn[i][j] = Fn[i - 1][j - 1] + Fn[i][j - 1];
                } else {
                    Fn[i][j] = Fn[i][j - 1];
                }
            }
        }
//        for (int i = 0; i <= T.length(); i++) {
//            System.out.println(Arrays.toString(Fn[i]));
//        }
        return Fn[T.length()][S.length()];
    }
}
