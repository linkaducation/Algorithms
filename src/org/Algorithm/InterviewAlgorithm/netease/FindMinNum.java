package org.Algorithm.InterviewAlgorithm.netease;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Ellen on 2017/8/15.
 */
public class FindMinNum {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                set.add(arr[i]);
            }
            Arrays.sort(arr);
            int miss = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > miss + 1) {
                    break;
                }
                miss += arr[i];
            }
            System.out.println(miss + 1);
        }
    }

}
