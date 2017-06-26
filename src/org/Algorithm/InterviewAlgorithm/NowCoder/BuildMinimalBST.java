package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/6/26.
 * 对于一个元素各不相同且按升序排列的有序序列，请编写一个算法，创建一棵高度最小的二叉查找树。
 * 给定一个有序序列int[] vals,请返回创建的二叉查找树的高度
 */
public class BuildMinimalBST {

	int hight = 0;

	public int buildMinimalBST(int[] vals) {
		// write code here
		int len = vals.length + 1;
		int k = 1;
		int j = 1;
		while ((k = k << 1) < len) {
			j++;
		}
		return j;
	}

	public static void main(String[] args) {
		BuildMinimalBST buildMinimalBST = new BuildMinimalBST();
		int i = buildMinimalBST.buildMinimalBST(new int[]{1, 2, 3, 4, 5});
		System.out.println(i);
	}
}
