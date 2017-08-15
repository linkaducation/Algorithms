package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/8/10.
 * 有一个方阵，其中每个单元(像素)非黑即白(非0即1)，请设计一个高效算法，找到四条边颜色相同的最大子方阵。
 * 给定一个01方阵mat，同时给定方阵的边长n，请返回最大子方阵的边长。保证方阵边长小于等于100。
 */
public class SubMatrix {

    public static void main(String[] args) {
        SubMatrix subMatrix = new SubMatrix();
        int[][] mat = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int i = subMatrix.maxSubMatrix(mat, 3);
        System.out.println(i);
    }

    public int maxSubMatrix(int[][] mat, int n) {
        // write code here
        int[][] left = new int[n][n];
        int[][] above = new int[n][n];
        init(mat, left, above, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][j] != mat[i - 1][j] || mat[i][j] != mat[i][j - 1]) {
                    if (mat[i][j] != mat[i - 1][j] && mat[i][j] != mat[i][j - 1]) {
                        left[i][j] = 1;
                        above[i][j] = 1;
                    } else if (mat[i][j] != mat[i][j - 1]) {
                        left[i][j] = 1;
                        above[i][j] = above[i - 1][j] + 1;
                    } else {
                        left[i][j] = left[i][j - 1] + 1;
                        above[i][j] = 1;
                    }
                } else {
                    left[i][j] = left[i][j - 1] + 1;
                    above[i][j] = above[i - 1][j] + 1;
                    int min = Math.min(left[i][j - 1], above[i - 1][j]);
                    for (int k = min; k > 0 && min >= max; k--) {
                        if (above[i][j - min] >= (min + 1)
                                && left[i - min][j] >= (min + 1)) {
                            max = Math.max(max, min + 1);
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(left[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(above[i][j] + " ");
            }
            System.out.println();
        }
        return max;

    }

    private void init(int[][] mat, int[][] left, int[][] above, int n) {
        Arrays.fill(above[0], 1);
        left[0][0] = 1;
        for (int i = 1; i < n; i++) {
            left[i][0] = 1;
            if (mat[0][i] != mat[0][i - 1]) {
                left[0][i] = 1;
            } else {
                left[0][i] = left[0][i - 1] + 1;
            }
        }
        for (int i = 1; i < n; i++) {
            if (mat[i][0] != mat[i - 1][0]) {
                above[i][0] = 1;
            } else {
                above[i][0] = above[i - 1][0] + 1;
            }
        }
    }
}
