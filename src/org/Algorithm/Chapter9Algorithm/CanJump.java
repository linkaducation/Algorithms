package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/5/30. 给出一个非负整数数组，你最初定位在数组的第一个位置。 数组中的每个元素代表你在那个位置可以跳跃的最大长度。 判断你是否能到达数组的最后一个位置。
 */
public class CanJump {
	public boolean canJump(int[] A) {
		// wirte your code here
		if (A.length <= 0) {
			return false;
		}
		int len = A.length;
		int[] array = new int[len];
		array[0] = A[0];
		if (array[0] <= 0) {
			return false;
		}
		for (int i = 1; i < len; i++) {
			if (array[i - 1] - 1 >= A[i]) {
				array[i] = array[i - 1] - 1;
			} else {
				array[i] = A[i];
			}
			if (i == len - 1) {
				return true;
			}
			if (array[i] <= 0) {
				return false;
			}
		}
		return true;
	}
}
