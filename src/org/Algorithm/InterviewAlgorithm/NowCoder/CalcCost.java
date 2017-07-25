package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/7/3.
 */
public class CalcCost {

	public int calcCost(int A, int B) {
		// write code here
		int num = A ^ B;
		int count = 0;
		while (num > 0) {
			count++;
			num = num & (num - 1);
		}
		return count;
	}
}
