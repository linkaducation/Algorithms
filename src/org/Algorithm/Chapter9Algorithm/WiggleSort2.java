package org.Algorithm.Chapter9Algorithm;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/6/16.
 * 给你一个没有排序的数组，请将原数组就地重新排列满足如下性质
 */
public class WiggleSort2 {
    public void wiggleSort(int[] nums) {
        // Write your code here
        if (nums == null || nums.length <= 1) {
            return;
        }

        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        isWiggleSort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return;
            }
        }
        isWiggleSort(nums);
    }

    private void isWiggleSort(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            for (; j < arr.length; j++) {
                if (flag) {
                    if (arr[i] > arr[j]) {
                        int k = arr[j];
                        arr[j] = arr[i];
                        arr[i] = k;
                    }
                } else {
                    if (arr[i] < arr[j]) {
                        int k = arr[j];
                        arr[j] = arr[i];
                        arr[i] = k;
                    }
                }
            }
            if (i % 2 == 0) {
                flag = false;
            } else {
                flag = true;
            }
        }
    }

    public static void wiggleSort2(int[] nums) {
        int[] tem = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tem[i] = nums[i];
        }
        int mid = partition(tem, 0, nums.length - 1, nums.length / 2);
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = mid;
        }
        int l, r;
        if (nums.length % 2 == 0) {
            l = nums.length - 2;
            r = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) {
                    ans[l] = nums[i];
                    l -= 2;
                } else if (nums[i] > mid) {
                    ans[r] = nums[i];
                    r += 2;
                }
            }
        } else {
            l = 0;
            r = nums.length - 2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) {
                    ans[l] = nums[i];
                    l += 2;
                } else if (nums[i] > mid) {
                    ans[r] = nums[i];
                    r -= 2;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
    }

    public static int partition(int[] nums, int l, int r, int rank) {
        int left = l, right = r;
        int now = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= now) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= now) {
                left++;
            }
            nums[right] = nums[left];
        }
        if (left - l == rank) {
            return now;
        } else if (left - l < rank) {
            return partition(nums, left + 1, r, rank - (left - l + 1));
        } else {
            return partition(nums, l, right - 1, rank);
        }
    }


    public static void main(String[] args) {
        WiggleSort2 ws = new WiggleSort2();
        int[] arr = new int[]{1, 3, 2, 2, 3, 1};
        int[] arr2 = new int[]{1, 3, 2, 2, 3, 1};
        ws.wiggleSort(arr);
        ws.wiggleSort2(arr2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }

}
