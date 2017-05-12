package org.Algorithm;

/**
 * Created by Ellen on 2017/5/12.
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 归并排序的变体
 */
public class InversePairs {
    int count;

    public int InversePairs(int[] array) {
        count = 0;
        if (array != null) {
            System.out.println(array.length);
            mergeSortUp2Down(array, 0, array.length - 1);
        }
        return count % 1000000007;
    }

    private void mergeSortUp2Down(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (end + start) >> 1;
        mergeSortUp2Down(array, start, mid);
        mergeSortUp2Down(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    private void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                count += mid - i + 1 % 1000000007;
                count %= 1000000007;
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= end) {
            temp[k++] = array[j++];
        }
        for (int z = 0; z < temp.length; z++) {
            array[start + z] = temp[z];
        }
    }

    public static void main(String[] args) {
        InversePairs ip = new InversePairs();
        int i = ip.InversePairs(new int[]{2, 3, 1, 4, 4, 6, 4, 3, 2});
        System.out.println(i);
    }
}
