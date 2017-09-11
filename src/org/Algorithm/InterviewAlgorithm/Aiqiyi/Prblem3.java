package org.Algorithm.InterviewAlgorithm.Aiqiyi;

import java.util.*;

/**
 * Created by Ellen on 2017/9/10.
 *
 * 判断1<=i<=n   1<=j<=m中， i + j + 2sqrt(i) * sqrt(j)为整数的i,j组合数
 */
public class Prblem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int i = 1; i <= a; i++) {
            solve(i, map1);
        }
        for (int j = 1; j <= b; j++) {
            solve(j, map2);
        }
        int res = 0;
        for (Integer key : map1.keySet()) {
            if (map2.containsKey(key)) {
                res += map1.get(key) * map2.get(key);
            }
        }
        System.out.println(res);
    }


    private static void solve(int k, HashMap<Integer, Integer> map) {
        for (int i = (int) Math.sqrt(k); i > 0; i--) {
            if (k % (i * i) == 0) {
                Integer a = map.get(k / (i * i));
                if (a == null) a = 0;
                map.put(k / (i * i), a + 1);
                return;
            }
        }
    }

}
