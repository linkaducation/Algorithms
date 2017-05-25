package org.Algorithm.SwordForOffer;

/**
 * Created by Ellen on 2017/5/14.
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    private int first = -1;
    private int last = -1;

    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        getFirstIndex(array, 0, array.length / 2, k);
        getLastIndex(array, (array.length) / 2, array.length - 1, k);
        int temp;
        if (first == -1 && last == -1) {
            return 0;
        } else {
            return first == last ? 1 : last - first + 1;
        }
    }

    //计算第一个k出现的位置
    private void getFirstIndex(int[] array, int start, int end, int k) {
        if (array[start] > k) {
            return;
        }
        if (array[end] == k) {
            if (end > 0) {
                if (array[end - 1] == k) {
                    getFirstIndex(array, start, end - 1, k);
                } else {
                    first = end;
                }
            } else {
                first = 0;
                return;
            }
        } else if (array[end] > k) {
            getFirstIndex(array, start, start + (end - start) / 2, k);   //start + (end - start) / 2 为了防止溢出
            getLastIndex(array, start + (end - start) / 2, end, k);
        } else {
            return;
        }
    }

    //计算最后一个k出现的位置
    private void getLastIndex(int[] array, int start, int end, int k) {
        if (array[end] < k) {
            return;
        }
        if (array[start] == k) {
            if (end > start) {
                if (array[start + 1] == k) {
                    getLastIndex(array, start + 1, end, k);
                } else {
                    last = start;
                }
            } else {
                last = end;
                return;
            }
        } else if (array[start] < k) {
            if (start == end - 1) {
                return;
            }
            getFirstIndex(array, start, start + (end - start) / 2, k);
            getLastIndex(array, start + (end - start) / 2, end, k);
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        GetNumberOfK gn = new GetNumberOfK();
        int i = gn.GetNumberOfK(new int[]{1, 2, 3, 3, 3, 3}, 3);
        System.out.println(gn.last + " " + gn.first + " " + i);
        int j = gn.GetNumberOfK(new int[]{0, 3, 3, 3, 4, 5, 6}, 3);
        System.out.println(gn.last + " " + gn.first + " " + j);
        int k = gn.GetNumberOfK(new int[]{0, 1, 2, 3, 4, 5, 6}, 3);
        System.out.println(gn.last + " " + gn.first + " " + k);

        int l = gn.GetNumberOfK(new int[]{}, 3);
        System.out.println(gn.last + " " + gn.first + " " + l);

        int m = gn.GetNumberOfK(new int[]{3,3,3,3,4,5}, 3);
        System.out.println(gn.last + " " + gn.first + " " + m);
    }
}
