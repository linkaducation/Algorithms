package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Ellen on 2017/8/5.
 */
public class Permutate {
    private static int total = 0;

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void perm(char[] arr, int str, int len) {
        if (str == len - 1) {
            System.out.println(Arrays.toString(arr));
            total++;

        } else {
            for (int i = str; i < len; i++) {
                swap(arr, str, i);
                perm(arr, str + 1, len);
                swap(arr, str, i);
            }
        }


    }

    public static void main(String[] args) {
        Permutate permutate = new Permutate();
        ArrayList<String> aa = permutate.Permutation("aa");
        System.out.println(Arrays.toString(aa.toArray()));
    }


    ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() <= 0) {
            return res;
        }
        getPer(str, 0, str.length());
        Collections.sort(res);
        return res;
    }

    private void getPer(String str, int index, int len) {
        if (index == len - 1) {
            res.add(str);
            return;
        }
        for (int i = index; i < len; i++) {
            if (i == index || str.charAt(i) != str.charAt(index)) {
                String a = swap(str, index, i);
                getPer(a, index + 1, len);
            }
        }
    }

    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char tem = chars[i];
        chars[i] = chars[j];
        chars[j] = tem;
        return new String(chars);
    }
}
