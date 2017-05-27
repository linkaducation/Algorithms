package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/5/27. 给出一个整数数组 nums 和一个整数 k。划分数组（即移动数组 nums 中的元素），使得：
 * 
 * 所有小于k的元素移到左边 所有大于等于k的元素移到右边 返回数组划分的位置，即数组中第一个位置 i，满足 nums[i] 大于等于 k。
 */
public class PartitionArray {
	public int partitionArray(int[] nums, int k) {
		if (nums.length <= 0 || nums == null) {
			return 0;
		}
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			while (start <= end && nums[start] < k) {
				start++;
			}
			while (start <= end && nums[end] >= k) {
				end--;
			}
			if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
		}
		return start;
	}

    public static void main(String[] args) {
        PartitionArray pa = new PartitionArray();
        int i = pa.partitionArray(new int[]{9,9,9,8,9,8,7,9,8,8,8,9,8,9,8,8,6,9}, 9);
        System.out.println(i);
    }
}
