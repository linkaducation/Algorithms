package org.Algorithm.SwordForOffer.HelperClass;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/5/18.
 */
public class ContainerMerge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int len1 = in.nextInt();
            int len2 = in.nextInt();
            int temp = len1 + len2;
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < temp; i++) {
                set.add(in.nextInt());
            }
            Object[] array = set.toArray();
            int[] arr = new int[array.length];
            for (int j = 0; j < array.length; j++) {
                arr[j] = (int) array[j];
            }
            Arrays.sort(arr);
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + " ");
            }
        }
    }
}
