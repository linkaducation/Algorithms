package org.Algorithm.SwordForOffer;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/8/25.
 * 欧拉筛选求素数
 */
public class IsPrimeNum {

    public static void main(String[] args) throws InterruptedException {
        getAllPrime(100);
    }

    public static void getAllPrime(int n) {
        boolean[] isPrime = new boolean[n + 10];
        int[] res = new int[n];
        int num = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                res[num++] = i;
            }
            for (int j = 0; j < num; j++) {
                if (i * res[j] > n) {
                    break;
                }
                isPrime[i * res[j]] = true;
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
