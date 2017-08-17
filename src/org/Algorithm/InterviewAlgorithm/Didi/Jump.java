package org.Algorithm.InterviewAlgorithm.Didi;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/17.
 */
public class Jump {
    private static int minEnergy = Integer.MIN_VALUE;
    private static String res = new String();
    private static int n = 0, m = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            n = in.nextInt();
            m = in.nextInt();
            int energy = in.nextInt();
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = in.nextInt();
                }
            }
            jump(map, 0, 0, energy, new StringBuilder());
            if (res.equals("")) {
                System.out.println("Can not escape!");
            } else {
                System.out.println(res.substring(0, res.length() - 1));
            }
        }
    }

    private static void jump(int[][] map, int row, int col,
                             int energy, StringBuilder sb) {
        map[row][col] = 2;
        if (row == 0 && col == m - 1) {
            if (energy >= 0) {
                sb.append("[" + row + "," + col + "],");
                res = sb.toString();
                map[row][col] = 1;
                return;
            }
            map[row][col] = 1;
            return;
        }
        StringBuilder s = new StringBuilder();
        s.append(sb.toString()).append("[" + row + "," + col + "],");
        if (row < n - 1 && map[row + 1][col] == 1) {
            jump(map, row + 1, col, energy, s);
        }
        if (row > 0 && map[row - 1][col] == 1) {
            jump(map, row - 1, col, energy - 3, s);
        }
        if (col < m - 1 && map[row][col + 1] == 1) {
            jump(map, row, col + 1, energy - 1, s);
        }
        if (col > 0 && map[row][col - 1] == 1) {
            jump(map, row, col - 1, energy - 1, s);
        }
        map[row][col] = 1;
    }

}
