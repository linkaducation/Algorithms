package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/7/3.
 * 请编写程序交换一个数的二进制的奇数位和偶数位。（使用越少的指令越好）
 */
public class ExchangeOddEven {

	public int exchangeOddEven(int x) {
		// write code here
		return ((x & 0xaaaaaaaa) >>> 1 | (x & 0x55555555) << 1);
	}
}
