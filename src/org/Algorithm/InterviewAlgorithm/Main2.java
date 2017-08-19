package org.Algorithm.InterviewAlgorithm;

import java.util.*;

/**
 * Created by Ellen on 2017/8/19.
 */
public class Main2 {

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
            int[] res = new int[set.size()];
            Iterator<Integer> iterator = set.iterator();
            for (int i = 0; i < set.size(); i++) {
                res[i] = iterator.next();
            }
            quickSort(res, 0, res.length - 1);
            System.out.println(res.length);
            System.out.print(res[0]);
            for (int i = 1; i < res.length; i++) {
                System.out.print(" " + res[i]);
            }
        }
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int s = start, e = end;
        int index = arr[start];
        while (start < end) {
            while (start < end && arr[end] > index) {
                end--;
            }
            if (start < end) {
                arr[start] = arr[end];
            }
            while (start < end && arr[start] < index) {
                start++;
            }
            if (start < end) {
                arr[end--] = arr[start];
            }
        }
        arr[start] = index;
        quickSort(arr, s, start - 1);
        quickSort(arr, start + 1, e);
    }
}
