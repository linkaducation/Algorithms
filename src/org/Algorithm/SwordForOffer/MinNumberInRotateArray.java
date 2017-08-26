package org.Algorithm.SwordForOffer;

/**
 * Created by Ellen on 2017/8/23.
 */
public class MinNumberInRotateArray {

    public static void main(String[] args) {
        int i = minNumberInRotateArray(new int[]{4, 5, 6, 7, 8, 9, 1, 2, 3});
        System.out.println(i);
    }

    public static int minNumberInRotateArray(int[] array) {
        int pre = 0, end = array.length - 1;
        while (pre + 1 < end) {
            int mid = pre + (end - pre) / 2;
            if (array[mid - 1] > array[mid] && array[mid] < array[mid + 1]) {
                return array[mid];
            }
            if (array[mid] < array[pre]) {
                end = mid;
            } else {
                pre = mid;
            }
        }
        if (array[pre - 1] > array[pre] && array[pre] < array[pre] + 1) {
            return array[pre];
        }

        return -1;
    }
}
