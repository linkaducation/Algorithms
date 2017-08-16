package org.Algorithm.InterviewAlgorithm.netease;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/16.
 */
public class JumpStep {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int start = in.nextInt();
            int end = in.nextInt();
            int[] step = new int[end + 1];
            for (int i = start; i <= end; i++) {
                step[i] = Integer.MAX_VALUE;
            }
            step[start] = 0;
            for (int i = start; i <= end; i++) {
                if (step[i] == Integer.MAX_VALUE) {
                    continue;
                }
                ArrayList<Integer> list = getAllDivisor(i);
                for (int j = 0; j < list.size(); j++) {
                    int temp = i + list.get(j);
                    if (temp <= end && step[temp] > step[i] + 1) {
                        step[temp] = step[i] + 1;
                    }
                }
            }
            System.out.println(step[end] == Integer.MAX_VALUE ? -1 : step[end]);
        }
    }

    private static ArrayList<Integer> getAllDivisor(int target) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 2; j <= Math.sqrt(target); j++) {
            if (target % j == 0) {
                list.add(j);
                if (j != target / j) {
                    list.add(target / j);
                }
            }
        }
        return list;
    }
}
