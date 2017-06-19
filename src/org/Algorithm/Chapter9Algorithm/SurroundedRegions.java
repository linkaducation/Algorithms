package org.Algorithm.Chapter9Algorithm;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/6/19.
 * 给一个二维的矩阵，包含 'X' 和 'O', 找到所有被 'X' 围绕的区域，并用 'X' 填充满。
 */
public class SurroundedRegions {
    public void surroundedRegions(char[][] board) {
        // Write your code here
        if (board == null || board.length <= 1 || board[0].length <= 1) {
            return;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                for (int k = 0; k < visited.length; k++) {
                    Arrays.fill(visited[k], false);
                }
                if (isFilled(board, i, j, visited)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private boolean isFilled(char[][] board, int row, int col, boolean[][] visited) {
        if (board[row][col] == 'X' || visited[row][col] == true) {
            return true;
        }
        visited[row][col] = true;
        if ((row == board.length - 1 || row == 0 || col == board[0].length - 1
                || col == 0) && board[row][col] == 'O') {
            return false;
        }
        return isFilled(board, row - 1, col, visited) && isFilled(board, row + 1, col, visited)
                && isFilled(board, row, col - 1, visited) && isFilled(board, row, col + 1, visited);
    }

    public static void main(String[] args) {
        SurroundedRegions rr = new SurroundedRegions();
        String s1 = "XXXX";
        String s2 = "XOOX";
        String s3 = "XXOX";
        String s4 = "XOXX";
        char[][] res = new char[4][4];
        res[0] = s1.toCharArray();
        res[1] = s2.toCharArray();
        res[2] = s3.toCharArray();
        res[3] = s4.toCharArray();
        rr.surroundedRegions(res);
        for (char[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

}
