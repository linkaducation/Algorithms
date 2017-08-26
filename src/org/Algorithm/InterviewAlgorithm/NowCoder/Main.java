package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/12.
 * 5
 1 2
 5 3
 4 6
 7 5
 9 0
 */
public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    //run method
    public void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] para = new int[N];
        for (int i = 0; i < N; i++) {
            para[i] = sc.nextInt();
        }
        Arrays.sort(para);
        int max = 0;
        int tmp;
        List<Integer> list = new ArrayList<>();
        for (int i = N - 1; i >= 0; i--) {
            list.add(para[i]);
            tmp = getMax(list);
            if (tmp > max) {
                max = tmp;
            }
        }
        System.out.println(max);

    }

    public int getMax(List<Integer> list) {
        int tmp = 0;
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return list.get(list.size() - 1) * sum;
    }
}

