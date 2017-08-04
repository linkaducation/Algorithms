package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/8/4.
 * 在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。给定一个升序数组，元素值各不相同，编写一个方法，
 * 判断在数组A中是否存在魔术索引。请思考一种复杂度优于o(n)的方法。
 * 给定一个int数组A和int n代表数组大小，请返回一个bool，代表是否存在魔术索引。
 */
public class MagicIndex {
	//最优，二分法
	public boolean findMagicIndex(int[] A, int n) {
		// write code here
		int start = 0, end = n - 1;
		while (start + 1 < end) {
			int mid = (start + end) / 2;
			if (A[mid] == mid) {
				return true;
			} else if (A[mid] > mid) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (A[start] == start || A[start + 1] == start + 1) {
			return true;
		}
		return false;
	}


	/**
	 * 在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。给定一个不下降序列，元素值可能相同，编写一个方法，
	 * 判断在数组A中是否存在魔术索引。请思考一种复杂度优于o(n)的方法。
	 * 给定一个int数组A和int n代表数组大小，请返回一个bool，代表是否存在魔术索引。
	 */
	public boolean findMagicIndex2(int[] A, int n) {
		// write code here
		for (int i = 0; i < n; ) {
			if (A[i] == i) {
				return true;
			} else {
				i = Math.max(A[i], i + 1);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		MagicIndex magicIndex = new MagicIndex();
		boolean magicIndex1 = magicIndex.findMagicIndex(new int[]{1, 1, 1, 1, 1, 1}, 6);
		System.out.println(magicIndex1);
	}


}
