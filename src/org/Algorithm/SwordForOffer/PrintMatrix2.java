package org.Algorithm.SwordForOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Ellen on 2017/8/25.
 */
public class PrintMatrix2 {

    public static void main(String[] args) {
        ArrayList<Integer> integers = printMatrix(new int[][]{{1, 2, 3, 4}});
        System.out.println(Arrays.toString(integers.toArray()));
        ArrayList<Integer> list = new ArrayList<>();
        Collections.copy(list, integers);
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        int len = matrix.length;
        int width = matrix[0].length;
        boolean[][] isVisited = new boolean[len][width];
        ArrayList<Integer> list = new ArrayList<>();
        int flag = 0;
        int row = 0, col = 0;
        while (list.size() < len * width) {
            switch (flag) {
                case 0:
                    while (col < width && !isVisited[row][col]) {
                        list.add(matrix[row][col]);
                        isVisited[row][col++] = true;
                    }
                    row++;
                    col--;
                    flag = 1;
                    break;
                case 1:
                    while (row < len && !isVisited[row][col]) {
                        list.add(matrix[row][col]);
                        isVisited[row++][col] = true;
                    }
                    flag = 2;
                    col--;
                    row--;
                    break;
                case 2:
                    while (col >= 0 && !isVisited[row][col]) {
                        list.add(matrix[row][col]);
                        isVisited[row][col--] = true;
                    }
                    flag = 3;
                    row--;
                    col++;
                    break;
                case 3:
                    while (row >= 0 && !isVisited[row][col]) {
                        list.add(matrix[row][col]);
                        isVisited[row--][col] = true;
                    }
                    flag = 0;
                    col++;
                    row++;
                    break;
            }
        }
        return list;
    }
}
