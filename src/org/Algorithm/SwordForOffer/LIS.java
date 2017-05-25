package org.Algorithm.SwordForOffer;

/**
 * Created by Ellen on 2017/5/11.
 * LIS(Longest increasing subsequence)
 * 最长递增数
 */
public class LIS {
    public int Lis(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int len = -1000;
        int tempLen = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= array[i - 1]) {
                tempLen += array[i];
                len = tempLen > len ? tempLen : len;
            } else {
                tempLen = 1;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        LIS lis = new LIS();
        int len = lis.Lis(new int[]{1, 2, 3, 3, 1, 2, 3, 4, 5, 8});
        System.out.println(len);
    }
}
