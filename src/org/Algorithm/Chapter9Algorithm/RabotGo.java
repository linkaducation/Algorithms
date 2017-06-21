package org.Algorithm.Chapter9Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/21.
 * 有一条无限长的纸带,分割成一系列的格子,最开始所有格子初始是白色。
 * 现在在一个格子上放上一个萌萌的机器人(放上的这个格子也会被染红),
 * 机器人一旦走到某个格子上,就会把这个格子涂成红色。现在给出一个整数n,
 * 机器人现在会在纸带上走n步。每一步,机器人都会向左或者向右走一个格子,
 * 两种情况概率相等。机器人做出的所有随机选择都是独立的。现在需要计算出最后纸带上红色格子的期望值。
 */
public class RabotGo {
    static ArrayList<Double> list = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            double k = 1;
            for (int i = 0; i < n; i++) {
                k = k * 0.5;
            }
            boolean[] visit = new boolean[n];
            Arrays.fill(visit, false);
            for (int i = 0; i < n; i++) {
                Go(visit, i, n, k);
            }
            double res = 0;
            for (Double aDouble : list) {
                res = res + aDouble;
            }
            System.out.println(res);
        }
    }

    private static void Go(boolean[] visited, int index, int n, double k) {
        if (n == 0) {
            int res = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    res++;
                }
            }
            list.add(k * res);
            return;
        }
        if (index >= visited.length || index < 0 || n < 0) {
            return;
        }
        boolean[] newarray = Arrays.copyOf(visited, visited.length);
        newarray[index] = true;
        Go(newarray, index + 1, n - 1, k);
        newarray[index] = false;
        Go(newarray, index - 1, n + 1, k);
    }
}
