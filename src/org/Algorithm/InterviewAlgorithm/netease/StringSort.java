package org.Algorithm.InterviewAlgorithm.netease;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/15.
 */
public class StringSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.next();
            }
            boolean isDictionarySort = isDictionarySort(arr);
            boolean isLength = isLength(arr);
            if (isDictionarySort) {
                if (isLength) {
                    System.out.println("both");
                } else {
                    System.out.println("lexicographically");
                }
            } else {
                if (isLength) {
                    System.out.println("lengths");
                } else {
                    System.out.println("none");
                }
            }
        }
    }

    private static boolean isDictionarySort(String[] arr) {
        boolean flag = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(arr[i - 1]) <= 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private static boolean isLength(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() < arr[i - 1].length()) {
                return false;
            }
        }
        return true;
    }

}
