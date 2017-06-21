package org.Algorithm.Chapter9Algorithm;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/21.
 * 输入包括两行,第一行为一个整数n(2 ≤ n ≤ 50),即序列的长度。
 第二行n个整数,表示序列的每个元素a_i(1 ≤ a_i ≤ 50),以空格分割。
 输出一个整数,表示羊羊可以得到的不同的序列个数
 */
public class GetCountSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[i] != arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        count++;
                    }
                }
            }
            if (count == 0) {
                System.out.println(1);
                return;
            }
            System.out.println(count);
        }
    }
}
