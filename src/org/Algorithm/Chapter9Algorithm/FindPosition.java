package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/6/15. 在一个排序数组中找一个数，返回该数出现的任意位置，如果不存在，返回-1
 */
public class FindPosition {
	public int findPosition(int[] nums, int target) {
		// Write your code here
		int k = findPos(nums, 0, nums.length, target);
		return k == 0 ? -1 : k;
	}

	private int findPos(int[] nums, int start, int end, int target) {
		if (start + 1 >= end) {
			return 0;
		}
		int mid = start + (end - start) / 2;
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] > target) {
			end = mid;
			return findPos(nums, start, end, target);
		} else {
			start = mid;
			return findPos(nums, start, end, target);
		}
	}

}
