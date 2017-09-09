package org.Algorithm.Chapter9Algorithm;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/9/6.
 */
public class Heap {

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.buildHeap(new int[]{1, 2, 3, 4, 55, 6, 7}, 6);
    }

    public void heapAdjust(int[] arr, int start, int end) {
        int temp = arr[start];
        for (int i = start * 2 + 1; i <= end; i *= 2) {
            if (i < end && arr[i] < arr[i + 1]) {
                i++;
            }
            if (temp > arr[i]) {
                break;
            }
            arr[start] = arr[i];
            start = i;
        }
        arr[start] = temp;
    }

    public void buildHeap(int[] heap, int n) {
        for (int i = n / 2; i >= 0; i--) {
            heapAdjust(heap, i, n);
        }

        for (int i = n; i >= 0; i--) {
            int temp = heap[i];
            heap[i] = heap[0];
            heap[0] = temp;

            heapAdjust(heap, 0, i - 1);
        }

        System.out.println(Arrays.toString(heap));
    }
}
