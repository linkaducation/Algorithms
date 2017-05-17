package org.Algorithm;

import sun.security.util.Length;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/5/17.
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法
 */
public class multiply {
    public int[] multiply(int[] A) {
        if (A == null || A.length <= 0) {
            return new int[]{};
        }
        int len = A.length, count = 1;
        int[] result = new int[len];
        int[] right = new int[len];
        for (int i = 0; i < len; i++) {
            right[i] = A[i];
        }
        for (int i = 0; i < len; i++) {
            int temp = 1;
            for (int j = i + 1; j < len; j++) {
                temp *= right[j];
            }
            result[i] = count * temp;
            count *= A[i];
        }
        return result;
    }

    public int[] multiply2(int[] str) {
        if (str == null || str.length <= 0) {
            return new int[]{};
        }
        int Length = str.length;
        int[] forword = new int[Length];
        int[] backword = new int[Length];
        int[] result = new int[Length];
        forword[0] = 1;
        backword[Length - 1] = 1;
        for (int i = 1; i < Length; i++) {
            forword[i] = forword[i - 1] * str[i - 1];
            backword[Length - i - 1] = backword[Length - i] * str[Length - i];
        }
        for (int i = 0; i < Length; i++) {
            result[i] = forword[i] * backword[i];
        }
        return result;

    }

    public static void main(String[] args) {
        multiply multiply = new multiply();

        long start1 = System.currentTimeMillis();
        int[] result = multiply.multiply(new int[]{1,2,3,4,5});
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        int[] result2 = multiply.multiply2(new int[]{1,2,3,4,5});
        long end2 = System.currentTimeMillis();

        System.out.println(Arrays.toString(result) + "--->" + (end1 - start1));
        System.out.println(Arrays.toString(result2) + "--->" + (end2 - start2));
    }
}
