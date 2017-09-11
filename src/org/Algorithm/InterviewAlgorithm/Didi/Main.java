package org.Algorithm.InterviewAlgorithm.Didi;

import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[arr.length];
        map.put(0, 0);
        int res = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
            if (map.containsKey(res)) {
                int kk = map.get(res) != null ? map.get(res) : 0;
                dp[i] = Math.max(ans, dp[kk] + 1);
            } else {
                dp[i] = ans;
            }
            ans = Math.max(ans, dp[i]);
            map.put(res, i);
        }
        System.out.println(ans);
    }

}
