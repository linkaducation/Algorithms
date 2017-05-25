package org.Algorithm.SwordForOffer;

/**
 * Created by Ellen on 2017/5/7.
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 */
public class Fibonacci {
    public int countFibonacci(int n) {
        int count1 = 1;
        int count2 = 0;
        int count = 1;
        if (n == 0) {
            count = 0;
        } else if (n == 1 || n == 2) {
            count = 1;
        } else {
            while (n > 0) {
                count = count2 + count1;
                count1 = count2;
                count2 = count;
                n--;
            }
        }
        return count;
    }
}
