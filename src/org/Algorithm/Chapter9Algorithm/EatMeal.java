package org.Algorithm.Chapter9Algorithm;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/21.
 * 输入包括两行,第一行包含两个整数n和A(1 ≤ n ≤ 200, 1 ≤ A ≤ 1,000,000,000)
 第二行包括n个整数,表示牛牛依次遇到的草料堆大小a_i(1 ≤ a_i ≤ 1,000,000,000)
 */
public class EatMeal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int weight = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                if (weight == arr[i]) {
                    weight *= 2;
                }
            }
            System.out.println(weight);
        }
    }
}
