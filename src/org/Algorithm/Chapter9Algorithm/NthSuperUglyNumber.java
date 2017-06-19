package org.Algorithm.Chapter9Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ellen on 2017/6/19.
 * 写一个程序来找第 n 个超级丑数。
 * 超级丑数的定义是正整数并且所有的质数因子都在所给定的一个大小为 k 的质数集合内。
 * 比如给你 4 个质数的集合 [2, 7, 13, 19], 那么 [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] 是前 12 个超级丑数。
 */
public class NthSuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // Write your code here
        List<Integer> uglys = new ArrayList<Integer>();
        uglys.add(1);

        int[] p = new int[primes.length];

        for (int i = 1; i < n; i++) {
            int lastNumber = uglys.get(i - 1);
            for (int j = 0; j < primes.length; j++) {
                while (uglys.get(p[j]) * primes[j] <= lastNumber) p[j]++;
            }

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, uglys.get(p[j]) * primes[j]);
            }

            uglys.add(min);
        }
        return uglys.get(n - 1);
    }

    public static void main(String[] args) {
        NthSuperUglyNumber nu = new NthSuperUglyNumber();
        int i = nu.nthSuperUglyNumber(6, new int[]{2, 7, 13, 19});
        System.out.println(i);
    }
}
