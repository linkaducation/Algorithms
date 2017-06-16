package org.Algorithm.Chapter9Algorithm;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/6/16.
 * 判断数独是否正确
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //row
        boolean[] visited = new boolean[9];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited,false);
            for (int j = 0; j < 9; j++) {
                if (!isValidSudoku(visited, board[i][j])) {
                    return false;
                }
            }
        }
        //col
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited,false);
            for (int j = 0; j < 9; j++) {
                if (!isValidSudoku(visited, board[j][i])) {
                    return false;
                }
            }
        }
        //trangle
        for(int i = 0; i<9; i+= 3){
            for(int j = 0; j<9; j+= 3){
                Arrays.fill(visited, false);
                for(int k = 0; k<9; k++){
                    if(!isValidSudoku(visited, board[i + k/3][ j + k%3]))
                        return false;
                }
            }
        }


        return true;
    }

    private boolean isValidSudoku(boolean[] visited, char key) {
        if (key == '.') {
            return true;
        }
        int value = key - '0';
        if (value < 1 || value > 9 ||visited[value - 1]) {
            return false;
        }
        visited[value - 1] = true;
        return true;
    }


}
