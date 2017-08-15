package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/8/14.
 * 有一个正整数和负整数组成的NxN矩阵，请编写代码找出元素总和最大的子矩阵。请尝试使用一个高效算法。
 * 给定一个int矩阵mat和矩阵的阶数n，请返回元素总和最大的子矩阵的元素之和。保证元素绝对值小于等于100000，
 * 且矩阵阶数小于等于200。
 */
public class SubMatrix2 {

    public static void main(String[] args) {
        SubMatrix2 subMatrix = new SubMatrix2();
        int[][] mat = new int[][]{{18, 9, 20, -8}, {28, -12, 27, -1},
                {-26, -20, 15, -7}, {-14, -5, 24, 29}};
        int matrix = subMatrix.sumOfSubMatrix(mat, 4);
        System.out.println(matrix);
    }

    public int sumOfSubMatrix(int[][] mat, int n) {
        // write code here
        int[][] dp = new int[n][n];
        dp[0][0] = mat[0][0];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                max = Math.max(max, getMax(mat, i, j, n));
            }
        }
        return max;
    }

    private int getMax(int[][] mat, int start, int end, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = start; j <= end; j++) {
                count += mat[j][i];
            }
            dp[i] = count;
        }
        int[] arr = new int[n];
        arr[0] = dp[0];
        for (int i = 1; i < n; i++) {
            arr[i] = dp[i];
            arr[i] = Math.max(arr[i], dp[i] + arr[i - 1]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, arr[i]);
        }
        return res;
    }
}
