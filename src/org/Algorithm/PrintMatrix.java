package org.Algorithm;

import java.util.ArrayList;

/**
 * Created by Ellen on 2017/5/9.
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0) return result;
        int n = matrix.length, m = matrix[0].length;
        if (m == 0) return result;
        int layers = (Math.min(n, m) - 1) / 2 + 1;//这个是层数
        for (int i = 0; i < layers; i++) {
            for (int k = i; k < m - i; k++) result.add(matrix[i][k]);//左至右
            for (int j = i + 1; j < n - i; j++) result.add(matrix[j][m - i - 1]);//右上至右下
            for (int k = m - i - 2; (k >= i) && (n - i - 1 != i); k--) result.add(matrix[n - i - 1][k]);//右至左
            for (int j = n - i - 2; (j > i) && (m - i - 1 != i); j--) result.add(matrix[j][i]);//左下至左上
        }
        return result;
    }
}
