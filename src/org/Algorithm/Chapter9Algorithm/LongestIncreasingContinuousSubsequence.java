package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/5/30. 给定一个整数数组（下标从 0 到 n-1， n 表示整个数组的规模），请找出该数组中的最长上升连续子序列。（最长上升连续子序列可以定义为从右到左或从左到右的序列。）
 */
public class LongestIncreasingContinuousSubsequence {
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] dppre = new int[A.length];
        int[] dppost = new int[A.length];
        dppre[0] = 1;
        dppost[0] = 1;
        int pre = 0, post = 0;
        for (int i = 1; i < A.length; i++) {
            dppre[i] = 1;
            dppost[i] = 1;
            if (A[i - 1] < A[i]) {
                dppre[i] = dppre[i - 1] + 1;
            } else {
                dppost[i] = dppost[i - 1] + 1;
            }
            pre = Math.max(pre, dppre[i]);
            post = Math.max(post, dppost[i]);
        }
        return Math.max(pre, post);
    }

    public static void main(String[] args) {
        LongestIncreasingContinuousSubsequence lc = new LongestIncreasingContinuousSubsequence();
        int i = lc.longestIncreasingContinuousSubsequence(new int[]{99, 55, 7, 29, 80, 33, 19, 23, 6,
                35, 40, 27, 44, 74, 5, 17, 52, 36, 67, 32, 37, 42, 18, 77, 66, 62, 97, 79, 60, 94, 30, 2, 85,
                22, 26, 91, 3, 16, 8, 0, 48, 93, 39, 31, 63, 13, 71, 58, 69, 50, 21, 70, 61, 43, 12, 88, 47, 45, 72, 76});
        System.out.println(i);
    }
}
